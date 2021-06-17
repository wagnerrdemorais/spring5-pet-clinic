package com.wagnerrmorais.spring5petclinic.services;

import com.wagnerrmorais.spring5petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
