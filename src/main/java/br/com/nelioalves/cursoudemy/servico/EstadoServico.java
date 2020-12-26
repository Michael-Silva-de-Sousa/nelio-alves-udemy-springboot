package br.com.nelioalves.cursoudemy.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nelioalves.cursoudemy.dominio.Estado;
import br.com.nelioalves.cursoudemy.repositorio.EstadoRespositorio;

@Service
public class EstadoServico {

	@Autowired
	EstadoRespositorio estadoRepositorio;
	
	public List<Estado> buscaTodos(){
		return estadoRepositorio.findAll();
	}
}
