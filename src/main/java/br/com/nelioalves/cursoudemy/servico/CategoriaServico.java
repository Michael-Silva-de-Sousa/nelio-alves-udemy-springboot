package br.com.nelioalves.cursoudemy.servico;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nelioalves.cursoudemy.dominio.Categoria;
import br.com.nelioalves.cursoudemy.repositorio.CategoriaRespositorio;

@Service
public class CategoriaServico {

	@Autowired
	CategoriaRespositorio categoriaRespositorio;
	
	public Categoria buscar(Long categoriaId) {
		 Optional<Categoria> categoria = categoriaRespositorio.findById(categoriaId);		 
		 return categoria.isPresent() ? categoria.get() : null;
	}

	@Transactional
	public Categoria insere(Categoria categoria) {
		return categoriaRespositorio.save(categoria);
	}
}
