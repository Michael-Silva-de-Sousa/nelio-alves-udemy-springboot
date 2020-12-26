package br.com.nelioalves.cursoudemy.dto.input;

import br.com.nelioalves.cursoudemy.dominio.Cidade;
import br.com.nelioalves.cursoudemy.dominio.Estado;
import lombok.Getter;

@Getter
public class CidadeInput {
	private Estado estado;
	private Cidade cidade;
	
	public CidadeInput(Estado estado, Cidade cidade) {	
		this.estado = estado;
		this.cidade = cidade;
	}	
}