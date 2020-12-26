package br.com.nelioalves.cursoudemy.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.nelioalves.cursoudemy.enuns.ClienteEnum;
import br.com.nelioalves.cursoudemy.util.ValidadorCpf;
import br.com.nelioalves.cursoudemy.util.ValidadorEmail;
import lombok.Getter;

@Entity
@Getter
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Integer clienteEnum;
	
	//@Mapeamento um-para-um
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	/**
	 * Tabela simplificada de relacionamento.
	 * Simplesmente armazena uma coleção de dados de modo
	 * simples. Muito util quando se seja obter uma coleção básica
	 * associada a entidade.
	 */
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {}

	public Cliente(Long id, String nome, String email, String cpf, ClienteEnum clienteEnum, Set<String> telefones, List<Endereco> enderecos) {	
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf.replaceAll("[^\\d ]", "");
		this.clienteEnum = clienteEnum.getId();
		this.telefones = telefones;
		this.enderecos = enderecos;
	}	
	
	public ClienteEnum getClienteEnum() {
		return ClienteEnum.toEnum(clienteEnum);
	}

	public static boolean validaCliente(Cliente cliente) {
		if(!ValidadorCpf.ehCpfValido(cliente.getCpf()))
			return false;
		if(cliente.getNome().isBlank() || cliente.getNome().isEmpty() || cliente.getNome().length() > 200)
			return false;
		if(!ValidadorEmail.ehEmailValido(cliente.getEmail()))
			return false;				
		return true;
	}
}
