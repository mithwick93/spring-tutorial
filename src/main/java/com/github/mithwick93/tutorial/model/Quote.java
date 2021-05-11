package com.github.mithwick93.tutorial.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Quote {
    private String type;
    private Value value;
}
