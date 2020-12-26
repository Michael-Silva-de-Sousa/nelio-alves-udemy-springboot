package br.com.nelioalves.cursoudemy.dto.output;

import br.com.nelioalves.cursoudemy.dominio.Cliente;
import lombok.Getter;

@Getter
public class ClienteOutput {
	private Cliente cliente;	

	public ClienteOutput(Cliente cliente) {
		this.cliente = cliente;		
	}	
}