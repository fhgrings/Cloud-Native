package com.github.vinifkroth.cloudnative.tema2.model;

public class Pet {
	private String id, name, race;
	private int age;
	private double totalRevenue;

	public Pet(String id, String name, String race, int age) {
		this.id = id;
		this.name = name;
		this.race = race;
		this.age = age;
		totalRevenue = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", race=" + race + ", age=" + age + ", totalRevenue=" + totalRevenue
				+ "]";
	}

}
