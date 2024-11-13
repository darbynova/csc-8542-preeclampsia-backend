package edu.villanova.csc8542.preeclampsia.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="app.ihealth")
public class AppProperties {

    private String baseUrl;
    private String authorizationUri;
    private String clientId;
    private String clientSecret;
    private String responseType;
    private String grantType;
    private String redirectUri;

    private String bloodPressureUri;

    private String apiName;
    private String apiSc;
    private String apiSv;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAuthorizationUri() {
        return authorizationUri;
    }

    public void setAuthorizationUri(String authorizationUri) {
        this.authorizationUri = authorizationUri;
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

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getBloodPressureUri() {
        return bloodPressureUri;
    }

    public void setBloodPressureUri(String bloodPressureUri) {
        this.bloodPressureUri = bloodPressureUri;
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
