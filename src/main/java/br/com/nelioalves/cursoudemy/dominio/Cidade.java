package br.com.nelioalves.cursoudemy.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Getter
@Entity
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	//@Mapeamento muitos-para-um
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;
	
	public Cidade() {}

	public Cidade(Long id, String nome, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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
