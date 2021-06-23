package com.wagnerrmorais.spring5petclinic.bootstrap;

import com.wagnerrmorais.spring5petclinic.model.Owner;
import com.wagnerrmorais.spring5petclinic.model.PetType;
import com.wagnerrmorais.spring5petclinic.model.Vet;
import com.wagnerrmorais.spring5petclinic.services.OwnerService;
import com.wagnerrmorais.spring5petclinic.services.PetTypeService;
import com.wagnerrmorais.spring5petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Pedrito");
        owner1.setLastName("Pedroso");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Brabolino");
        owner2.setLastName("Braboso");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Fiona");
        vet1.setLastName("The Ogre");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alex");
        vet2.setLastName("Armstrong");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
