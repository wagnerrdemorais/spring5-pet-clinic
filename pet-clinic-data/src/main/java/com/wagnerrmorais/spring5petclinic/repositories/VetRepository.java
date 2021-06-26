package com.wagnerrmorais.spring5petclinic.repositories;

import com.wagnerrmorais.spring5petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
