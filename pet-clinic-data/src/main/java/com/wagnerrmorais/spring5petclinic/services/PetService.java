package com.wagnerrmorais.spring5petclinic.services;

import com.wagnerrmorais.spring5petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
