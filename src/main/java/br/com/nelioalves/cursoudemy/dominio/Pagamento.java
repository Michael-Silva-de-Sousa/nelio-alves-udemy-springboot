package br.com.nelioalves.cursoudemy.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.com.nelioalves.cursoudemy.enuns.PagamentoEnum;
import lombok.Getter;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento {
	@Id	
	private Long id;
	private Integer pagamentoEnum;
	
	//Mapeamento um-para-um bi-direcional.
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {}
	
	public Pagamento(Long id, Integer pagamentoEnum) {	
		this.id = id;
		this.pagamentoEnum = pagamentoEnum;
	}	
	
	public PagamentoEnum getPagamentoEnum() {
		return PagamentoEnum.toEnum(pagamentoEnum);
	}
}
