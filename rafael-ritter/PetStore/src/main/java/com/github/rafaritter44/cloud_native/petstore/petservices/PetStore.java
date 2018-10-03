package com.github.rafaritter44.cloud_native.petstore.petservices;

import com.github.rafaritter44.cloud_native.petstore.model.Pet;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@Singleton
public class PetStore {

    private Map<Integer, Pet> pets;
    private static int petCount;

    public PetStore() {
        pets = new HashMap<>();
        petCount = 1;
    }

    public static int getID() {
        return petCount++;
    }

    public void addPet(Pet pet) {
        pets.put(pet.getId(), pet);
    }

    public Optional<Pet> removePet(int id) {
        return Optional.ofNullable(pets.remove(id));
    }

    public String displayPetsByAge(int age) {
        return age + "-Year(s) Old Pets:\n" +
                petsByAge(age).stream()
                .map(Pet::toString)
                .collect(joining("\n"));
    }

    private List<Pet> petsByAge(int age) {
        return pets.values()
                .stream()
                .filter(pet -> pet.getAge() == age)
                .collect(toList());
    }

    protected void doDryBathWithPerfume(int id, PetService petService) {
        pets.get(id).add(petService);
        bathNotification(id, "dry", "with perfume");
    }

    protected void doDryBathWithoutPerfume(int id, PetService petService) {
        pets.get(id).add(petService);
        bathNotification(id, "dry", "without perfume");
    }

    protected void doWaterBathWithPerfume(int id, PetService petService) {
        pets.get(id).add(petService);
        bathNotification(id, "water", "with perfume");
    }

    protected void doWaterBathWithoutPerfume(int id, PetService petService) {
        pets.get(id).add(petService);
        bathNotification(id, "water", "without perfume");
    }

    protected void doShortHaircut(int id, PetService petService) {
        pets.get(id).add(petService);
        haircutNotification(id, "short");
    }

    protected void doLongHaircut(int id, PetService petService) {
        pets.get(id).add(petService);
        haircutNotification(id, "long");
    }

    private void bathNotification(int id, String bathType, String bathPerfume) {
        System.out.println(pets.get(id).getName() + " took a " + bathType + " bath " + bathPerfume);
    }

    private void haircutNotification(int id, String haircut) {
        System.out.println(pets.get(id).getName() + " had a " + haircut + " haircut");
    }

    public String displayPetServicesHistory() {
        StringBuilder builder = new StringBuilder()
                .append("Pet Services History:\n");
        for(Pet pet: pets.values()) {
            builder.append(pet)
                    .append("\n")
                    .append(pet.displayPetServices());
        }
        return builder.toString();
    }

    public String displayTop10PetRevenue() {
        return "Top 10 Pet Revenue:\n" +
                top10PetRevenue().stream()
                .map(Pet::displayPetAndRevenue)
                .collect(joining("\n"));
    }

    private List<Pet> top10PetRevenue() {
        return pets.values()
                .stream()
                .sorted(comparing(Pet::revenue).reversed())
                .limit(10)
                .collect(toList());
    }

}
