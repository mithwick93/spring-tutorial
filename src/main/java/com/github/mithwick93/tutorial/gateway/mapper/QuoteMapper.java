package com.github.mithwick93.tutorial.gateway.mapper;

import com.github.mithwick93.tutorial.gateway.dto.QuoteDTO;
import com.github.mithwick93.tutorial.gateway.dto.ValueDTO;
import com.github.mithwick93.tutorial.model.Quote;
import com.github.mithwick93.tutorial.model.Value;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuoteMapper {
    public static Quote fromTo(@NonNull QuoteDTO quoteDTO) {
        Quote quote = new Quote();
        Value value = new Value();
        String[] ignoreProperties = new String[]{"value"};
        BeanUtils.copyProperties(quoteDTO, quote, ignoreProperties);

        ValueDTO valueDTO = quoteDTO.getValue();
        if (valueDTO != null) {
            BeanUtils.copyProperties(valueDTO, value);
            quote.setValue(value);
        }
        return quote;
    }
}
