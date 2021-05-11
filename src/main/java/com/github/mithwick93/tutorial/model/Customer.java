package com.github.mithwick93.tutorial.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
}
