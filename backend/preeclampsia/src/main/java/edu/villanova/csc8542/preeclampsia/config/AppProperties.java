package edu.villanova.csc8542.preeclampsia.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="app.ihealth")
public class AppProperties {

    /*

app.ihealth.authorization-url=https://api.ihealthlabs.com:8443/OpenApiV2/OAuthv2/userauthorization/
app.ihealth.provider=ihealth-provider
app.ihealth.client-id=749b87059be34fa7a05b7d44697cbaf0
app.ihealth.client-secret=db9b5af548e34d9d9200ac0d8582e7f7
app.ihealth.response-type=code
app.ihealth.redirect-uri=http://localhost:8080/redirect

app.ihealth.api-name=OpenApiBP
app.ihealth.api-sc=59d924ee122f4a9dacc08564ed545ecf
app.ihealth.api-sv=27aae441c85c4cc6b2ab97213a95da1a

     */

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
