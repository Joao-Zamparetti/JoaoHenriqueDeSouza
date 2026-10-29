package com.example.controledeinsumos.Service;


import com.example.controledeinsumos.DTO.MovimentacaoRequest;
import com.example.controledeinsumos.DTO.MovimentacaoResponse;
import com.example.controledeinsumos.DTO.PerfilRequest;
import com.example.controledeinsumos.DTO.PerfilResponse;
import com.example.controledeinsumos.Model.Movimentacao;
import com.example.controledeinsumos.Model.Perfil;
import com.example.controledeinsumos.Repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovimentacaoService {

    private MovimentacaoRepository movimentacaoRepository;

    public List<MovimentacaoResponse> listar(){
        return movimentacaoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public MovimentacaoResponse buscarPorId(Long id){
        Movimentacao movimentacao = movimentacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));

        return toResponse(movimentacao);
    }

    public MovimentacaoResponse salvar(MovimentacaoRequest dto){
        Movimentacao movimentacao = toEntity(dto);

        movimentacaoRepository.save(movimentacao);

        return toResponse(movimentacao);
    }

    public MovimentacaoResponse toResponse(Movimentacao movimentacao){
        return new MovimentacaoResponse(
                movimentacao.getNome(),
                movimentacao.getQuantidade()
        );
    }

    public Movimentacao toEntity(MovimentacaoRequest dto){
        return new Movimentacao(
                dto.id(),
                dto.nome(),
                dto.quantidade()
        );
    }
}
