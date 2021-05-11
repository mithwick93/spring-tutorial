package com.github.mithwick93.tutorial.dal.dao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerTo {
    private long id;
    private String firstName;
    private String lastName;
}
