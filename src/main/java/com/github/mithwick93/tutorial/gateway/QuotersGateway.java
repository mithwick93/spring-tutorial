package com.github.mithwick93.tutorial.gateway;

import com.github.mithwick93.tutorial.gateway.dto.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuotersGateway {
    private static final Logger LOG = LoggerFactory.getLogger(QuotersGateway.class);

    private RestTemplate restTemplate;

    @Value("${quoters.url:default_url}")
    private String QUOTERS_URL;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Quote getSpringBootQuote() {
        try {
//            Quote quote = restTemplate.getForObject(
//                    QUOTERS_URL.concat("/random"),
//                    Quote.class
//            );

            ResponseEntity<Quote> quoteResponseEntity = restTemplate.getForEntity(
                    QUOTERS_URL.concat("/random"),
                    Quote.class
            );

            LOG.info("Got the quote response: " + quoteResponseEntity);
            Quote quote = quoteResponseEntity.getBody();
            LOG.info("Got the quote: " + quoteResponseEntity.getBody());
            return quote;
        } catch (Exception ex) {
            LOG.error("Exception while getting quote", ex);
            return null;
        }
    }
}
