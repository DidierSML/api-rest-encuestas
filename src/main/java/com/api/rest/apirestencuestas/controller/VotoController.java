package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.service.impl.OpcionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/voto")
public class VotoController {

    private final OpcionServiceImpl opcionServiceImpl;

}