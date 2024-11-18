package com.example.Atividade16.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Atividade16.model.Produto;
import com.example.Atividade16.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getProduts(){
		return ResponseEntity.ok(produtoService.listarProdutos());
	}
	
	@PostMapping
	public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
		Produto produtoNovo = produtoService.criarProduto(produto);
		return ResponseEntity.created(URI.create("/produtos/" + produtoNovo.getId())).body(produtoNovo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto, @PathVariable Long id) throws Exception{
		return ResponseEntity.ok(produtoService.atualizarProduto(produto, id));
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) throws Exception {
		produtoService.deletarProduto(id);
	}

}
