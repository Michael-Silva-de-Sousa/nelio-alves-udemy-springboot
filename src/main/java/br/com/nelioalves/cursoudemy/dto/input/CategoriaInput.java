package br.com.nelioalves.cursoudemy.dto.input;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaInput {
	private String nome;

	public CategoriaInput() {}
	
	public CategoriaInput(String nome) {	
		this.nome = nome;
	}	
}
