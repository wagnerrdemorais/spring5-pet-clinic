package com.wagnerrmorais.spring5petclinic.bootstrap;

import com.wagnerrmorais.spring5petclinic.model.*;
import com.wagnerrmorais.spring5petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Pedrito");
        owner1.setLastName("Pedroso");
        owner1.setAddress("123 somewhere");
        owner1.setCity("Cascavel");
        owner1.setTelephone("1234567890");

        Pet pedritoPet = new Pet();
        pedritoPet.setName("DogName");
        pedritoPet.setPetType(savedDogPetType);
        pedritoPet.setOwner(owner1);
        pedritoPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(pedritoPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Brabolino");
        owner2.setLastName("Braboso");
        owner2.setAddress("123 There");
        owner2.setCity("SomeCity");
        owner2.setTelephone("0987654321");

        Pet brabolinoPet = new Pet();
        brabolinoPet.setName("CatName");
        brabolinoPet.setPetType(savedCatPetType);
        brabolinoPet.setOwner(owner1);
        brabolinoPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(brabolinoPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(brabolinoPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Angry Cat");
        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet fiona = new Vet();
        fiona.setFirstName("Fiona");
        fiona.setLastName("The Ogre");
        fiona.getSpecialties().add(savedRadiology);
        vetService.save(fiona);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alex");
        vet2.setLastName("Armstrong");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Clarice");
        vet3.setLastName("Ramona");
        vet3.getSpecialties().add(savedDentistry);
        vetService.save(vet3);

        System.out.println("Loaded Vets...");
    }
}
