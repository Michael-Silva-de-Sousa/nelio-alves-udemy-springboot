package br.com.nelioalves.cursoudemy.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nelioalves.cursoudemy.dominio.Estado;

@Repository
public interface EstadoRespositorio extends JpaRepository<Estado, Long>{

}
