package com.github.mithwick93.tutorial.gateway.mapper;

import com.github.mithwick93.tutorial.gateway.dto.QuoteDTO;
import com.github.mithwick93.tutorial.gateway.dto.ValueDTO;
import com.github.mithwick93.tutorial.model.Quote;
import com.github.mithwick93.tutorial.model.Value;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuoteMapper {
    Quote fromQuoteDTOtoQuote(QuoteDTO quoteDTO);

    Value fromValueDTOtoValue(ValueDTO valueDTO);
}
