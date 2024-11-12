package edu.villanova.csc8542.preeclampsia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HealthController {

    @GetMapping("/auth")
    public RedirectView redirectToAuth() {

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://www.luv2code.com");
        return redirectView;
    }
}
