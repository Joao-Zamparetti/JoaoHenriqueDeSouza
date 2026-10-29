package com.example.controledeinsumos.Controller;

import com.example.controledeinsumos.DTO.EstoqueRequest;
import com.example.controledeinsumos.DTO.EstoqueResponse;
import com.example.controledeinsumos.DTO.MovimentacaoRequest;
import com.example.controledeinsumos.DTO.MovimentacaoResponse;
import com.example.controledeinsumos.Model.Movimentacao;
import com.example.controledeinsumos.Service.MovimentacaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<MovimentacaoResponse> listar(){
        return movimentacaoService.listar();
    }

    @GetMapping("/{id}")
    public MovimentacaoResponse buscarPorId(@PathVariable Long id){
        return movimentacaoService.buscarPorId(id);
    }

    @PostMapping
    public MovimentacaoResponse salvar(@RequestBody MovimentacaoRequest dto){
        return movimentacaoService.salvar(dto);
    }
}
