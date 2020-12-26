package br.com.nelioalves.cursoudemy.controle;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.nelioalves.cursoudemy.dominio.Produto;
import br.com.nelioalves.cursoudemy.dto.input.ProdutoInput;
import br.com.nelioalves.cursoudemy.dto.output.ProdutoOutput;
import br.com.nelioalves.cursoudemy.repositorio.CategoriaRespositorio;
import br.com.nelioalves.cursoudemy.servico.ProdutoServico;

@RequestMapping("/produto")
@CrossOrigin("*")
@Controller
public class ProdutoControle {

	@Autowired
	ProdutoServico produtoServico;	
	@Autowired
	CategoriaRespositorio categoriaRespositorio;
	
	@PostMapping
	public ResponseEntity<ProdutoOutput> insere(@RequestBody ProdutoInput produtoInput){
		
		if(!Produto.ehValido(produtoInput.getProduto().getNome()))
			return ResponseEntity.status(BAD_REQUEST).build();
		
		if(produtoInput.getCategorias().isEmpty())
			return ResponseEntity.status(BAD_REQUEST).build();
		
		var produto = new Produto(null, produtoInput.getProduto().getNome(), produtoInput.getCategorias(), null);
		
		var result = produtoServico.insere(produto);
		
		if(result == null)
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		else {
			var produtoOutput = new ProdutoOutput(new Produto(result.getId(),result.getNome(),result.getCategorias(), null));
			return ResponseEntity.status(CREATED).body(produtoOutput);
		}		
	}
}
