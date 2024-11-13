package edu.villanova.csc8542.preeclampsia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.villanova.csc8542.preeclampsia.config.AppProperties;
import edu.villanova.csc8542.preeclampsia.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    private AppProperties appProperties;
    private RestClient restClient;

    public HealthController(AppProperties appProperties, RestClient.Builder restClientBuilder) {
        this.appProperties = appProperties;
        this.restClient = restClientBuilder.baseUrl(appProperties.getBaseUrl()).build();
    }

    @GetMapping("/auth")
    public RedirectView redirectToAuth() {

        RedirectView redirectView = new RedirectView(appProperties.getBaseUrl() + appProperties.getAuthorizationUrl());

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id", appProperties.getClientId());
        queryParams.put("response_type", appProperties.getResponseType());
        queryParams.put("redirect_uri", appProperties.getRedirectUri());
        queryParams.put("APIName", appProperties.getApiName());
        queryParams.put("IsNew", "False");

        redirectView.setAttributesMap(queryParams);

        return redirectView;
    }

    @GetMapping("/redirect")
    public ResponseEntity<String> requestAccessToken(@RequestParam String code) {
        System.out.println("code: " + code);

        // use code to request access token
        String result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(appProperties.getAuthorizationUrl())
                        .queryParam("client_id", appProperties.getClientId())
                        .queryParam("client_secret", appProperties.getClientSecret())
                        .queryParam("grant_type", appProperties.getGrantType())
                        .queryParam("redirect_uri", appProperties.getRedirectUri())
                        .queryParam("code", code)
                        .build())
                .retrieve()
                .body(String.class);

        System.out.println("result=" + result);

        // parse access token and userID from result
        String accessToken = null;
        String userId = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Map JSON to Java object
            TokenResponse tokenResponse = objectMapper.readValue(result, TokenResponse.class);

            // Retrieve AccessToken
            accessToken = tokenResponse.getAccessToken();
            userId = tokenResponse.getUserId();

            System.out.println("AccessToken: " + accessToken);
            System.out.println("UserID: " + userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Make requests to iHealth API endpoint for blood pressure
        String finalAccessToken = accessToken;
        String finalUserId = userId;

        String bloodPressureResult = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/openapiv2/user/" + finalUserId + "/bp.json")
                        .queryParam("client_id", appProperties.getClientId())
                        .queryParam("client_secret", appProperties.getClientSecret())
                        .queryParam("access_token", finalAccessToken)
                        .queryParam("sc", appProperties.getApiSc())
                        .queryParam("sv", appProperties.getApiSv())
                        .build())
                .retrieve()
                .body(String.class);

        return ResponseEntity.ok(bloodPressureResult);
    }


}
