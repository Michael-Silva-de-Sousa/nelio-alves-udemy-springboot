package br.com.nelioalves.cursoudemy.dto.output;

import java.util.List;

import br.com.nelioalves.cursoudemy.dominio.Estado;
import lombok.Getter;

@Getter
public class EstadoOutput {
	public List<Estado> estados;

	public EstadoOutput(List<Estado> estados) {	
		this.estados = estados;
	}	
}
