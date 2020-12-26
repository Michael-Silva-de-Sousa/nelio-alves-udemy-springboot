package br.com.nelioalves.cursoudemy.dto.input;

import br.com.nelioalves.cursoudemy.dominio.Cliente;
import br.com.nelioalves.cursoudemy.dominio.Endereco;
import lombok.Getter;

@Getter
public class EnderecoInput {
	private Cliente cliente;
	private Endereco endereco;	
}
