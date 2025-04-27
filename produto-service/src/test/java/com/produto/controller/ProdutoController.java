package com.produto.controller;

import com.produto.model.Produto;
import com.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
        List<Produto> produtos = produtoService.buscarPorNome(nome);
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }
    
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable String categoria) {
        List<Produto> produtos = produtoService.buscarPorCategoria(categoria);
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }
    
    @GetMapping("/sku/{codigoSku}")
    public ResponseEntity<Produto> buscarPorCodigoSku(@PathVariable String codigoSku) {
        Produto produto = produtoService.buscarPorCodigoSku(codigoSku);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }
    
    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizar(id, produto);
        if (produtoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoAtualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!produtoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}