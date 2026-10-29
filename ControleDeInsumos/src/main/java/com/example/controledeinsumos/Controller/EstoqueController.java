package com.example.controledeinsumos.Controller;

import com.example.controledeinsumos.DTO.EstoqueRequest;
import com.example.controledeinsumos.DTO.EstoqueResponse;
import com.example.controledeinsumos.Service.EstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/estoque")
public class EstoqueController {

    private EstoqueService estoqueService;

    @GetMapping
    public List<EstoqueResponse> listar(){
        return estoqueService.listar();
    }

    @GetMapping("/{id}")
    public EstoqueResponse buscarPorId(@PathVariable Long id){
        return estoqueService.buscarPorid(id);
    }

    @PostMapping
    public EstoqueResponse salvar(@RequestBody EstoqueRequest dto){
        return estoqueService.salvar(dto);
    }
}
