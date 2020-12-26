package br.com.nelioalves.cursoudemy.controle;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.nelioalves.cursoudemy.dto.output.EstadoOutput;
import br.com.nelioalves.cursoudemy.servico.EstadoServico;

@RequestMapping("/categoria")
@CrossOrigin("*")
@Controller
public class EstadoControle {

	@Autowired
	EstadoServico estadoServico;
	
	@GetMapping
	public ResponseEntity<EstadoOutput> buscaTodos(){
		var result = estadoServico.buscaTodos();		
		return ResponseEntity.status(OK).body(new EstadoOutput(result));
		
	}
}
