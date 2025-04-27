package com.cliente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;
    
    @Email(message = "Email inválido")
    private String email;
    
    private String telefone;
    
    private String endereco;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}