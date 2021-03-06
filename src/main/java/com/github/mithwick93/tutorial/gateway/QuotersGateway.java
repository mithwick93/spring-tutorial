package com.github.mithwick93.tutorial.gateway;

import com.github.mithwick93.tutorial.gateway.dto.QuoteDTO;
import com.github.mithwick93.tutorial.gateway.mapper.QuoteMapper;
import com.github.mithwick93.tutorial.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class QuotersGateway {
    private static final Logger LOG = LoggerFactory.getLogger(QuotersGateway.class);

    private RestTemplate restTemplate;

    private QuoteMapper quoteMapper;

    @Value("${quoters.url:default_url}")
    private String QUOTERS_URL;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setQuoteMapper(QuoteMapper quoteMapper) {
        this.quoteMapper = quoteMapper;
    }

    public Quote getSpringBootQuote() {
//        Quote quote = restTemplate.getForObject(
//                QUOTERS_URL.concat("/random"),
//                Quote.class
//        );

        ResponseEntity<QuoteDTO> quoteResponseEntity = restTemplate.getForEntity(
                QUOTERS_URL.concat("/random"),
                QuoteDTO.class
        );

        LOG.info("Got the quote response: " + quoteResponseEntity);
        QuoteDTO quoteDTO = quoteResponseEntity.getBody();
        LOG.info("Got the quoteTo: " + quoteResponseEntity.getBody());
        return quoteMapper.fromQuoteDTOtoQuote(Objects.requireNonNull(quoteDTO));
    }
}
