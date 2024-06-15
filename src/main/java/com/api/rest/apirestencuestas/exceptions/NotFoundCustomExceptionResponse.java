package com.api.rest.apirestencuestas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class NotFoundCustomExceptionResponse {

    private HttpStatus statusCode;
    private String statusMsg;
    private Date timestamp;

}
