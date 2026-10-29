package com.example.controledeinsumos.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovimentacaoRequest(

        Long id,

        @NotBlank(message = "Insira o nome do produto movimentado")
        Long nome,

        @NotNull(message = "Insira a quantidade da movimentação")
        Long quantidade
) {}
