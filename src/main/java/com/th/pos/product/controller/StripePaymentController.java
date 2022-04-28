package com.th.pos.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/payment")
public class StripePaymentController {

    @Value("${stripe.apikey}")
    String key;

    @GetMapping("/key")
    public String apiKey(){
        return key;
    }
}
