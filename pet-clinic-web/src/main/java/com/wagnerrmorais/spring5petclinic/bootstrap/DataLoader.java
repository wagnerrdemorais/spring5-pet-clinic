package com.wagnerrmorais.spring5petclinic.bootstrap;

import com.wagnerrmorais.spring5petclinic.model.Owner;
import com.wagnerrmorais.spring5petclinic.model.Vet;
import com.wagnerrmorais.spring5petclinic.services.OwnerService;
import com.wagnerrmorais.spring5petclinic.services.VetService;
import com.wagnerrmorais.spring5petclinic.services.map.OwnerServiceMap;
import com.wagnerrmorais.spring5petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Pedrito");
        owner1.setLastName("Pedroso");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Brabolino");
        owner2.setLastName("Braboso");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Fiona");
        vet1.setLastName("The Ogre");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alex");
        vet2.setLastName("Armstrong");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
