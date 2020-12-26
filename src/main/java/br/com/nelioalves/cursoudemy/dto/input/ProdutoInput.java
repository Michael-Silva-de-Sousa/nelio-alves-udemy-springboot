package br.com.nelioalves.cursoudemy.dto.input;

import java.util.ArrayList;
import java.util.List;

import br.com.nelioalves.cursoudemy.dominio.Categoria;
import br.com.nelioalves.cursoudemy.dominio.Produto;
import lombok.Getter;

@Getter
public class ProdutoInput {
	private Produto produto;
	private List<Categoria> categorias = new ArrayList<>();
}
