package com.example.controledeinsumos.Service;



import com.example.controledeinsumos.DTO.PerfilRequest;
import com.example.controledeinsumos.DTO.PerfilResponse;

import com.example.controledeinsumos.Model.Estoque;
import com.example.controledeinsumos.Model.Perfil;
import com.example.controledeinsumos.Repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PerfilService {

    private PerfilRepository perfilRepository;

    public List<PerfilResponse> listar(){
        return perfilRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public PerfilResponse buscarPorid(Long id){
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        return toResponse(perfil);
    }

    public PerfilResponse salvar(PerfilRequest dto){
        Perfil perfil = toEntity(dto);

        perfilRepository.save(perfil);

        return toResponse(perfil);
    }

    public PerfilResponse toResponse(Perfil perfil){
        return new PerfilResponse(
                perfil.getNome(),
                perfil.getSenha()
        );
    }

    public Perfil toEntity(PerfilRequest dto){
        return new Perfil(
                dto.id(),
                dto.nome(),
                dto.senha()
        );
    }
}
