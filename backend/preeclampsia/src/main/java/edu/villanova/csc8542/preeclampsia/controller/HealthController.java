package edu.villanova.csc8542.preeclampsia.controller;

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

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Map JSON to Java object
            TokenResponse tokenResponse = objectMapper.readValue(result, TokenResponse.class);

            // Retrieve AccessToken
            String accessToken = tokenResponse.getAccessToken();
            System.out.println("AccessToken: " + accessToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("success");
    }

}
