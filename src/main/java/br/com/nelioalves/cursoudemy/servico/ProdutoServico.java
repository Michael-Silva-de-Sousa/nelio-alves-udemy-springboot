package br.com.nelioalves.cursoudemy.servico;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nelioalves.cursoudemy.dominio.Produto;
import br.com.nelioalves.cursoudemy.repositorio.ProdutoRespositorio;

@Service
public class ProdutoServico {
	@Autowired
	ProdutoRespositorio produtoRespositorio;
	
	@Transactional	
	public Produto insere(Produto produto) {
		return 	produtoRespositorio.save(produto);
	}
}
