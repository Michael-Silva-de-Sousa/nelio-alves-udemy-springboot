package br.com.nelioalves.cursoudemy.controle;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.nelioalves.cursoudemy.dominio.Endereco;
import br.com.nelioalves.cursoudemy.dto.input.EnderecoInput;
import br.com.nelioalves.cursoudemy.servico.ClienteServico;
import br.com.nelioalves.cursoudemy.servico.EnderecoServico;

@RequestMapping("/endereco")
@CrossOrigin("*")
@Controller
public class EnderecoControle {

	@Autowired
	EnderecoServico enderecoServico;
	
	@Autowired
	ClienteServico clienteServico;
	
	@PostMapping
	public ResponseEntity<Void> insere(@RequestBody EnderecoInput enderecoInput){
		
		var cliente = clienteServico.buscaPorId(enderecoInput.getCliente().getId());
		
		if(cliente == null)
			return ResponseEntity.status(NOT_FOUND).build();
		
		var endereco = new Endereco(
				null, 
				enderecoInput.getEndereco().getLogradouro(), 
				enderecoInput.getEndereco().getNumero(), 
				enderecoInput.getEndereco().getBairro(), 
				enderecoInput.getEndereco().getCep(), 
				cliente, 
				enderecoInput.getEndereco().getCidade()
				);
		
		var result = enderecoServico.insere(endereco);
		
		if(result == null)
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		
		return ResponseEntity.status(CREATED).build();
	}
}
