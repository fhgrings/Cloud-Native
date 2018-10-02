package com.github.rafaritter44.cloud_native.petstore.model;

import com.github.rafaritter44.cloud_native.petstore.petservices.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pet {

    private int id;
    private String name;
    private String race;
    private int age;
    private List<PetService> petServices;

    public Pet(String name, String race, int age) {
        id = PetStore.getID();
        this.name = name;
        this.race = race;
        this.age = age;
        petServices = new ArrayList<>();
    }

    public int revenue() {
        return petServices.stream()
                .mapToInt(PetService::charge)
                .sum();
    }

    public String displayPetAndRevenue() {
        return toString() + " | Revenue: " + revenue();
    }

    public String displayPetServices() {
        Map<String, Integer> petServicesCount = new HashMap();
        StringBuilder builder = new StringBuilder()
                .append("Pet Services:\n");
        for(PetService petService: petServices) {
            String petServiceName = petService.getClass().getSimpleName();
            Integer count = petServicesCount.get(petServiceName);
            petServicesCount.put(petServiceName, count == null ? 1 : ++count);
        }
        for(String petServiceName: petServicesCount.keySet()) {
            builder.append(petServiceName).append(": ")
                    .append(petServicesCount.get(petServiceName)).append("\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Race: " + race + " | Age: " + age;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRace() { return race; }
    public void setRace(String race) { this.race = race; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public ArrayList<PetService> getPetServices() { return new ArrayList<>(petServices); }
    public void add(PetService petService) { petServices.add(petService); }

}
