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

import br.com.nelioalves.cursoudemy.dominio.Cidade;
import br.com.nelioalves.cursoudemy.dto.input.CidadeInput;
import br.com.nelioalves.cursoudemy.dto.output.CidadeOutput;
import br.com.nelioalves.cursoudemy.servico.CidadeServico;

@RequestMapping("/cidade")
@CrossOrigin("*")
@Controller
public class CidadeControle {

	@Autowired
	CidadeServico cidadeServico;
	
	@PostMapping
	public ResponseEntity<CidadeOutput> insere(@RequestBody CidadeInput cidadeInput){
		
		if(!Cidade.ehValido(cidadeInput.getCidade().getNome()))
			return ResponseEntity.status(BAD_REQUEST).build();
		
		if(cidadeInput.getCidade() == null)
			return ResponseEntity.status(BAD_REQUEST).build();
		
		var cidade = new Cidade(null, cidadeInput.getCidade().getNome(), cidadeInput.getEstado());
		
		var result = cidadeServico.insere(cidade);
		
		if(result == null)
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		else {
			var cidadeOutput = new CidadeOutput(new Cidade(result.getId(), result.getNome(),result.getEstado()));
			return ResponseEntity.status(CREATED).body(cidadeOutput);
		}	
	}
}
