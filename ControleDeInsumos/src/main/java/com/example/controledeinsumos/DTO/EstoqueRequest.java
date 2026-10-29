package com.example.controledeinsumos.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstoqueRequest(

        Long id,

        @NotBlank(message = "Insira o nome do estoque")
        String nome,

        @NotNull(message = "Insira a quantidade")
        Integer quantidade
) {
}
