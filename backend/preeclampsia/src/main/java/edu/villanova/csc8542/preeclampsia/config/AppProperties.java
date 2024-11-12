package edu.villanova.csc8542.preeclampsia.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="app.ihealth")
public class AppProperties {

    private String baseUrl;
    private String authorizationUrl;
    private String clientId;
    private String clientSecret;
    private String responseType;
    private String redirectUri;

    private String apiName;
    private String apiSc;
    private String apiSv;

    @PostConstruct
    public void show() {
        System.out.println("authorizationUrl=" + authorizationUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiSc() {
        return apiSc;
    }

    public void setApiSc(String apiSc) {
        this.apiSc = apiSc;
    }

    public String getApiSv() {
        return apiSv;
    }

    public void setApiSv(String apiSv) {
        this.apiSv = apiSv;
    }
}
