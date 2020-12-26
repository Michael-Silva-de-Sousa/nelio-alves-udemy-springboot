package br.com.nelioalves.cursoudemy.servico;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nelioalves.cursoudemy.dominio.Cliente;
import br.com.nelioalves.cursoudemy.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	
	@Transactional
	public Cliente insere(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	public Cliente buscaPorId(Long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		
		if(cliente.isPresent())
			return cliente.get();
		else
			return null;
	}
}
