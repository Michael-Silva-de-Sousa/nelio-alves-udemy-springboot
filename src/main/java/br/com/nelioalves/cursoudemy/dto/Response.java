package br.com.nelioalves.cursoudemy.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Response<T> {
	private T data;
    private Set<String> errors = new HashSet<>();
    
    public Response(T data, Set<String> errors) {
    	this.data = data;
    	this.errors = errors;
    }
}
