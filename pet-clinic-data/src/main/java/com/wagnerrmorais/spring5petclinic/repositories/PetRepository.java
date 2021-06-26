package com.wagnerrmorais.spring5petclinic.repositories;

import com.wagnerrmorais.spring5petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
