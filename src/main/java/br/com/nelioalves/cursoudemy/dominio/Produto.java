package br.com.nelioalves.cursoudemy.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;

@Getter
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	//@Mapeamento muitos-para-muitos
	@ManyToMany
	@JoinTable(
			name="PRODUTO_CATEGORIA",
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
			)
	private List<Categoria> categorias = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Produto() {}
	
	public Produto(Long id, String nome, List<Categoria> categorias, Set<ItemPedido> itens) {
		this.id = id;
		this.nome = nome;
		this.categorias = categorias;
		this.itens = itens;
	}
	
	public static boolean ehValido(String nome) {
		if(nome.isBlank())
			return false;
		if(nome.isEmpty())
			return false;		
		if(nome.length() > 200)
			return false;
		return true;
	}
}
