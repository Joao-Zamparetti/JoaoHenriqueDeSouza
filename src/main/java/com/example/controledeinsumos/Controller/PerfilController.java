package com.example.controledeinsumos.Controller;

import com.example.controledeinsumos.DTO.EstoqueRequest;
import com.example.controledeinsumos.DTO.MovimentacaoResponse;
import com.example.controledeinsumos.DTO.PerfilRequest;
import com.example.controledeinsumos.DTO.PerfilResponse;
import com.example.controledeinsumos.Repository.PerfilRepository;
import com.example.controledeinsumos.Service.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/perfil")
public class PerfilController {

    private PerfilService perfilService;

    @GetMapping
    public List<PerfilResponse> listar(){
        return perfilService.listar();
    }

    @GetMapping("/{id}")
    public PerfilResponse buscarPorId(@PathVariable Long id){
        return perfilService.buscarPorid(id);
    }

    @PostMapping
    public PerfilResponse salvar(@RequestBody PerfilRequest dto){
        return perfilService.salvar(dto);
    }
}
