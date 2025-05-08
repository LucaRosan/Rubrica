package it.rubrica.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.rubrica.model.Contatto;

public interface ContattiRepository extends CrudRepository<Contatto, Integer>{
    List<Contatto> findAllByOrderByCognomeAsc();
}
