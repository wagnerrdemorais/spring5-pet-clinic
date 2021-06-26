package com.wagnerrmorais.spring5petclinic.repositories;

import com.wagnerrmorais.spring5petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
