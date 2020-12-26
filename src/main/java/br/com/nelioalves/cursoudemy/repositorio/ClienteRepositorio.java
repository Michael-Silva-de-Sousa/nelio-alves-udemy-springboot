package br.com.nelioalves.cursoudemy.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nelioalves.cursoudemy.dominio.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
}
