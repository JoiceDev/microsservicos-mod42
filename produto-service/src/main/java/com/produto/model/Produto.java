package com.produto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;
    
    private String descricao;
    
    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser positivo")
    private BigDecimal preco;
    
    @NotNull(message = "A quantidade em estoque é obrigatória")
    @PositiveOrZero(message = "A quantidade em estoque não pode ser negativa")
    private Integer quantidadeEstoque;
    
    private String categoria;
    
    private String codigoSku;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}