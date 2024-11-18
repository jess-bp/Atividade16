package com.example.Atividade16.service;

import static org.mockito.Mockito.times;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Atividade16.model.Produto;
import com.example.Atividade16.repository.ProdutoRepository;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceUnitTest {
	
	@Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;
    
    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto();
        produto.setId(1L);
        produto.setDescricao("Produto Teste");
        produto.setPreco(BigDecimal.valueOf(100.0));
        produto.setQuantidadeEmEstoque(10);
    }
    
    @Test
    void criarProduto_should_ReturnProduto_when_validRequest() {
        Mockito.when(produtoRepository.save(produto)).thenReturn(produto);

        Produto produtoCriado = produtoService.criarProduto(produto);

        Assertions.assertNotNull(produtoCriado);
        Assertions.assertEquals(produto.getId(), produtoCriado.getId());
        Mockito.verify(produtoRepository, times(1)).save(produto);
    }
    
    @Test
    void listarProdutos_should_ReturnListaDeProduto_when_ValidRequest() {
        List<Produto> produtos = Arrays.asList(produto);
        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        List<Produto> resultado = produtoService.listarProdutos();

        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals(produto.getId(), resultado.get(0).getId());
        Mockito.verify(produtoRepository, times(1)).findAll();
    }
    
    @Test
    void atualizarProduto_should_ReturnNovoProduto_when_ProdutoIdExiste() throws Exception {
    	Mockito.when(produtoRepository.findById(produto.getId())).thenReturn(Optional.of(produto));
        
        Produto novoProduto = new Produto();
        novoProduto.setId(produto.getId());
        novoProduto.setDescricao("Produto Atualizado");
        novoProduto.setPreco(BigDecimal.valueOf(150.0));
        novoProduto.setQuantidadeEmEstoque(20);

        Produto produtoAtualizado = produtoService.atualizarProduto(novoProduto, produto.getId());

        Assertions.assertEquals("Produto Atualizado", produtoAtualizado.getDescricao());
        Assertions.assertEquals(BigDecimal.valueOf(150.0), produtoAtualizado.getPreco());
        Assertions.assertEquals(20, produtoAtualizado.getQuantidadeEmEstoque());
        
        Mockito.verify(produtoRepository, times(1)).findById(produto.getId());
        Mockito.verify(produtoRepository, times(1)).save(produtoAtualizado);
    }

    @Test
    void atualizarProduto_should_ReturnExcecao_when_ProdutoIdNaoExiste() {
    	Mockito.when(produtoRepository.findById(produto.getId())).thenReturn(Optional.empty());

        Produto novoProduto = new Produto();

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            produtoService.atualizarProduto(novoProduto, produto.getId());
        });

        Assertions.assertEquals("Produto não encontrado!", exception.getMessage());
        Mockito.verify(produtoRepository, times(1)).findById(produto.getId());
    }
    
    @Test
    void deletarProduto_should_ReturnVoid_when_ProdutoIdExiste() throws Exception {
    	Mockito.when(produtoRepository.findById(produto.getId())).thenReturn(Optional.of(produto));

        produtoService.deletarProduto(produto.getId());

        Mockito.verify(produtoRepository, times(1)).delete(produto);
    }

    @Test
    void deletarProduto_should_ReturnExcecao_when_ProdutoIdNaoExiste() {
    	Mockito.when(produtoRepository.findById(produto.getId())).thenReturn(Optional.empty());

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            produtoService.deletarProduto(produto.getId());
        });

        Assertions.assertEquals("Produto não encontrado!", exception.getMessage());
        Mockito.verify(produtoRepository, times(1)).findById(produto.getId());
    }





}
