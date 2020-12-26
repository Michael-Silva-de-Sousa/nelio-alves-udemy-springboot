package br.com.nelioalves.cursoudemy.dominio;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Entity
@Getter
public class ItemPedido {
	/**
	 * Representa um id embutido em uma classe auxiliar.
	 */
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double desconto;
	private Integer quantidade;
	private BigDecimal preco;
	
	public ItemPedido() {}
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, BigDecimal preco) {
		id.comporChavesDeAssoicao(pedido, produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}	
}
