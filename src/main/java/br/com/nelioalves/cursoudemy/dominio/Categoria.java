package br.com.nelioalves.cursoudemy.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	//@Mapeamento muitos-para-muitos
	@JsonIgnore
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {}
	
	public Categoria(final Long id, final String nome) {			
		this.id = id;
		this.nome = nome;	
	}
	
	public static boolean ehValido(String nome){
		if(nome.isBlank())
			return false;
		if(nome.isEmpty())
			return false;		
		if(nome.length() > 200)
			return false;
		return true;	
	}	
}
