package com.example.Atividade16.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Atividade16.model.Produto;
import com.example.Atividade16.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public Produto criarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	public Produto atualizarProduto(Produto produto, Long id) throws Exception {
		Optional<Produto> existProduto = produtoRepository.findById(id);
		
		if(existProduto.isPresent()) {
			Produto produto2 = existProduto.get();
			produto2.setId(id);
			produto2.setDescricao(produto.getDescricao());
			produto2.setPreco(produto.getPreco());
			produto2.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
			produtoRepository.save(produto2);
			return produto2;
		}else {
			throw new Exception("Produto não encontrado!");
		}
	}
	
	public void deletarProduto(Long id) throws Exception {
		Optional<Produto> existProduto = produtoRepository.findById(id);
		
		if(existProduto.isPresent()) {
			produtoRepository.delete(existProduto.get());
		}else {
			throw new Exception("Produto não encontrado!");
		}
	}
}
