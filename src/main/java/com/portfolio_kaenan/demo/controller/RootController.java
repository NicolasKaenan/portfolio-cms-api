package com.portfolio_kaenan.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        originPatterns = {
                "http://localhost:*",
                "https://*.kaenan.dev",
                "https://kaenan.dev"
        }
)

public class RootController {

    @GetMapping("/")
    public String root() {
        return "API do portfólio rodando!";
    }
}
