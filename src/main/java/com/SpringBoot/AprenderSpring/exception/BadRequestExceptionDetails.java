package com.SpringBoot.AprenderSpring.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@JsonPropertyOrder ({
        "title",
        "status",
        "details",
        "developerMessage",
        "timestamp"
})
@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {

}
