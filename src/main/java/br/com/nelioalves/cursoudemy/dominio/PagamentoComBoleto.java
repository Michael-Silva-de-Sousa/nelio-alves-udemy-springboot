package br.com.nelioalves.cursoudemy.dominio;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
public class PagamentoComBoleto extends Pagamento {
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	
	public PagamentoComBoleto() {}

	public PagamentoComBoleto(Long id, Integer pagamentoEnum, LocalDate dataVencimento, LocalDate dataPagamento) {
		super(id, pagamentoEnum);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}	
}
