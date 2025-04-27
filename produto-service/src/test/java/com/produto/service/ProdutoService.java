package com.produto.service;

import com.produto.model.Produto;
import com.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
    
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public List<Produto> buscarPorCategoria(String categoria) {
        return produtoRepository.findByCategoria(categoria);
    }
    
    public Produto buscarPorCodigoSku(String codigoSku) {
        return produtoRepository.findByCodigoSku(codigoSku);
    }
    
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        if (produtoRepository.existsById(id)) {
            produtoAtualizado.setId(id);
            return produtoRepository.save(produtoAtualizado);
        }
        return null;
    }
    
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}