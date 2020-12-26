package br.com.nelioalves.cursoudemy.enuns;

import lombok.Getter;

@Getter
public enum ClienteEnum {
	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int id;
	private String descricao;

	private ClienteEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static ClienteEnum toEnum(Integer id) {
		if (id == null)
			return null;

		for (ClienteEnum c : ClienteEnum.values())
			if (id.equals(c.getId()))
				return c;

		return null;
	}
}
