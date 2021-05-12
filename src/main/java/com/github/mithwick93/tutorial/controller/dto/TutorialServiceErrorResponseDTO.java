package com.github.mithwick93.tutorial.controller.dto;

import lombok.Data;

@Data
public class TutorialServiceErrorResponseDTO {
    private final String message;
    private final Integer code;
    private String additionalInfo;
}
