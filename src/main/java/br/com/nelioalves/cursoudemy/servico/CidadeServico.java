package br.com.nelioalves.cursoudemy.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nelioalves.cursoudemy.dominio.Cidade;
import br.com.nelioalves.cursoudemy.repositorio.CidadeRespositorio;

@Service
public class CidadeServico {

	@Autowired
	CidadeRespositorio cidadeRespositorio;
	
	public Cidade insere(Cidade cidade) {
		return cidadeRespositorio.save(cidade);
	}
}
