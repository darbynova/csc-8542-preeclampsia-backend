package edu.villanova.csc8542.preeclampsia.controller;

import edu.villanova.csc8542.preeclampsia.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    private AppProperties appProperties;

    public HealthController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/auth")
    public RedirectView redirectToAuth() {

        RedirectView redirectView = new RedirectView(appProperties.getAuthorizationUrl());

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
    public String processAuth(@RequestParam String code) {
        System.out.println("code: " + code);

        return "done";
    }

}
