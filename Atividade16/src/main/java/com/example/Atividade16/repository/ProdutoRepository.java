package com.example.Atividade16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Atividade16.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
