package com.wagnerrmorais.spring5petclinic.repositories;

import com.wagnerrmorais.spring5petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
