package br.com.nelioalves.cursoudemy.dto.output;

import br.com.nelioalves.cursoudemy.dominio.Produto;
import lombok.Getter;

@Getter
public class ProdutoOutput {
	private Produto produto;
	
	public ProdutoOutput(Produto produto) {
		this.produto = produto;		
	}	
}
