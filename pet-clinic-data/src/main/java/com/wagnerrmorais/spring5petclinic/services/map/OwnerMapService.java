package com.wagnerrmorais.spring5petclinic.services.map;

import com.wagnerrmorais.spring5petclinic.model.Owner;
import com.wagnerrmorais.spring5petclinic.model.Pet;
import com.wagnerrmorais.spring5petclinic.services.OwnerService;
import com.wagnerrmorais.spring5petclinic.services.PetService;
import com.wagnerrmorais.spring5petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    //REALLY bad code here, not gonna fix now, just following course instructions
    @Override
    public Owner save(Owner owner) {
        if(owner != null) {
            if(owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        }else{
            return null;
        }
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
