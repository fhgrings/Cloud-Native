package com.github.rafaritter44.cloud_native.petstore.model;

import com.github.rafaritter44.cloud_native.petstore.petservices.*;
import java.util.ArrayList;
import java.util.List;

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
        StringBuilder builder = new StringBuilder()
                .append("Pet Services:\n");
        int dryWithoutCount = 0, dryWithCount = 0, longHairCount = 0,
                shortHairCount = 0, waterWithoutCount = 0, waterWithCount = 0;
        for(PetService petService: petServices) {
            if(petService instanceof DryBathWithoutPerfume)
                dryWithoutCount++;
            else if(petService instanceof DryBathWithPerfume)
                dryWithCount++;
            else if(petService instanceof LongHaircut)
                longHairCount++;
            else if(petService instanceof ShortHaircut)
                shortHairCount++;
            else if(petService instanceof WaterBathWithoutPerfume)
                waterWithoutCount++;
            else if(petService instanceof WaterBathWithPerfume)
                waterWithCount++;
        }
        return builder.append("Dry baths without perfume: ").append(dryWithoutCount).append("\n")
                .append("Dry baths with perfume: ").append(dryWithCount).append("\n")
                .append("Water baths without perfume: ").append(waterWithoutCount).append("\n")
                .append("Water baths with perfume: ").append(waterWithCount).append("\n")
                .append("Short haircuts: ").append(shortHairCount).append("\n")
                .append("Long haircuts: ").append(longHairCount).toString();
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
