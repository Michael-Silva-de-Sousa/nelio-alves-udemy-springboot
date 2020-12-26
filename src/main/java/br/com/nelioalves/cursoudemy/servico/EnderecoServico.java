package br.com.nelioalves.cursoudemy.servico;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nelioalves.cursoudemy.dominio.Endereco;
import br.com.nelioalves.cursoudemy.repositorio.EnderecoRepositorio;

@Service
public class EnderecoServico {

	@Autowired
	EnderecoRepositorio enderecoRespositorio;
	
	@Transactional
	public Endereco insere(Endereco endereco) {
		return enderecoRespositorio.save(endereco);
	}
}
