package br.com.nelioalves.cursoudemy.dto.input;

import java.util.HashSet;
import java.util.Set;

import br.com.nelioalves.cursoudemy.dominio.Cliente;
import lombok.Getter;

@Getter
public class ClienteInput {
	private Cliente cliente;
	private Set<String> telefones = new HashSet<>();
}
