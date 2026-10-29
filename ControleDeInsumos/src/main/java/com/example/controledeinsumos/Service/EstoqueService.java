package com.example.controledeinsumos.Service;

import com.example.controledeinsumos.DTO.EstoqueRequest;
import com.example.controledeinsumos.DTO.EstoqueResponse;
import com.example.controledeinsumos.Model.Estoque;
import com.example.controledeinsumos.Repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstoqueService {

    private EstoqueRepository estoqueRepository;

    public List<EstoqueResponse> listar(){
        return estoqueRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public EstoqueResponse buscarPorid(Long id){
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        return toResponse(estoque);
    }

    public EstoqueResponse salvar(EstoqueRequest dto){
        Estoque estoque = toEntity(dto);

        estoqueRepository.save(estoque);

        return toResponse(estoque);
    }

    public EstoqueResponse toResponse(Estoque estoque){
        return new EstoqueResponse(
                estoque.getNome(),
                estoque.getQuantidade()
        );
    }

    public Estoque toEntity(EstoqueRequest dto){
        return new Estoque(
                dto.id(),
                dto.nome(),
                dto.quantidade()
        );
    }
}
