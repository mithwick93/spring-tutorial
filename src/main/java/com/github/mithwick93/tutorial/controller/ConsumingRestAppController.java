package com.github.mithwick93.tutorial.controller;

import com.github.mithwick93.tutorial.gateway.dto.Quote;
import com.github.mithwick93.tutorial.service.ConsumingRestAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumingRestAppController {
    private ConsumingRestAppService consumingRestAppService;

    @Autowired
    public void setConsumingRestAppService(ConsumingRestAppService consumingRestAppService) {
        this.consumingRestAppService = consumingRestAppService;
    }

    @GetMapping("/quote")
    public Quote quote() {
        return consumingRestAppService.getQuote();
    }
}
