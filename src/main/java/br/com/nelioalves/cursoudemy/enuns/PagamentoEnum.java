package br.com.nelioalves.cursoudemy.enuns;

import lombok.Getter;

@Getter
public enum PagamentoEnum {
	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private int id;
	private String descricao;

	private PagamentoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static PagamentoEnum toEnum(Integer id) {
		if (id == null)
			return null;

		for (PagamentoEnum c : PagamentoEnum.values())
			if (id.equals(c.getId()))
				return c;

		return null;
	}
}
