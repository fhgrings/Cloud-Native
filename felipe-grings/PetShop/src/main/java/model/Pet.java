package model;

import java.util.ArrayList;
import java.util.List;

public class Pet implements Comparable<Pet> {
    private int id;
    private int age;
    private String race;
    private List<String> petService;



    private double revenue;

    public Pet() {
    }

    public Pet(int id, int age, String race, String name) {
        this.id = id;
        this.age = age;
        this.race = race;
        this.name = name;
        petService = new ArrayList<>();
    }

    private String name;

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

    public void setPetService(String petServiceDone) {
        petService.add(petServiceDone);
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
