package com.example.controledeinsumos.Repository;

import com.example.controledeinsumos.Model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
