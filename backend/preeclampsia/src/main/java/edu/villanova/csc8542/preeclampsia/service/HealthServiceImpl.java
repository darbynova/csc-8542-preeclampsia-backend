package edu.villanova.csc8542.preeclampsia.service;

import edu.villanova.csc8542.preeclampsia.config.AppProperties;
import edu.villanova.csc8542.preeclampsia.dto.TokenResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HealthServiceImpl implements HealthService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AppProperties appProperties;
    private RestClient restClient;

    public HealthServiceImpl(AppProperties appProperties, RestClient.Builder restClientBuilder) {
        this.appProperties = appProperties;
        this.restClient = restClientBuilder.baseUrl(appProperties.getBaseUrl()).build();
    }

    public String getBloodPressureResult(String code) {
        // use code to request access token
        String result = requestAccessToken(code);
        logger.debug("result=" + result);

        // parse access token and userID from result
        TokenResponse tokenResponse = convertToTokenResponse(result);

        // Retrieve accessToken and userId
        String accessToken = tokenResponse.getAccessToken();
        String userId = tokenResponse.getUserId();

        logger.debug("AccessToken: " + accessToken);
        logger.debug("UserID: " + userId);

        // Make requests to iHealth API endpoint for blood pressure
        String bloodPressureResult = retrieveBloodPressure(userId, accessToken);

        logger.debug("bloodPressureResult=" + bloodPressureResult);

        return bloodPressureResult;
    }

    private String retrieveBloodPressure(String userId, String accessToken) {
        String bloodPressureResult = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(appProperties.getBloodPressureUri() + userId + "/bp.json")
                        .queryParam("client_id", appProperties.getClientId())
                        .queryParam("client_secret", appProperties.getClientSecret())
                        .queryParam("access_token", accessToken)
                        .queryParam("sc", appProperties.getApiSc())
                        .queryParam("sv", appProperties.getApiSv())
                        .build())
                .retrieve()
                .body(String.class);

        return bloodPressureResult;
    }

    private String requestAccessToken(String code) {
        String result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(appProperties.getAuthorizationUri())
                        .queryParam("client_id", appProperties.getClientId())
                        .queryParam("client_secret", appProperties.getClientSecret())
                        .queryParam("grant_type", appProperties.getGrantType())
                        .queryParam("redirect_uri", appProperties.getRedirectUri())
                        .queryParam("code", code)
                        .build())
                .retrieve()
                .body(String.class);

        return result;
    }

    private TokenResponse convertToTokenResponse(String result) {
        TokenResponse tokenResponse = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Map JSON to Java object
            tokenResponse = objectMapper.readValue(result, TokenResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return tokenResponse;
    }
}
