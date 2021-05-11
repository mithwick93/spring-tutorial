package com.github.mithwick93.tutorial.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Value {
    private Long id;
    private String quote;
}
