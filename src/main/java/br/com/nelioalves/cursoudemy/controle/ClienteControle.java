package br.com.nelioalves.cursoudemy.controle;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.nelioalves.cursoudemy.dominio.Cliente;
import br.com.nelioalves.cursoudemy.dto.input.ClienteInput;
import br.com.nelioalves.cursoudemy.dto.output.ClienteOutput;
import br.com.nelioalves.cursoudemy.servico.ClienteServico;
import br.com.nelioalves.cursoudemy.util.ValidadorTelefone;

@RequestMapping("/cliente")
@CrossOrigin("*")
@Controller
public class ClienteControle {

	@Autowired
	ClienteServico clienteServico;
	
	@PostMapping
	public ResponseEntity<ClienteOutput> insere(@RequestBody ClienteInput clienteInput){
		
		if(!Cliente.validaCliente(clienteInput.getCliente()))
			return ResponseEntity.status(BAD_REQUEST).build();

		Set<String> telefonesValidos = ValidadorTelefone.telefonesValidos(clienteInput.getTelefones());
		
		var cliente = new Cliente(
				null, 
				clienteInput.getCliente().getNome(), 
				clienteInput.getCliente().getEmail(), 
				clienteInput.getCliente().getCpf(), 
				clienteInput.getCliente().getClienteEnum(), 
				telefonesValidos,
				null
				);
		
		var result = clienteServico.insere(cliente);
		
		if(result == null)
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		else {
			var clienteOutput = new ClienteOutput(new Cliente(
					result.getId(), 
					result.getNome(), 
					result.getEmail(), 
					result.getCpf(), 
					result.getClienteEnum(),
					result.getTelefones(),
					result.getEnderecos())
					);
			
			return ResponseEntity.status(CREATED).body(clienteOutput);
		}
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClienteOutput> busca(@PathVariable("clienteId") Long clienteId){
		var result = clienteServico.buscaPorId(clienteId);
		
		if(result == null)
			return ResponseEntity.status(NOT_FOUND).build();
		else {		
			var clienteOutput = new ClienteOutput(new Cliente(
					result.getId(), 
					result.getNome(), 
					result.getEmail(), 
					result.getCpf(), 
					result.getClienteEnum(), 
					result.getTelefones(),
					result.getEnderecos())					
					);
			
			return ResponseEntity.status(OK).body(clienteOutput);
		}	
	}
}
