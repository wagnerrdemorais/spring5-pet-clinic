package com.wagnerrmorais.spring5petclinic.services;

import com.wagnerrmorais.spring5petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
