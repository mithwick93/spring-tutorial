package com.github.mithwick93.tutorial.controller.dto;

import lombok.Data;

@Data
public class TutorialServiceErrorResponse {
    private final String message;
    private final Integer code;
    private String additionalInfo;
}
