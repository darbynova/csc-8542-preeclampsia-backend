package edu.villanova.csc8542.preeclampsia.controller;

import edu.villanova.csc8542.preeclampsia.config.AppProperties;
import edu.villanova.csc8542.preeclampsia.service.HealthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class HealthController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AppProperties appProperties;
    private HealthService healthService;

    public HealthController(AppProperties appProperties, HealthService healthService) {
        this.appProperties = appProperties;
        this.healthService = healthService;
    }

    @GetMapping("/")
    public RedirectView redirectToAuth() {

        RedirectView redirectView = new RedirectView(appProperties.getBaseUrl() + appProperties.getAuthorizationUri());

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id", appProperties.getClientId());
        queryParams.put("response_type", appProperties.getResponseType());
        queryParams.put("redirect_uri", appProperties.getRedirectUri());
        queryParams.put("APIName", appProperties.getApiName());
        queryParams.put("IsNew", "False");

        redirectView.setAttributesMap(queryParams);

        return redirectView;
    }

    @GetMapping(value = "/redirect", produces = "application/json")
    public RedirectView requestAccessToken(@RequestParam String code) {
        logger.debug("code: " + code);

        String bloodPressureResult = healthService.getBloodPressureResult(code);

        // send data to frontend
        try {
            healthService.sendToClient(bloodPressureResult);
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.error("Could not send to client");
        }

        RedirectView redirectView = new RedirectView(appProperties.getFrontendBaseUrl());        

        return redirectView;
    }

}
