package edu.villanova.csc8542.preeclampsia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {

    @JsonProperty("APIName")
    private String apiName;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Expires")
    private int expires;

    @JsonProperty("RefreshToken")
    private String refreshToken;

    @JsonProperty("RefreshTokenExpires")
    private int refreshTokenExpires;

    @JsonProperty("UUID")
    private String uuid;

    @JsonProperty("UserID")
    private String userId;

    @JsonProperty("UserOpenID")
    private String userOpenId;

    @JsonProperty("UserRegion")
    private String userRegion;

    @JsonProperty("client_para")
    private String clientPara;

    @JsonProperty("token_type")
    private String tokenType;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getRefreshTokenExpires() {
        return refreshTokenExpires;
    }

    public void setRefreshTokenExpires(int refreshTokenExpires) {
        this.refreshTokenExpires = refreshTokenExpires;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public String getClientPara() {
        return clientPara;
    }

    public void setClientPara(String clientPara) {
        this.clientPara = clientPara;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}