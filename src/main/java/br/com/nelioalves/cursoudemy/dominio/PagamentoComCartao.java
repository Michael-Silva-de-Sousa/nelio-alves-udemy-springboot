package br.com.nelioalves.cursoudemy.dominio;

import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
public class PagamentoComCartao extends Pagamento {
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {}

	public PagamentoComCartao(Long id, Integer pagamentoEnum, Integer numeroDeParcelas) {
		super(id, pagamentoEnum);
		this.numeroDeParcelas = numeroDeParcelas;
	}	
}
