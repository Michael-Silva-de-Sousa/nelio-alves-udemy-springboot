package br.com.nelioalves.cursoudemy.util;

import java.util.HashSet;
import java.util.Set;

public class ValidadorTelefone {

	public static Set<String> telefonesValidos(Set<String> telefones) {
		Set<String> telefonesValidos = new HashSet<String>();
		
		for(String t : telefones) {
			var telefoneLimpo = t.replaceAll("[^0-9]", "");
			
			if(ehTelefoneValido(telefoneLimpo))
				telefonesValidos.add(telefoneLimpo);
		}
		
		return telefonesValidos;
	}
	
	private static boolean ehTelefoneValido(String telefone) {		
		if(telefone.isBlank() || telefone.isEmpty())
			return false;
		if(telefone.length() > 11)
			return false;
		
		return true;
	}
}