package com.github.mithwick93.tutorial.gateway;

import com.github.mithwick93.tutorial.gateway.dto.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuotersGateway {
    private static final Logger LOG = LoggerFactory.getLogger(QuotersGateway.class);

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Quote getSpringBootQuote() {
        try {
            Quote quote = restTemplate.getForObject(
                    "https://quoters.apps.pcfone.io/api/random",
                    Quote.class
            );

            assert quote != null;
            LOG.info("Got the quote: " + quote);
            return quote;
        } catch (Exception ex) {
            LOG.error("Exception while getting quote", ex);
            return null;
        }
    }
}
