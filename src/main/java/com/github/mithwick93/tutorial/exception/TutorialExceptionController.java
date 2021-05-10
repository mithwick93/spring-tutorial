package com.github.mithwick93.tutorial.exception;

import com.github.mithwick93.tutorial.controller.dto.TutorialServiceErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TutorialExceptionController {
    private static final Logger LOG = LoggerFactory.getLogger(TutorialExceptionController.class);

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Object> exception(Throwable throwable) {
        LOG.info("Handling error: " + throwable.getMessage());

        TutorialServiceErrorResponse tutorialServiceErrorResponse = new TutorialServiceErrorResponse(
                "Unhandled error",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        tutorialServiceErrorResponse.setAdditionalInfo(throwable.getMessage());

        return new ResponseEntity<>(tutorialServiceErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

