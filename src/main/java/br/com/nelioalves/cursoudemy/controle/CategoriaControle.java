package br.com.nelioalves.cursoudemy.controle;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.nelioalves.cursoudemy.dominio.Categoria;
import br.com.nelioalves.cursoudemy.dto.input.CategoriaInput;
import br.com.nelioalves.cursoudemy.servico.CategoriaServico;

@RequestMapping("/categoria")
@CrossOrigin("*")
@Controller
public class CategoriaControle {

	@Autowired
	CategoriaServico categoriaServico;
	
	@GetMapping
	@RequestMapping("/{categoriaId}")
	public ResponseEntity<Categoria> buscar(@PathVariable("categoriaId") Long categoriaId) {
		var categoriaResult = categoriaServico.buscar(categoriaId);
		return categoriaResult != null ? ResponseEntity.status(OK).body(categoriaResult) : ResponseEntity.status(NOT_FOUND).build();
	}
	
	@PostMapping	
	public ResponseEntity<Categoria> insere(@RequestBody CategoriaInput categoriaInput){				
		var categoria = new Categoria(null, categoriaInput.getNome());
		
		if(!Categoria.ehValido(categoria.getNome()))
			return ResponseEntity.status(BAD_REQUEST).build();
		
		var result = categoriaServico.insere(categoria);				
		return result != null ? ResponseEntity.status(CREATED).body(result) : ResponseEntity.status(INTERNAL_SERVER_ERROR).build();			
	}
}
