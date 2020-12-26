package br.com.nelioalves.cursoudemy.dto.output;

import br.com.nelioalves.cursoudemy.dominio.Cidade;
import lombok.Getter;

@Getter
public class CidadeOutput {
	private Cidade cidade;
	
	public CidadeOutput() {}

	public CidadeOutput(Cidade cidade) {	
		this.cidade = cidade;
	}		
}
