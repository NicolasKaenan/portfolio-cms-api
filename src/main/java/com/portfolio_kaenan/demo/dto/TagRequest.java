package com.portfolio_kaenan.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TagRequest(

        @NotBlank(message = "O valor da tag é obrigatório.")
        @Size(max = 50, message = "A tag deve ter no máximo 50 caracteres.")
        String value
) {}
