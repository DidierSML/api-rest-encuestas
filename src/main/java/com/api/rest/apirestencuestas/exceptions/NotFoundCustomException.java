package com.api.rest.apirestencuestas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotFoundCustomException extends RuntimeException {

    private final String message;
}
