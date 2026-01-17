package com.portfolio_kaenan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String root() {
        return "API do portfólio rodando!";
    }
}
