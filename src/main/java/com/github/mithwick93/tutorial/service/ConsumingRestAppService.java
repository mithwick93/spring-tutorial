package com.github.mithwick93.tutorial.service;

import com.github.mithwick93.tutorial.gateway.QuotersGateway;
import com.github.mithwick93.tutorial.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumingRestAppService {
    private QuotersGateway quotersGateway;

    @Autowired
    public void setQuotersGateway(QuotersGateway quotersGateway) {
        this.quotersGateway = quotersGateway;
    }

    public Quote getQuote() {
        return quotersGateway.getSpringBootQuote();
    }
}
