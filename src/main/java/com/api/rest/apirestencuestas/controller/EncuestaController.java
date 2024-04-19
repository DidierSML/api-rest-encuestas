package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.service.EncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/encuesta")
public class EncuestaController {

    private final EncuestaService encuestaService;


}
