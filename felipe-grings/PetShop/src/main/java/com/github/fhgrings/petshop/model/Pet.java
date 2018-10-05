package com.github.fhgrings.petshop.model;

import java.util.ArrayList;
import java.util.List;

public class Pet implements Comparable<Pet> {
    private int id;
    private int age;
    private String race;
    private List<String> petService;
    private String name;
    private double revenue;

    public Pet(int id, int age, String race, String name) {
        this.id = id;
        this.age = age;
        this.race = race;
        this.name = name;
        petService = new ArrayList<>();
    }

    public Pet() {

    }

    public void setPetService(List<String> petService) {
        this.petService = petService;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPetService() {
        return petService;
    }

    public String setPetService(String petServiceDone) {
        petService.add(petServiceDone);
        return petServiceDone;
    }

    public double getRevenue() {
        return revenue;
    }

    public void addRevenue(double revenue) {
        this.revenue += revenue;
    }

    @Override
    public String toString() {
        return "Name: " + name + " ID: " + id;
    }

    @Override
    public int compareTo(Pet pet) {
        if(this.revenue<pet.getRevenue())
            return 1;
        else if(pet.getRevenue()<this.revenue)
            return -1;
        return 0;
    }
}
