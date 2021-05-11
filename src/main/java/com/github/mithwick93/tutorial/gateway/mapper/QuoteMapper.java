package com.github.mithwick93.tutorial.gateway.mapper;

import com.github.mithwick93.tutorial.gateway.dto.QuoteTo;
import com.github.mithwick93.tutorial.gateway.dto.ValueTo;
import com.github.mithwick93.tutorial.model.Quote;
import com.github.mithwick93.tutorial.model.Value;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuoteMapper {
    public static Quote fromTo(@NonNull QuoteTo quoteTo) {
        Quote quote = new Quote();
        Value value = new Value();
        String[] ignoreProperties = new String[]{"value"};
        BeanUtils.copyProperties(quoteTo, quote, ignoreProperties);

        ValueTo valueTo = quoteTo.getValue();
        if (valueTo != null) {
            BeanUtils.copyProperties(valueTo, value);
            quote.setValue(value);
        }
        return quote;
    }
}
