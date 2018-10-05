package com.github.vinifkroth.cloudnative.tema2.model;

public class Pet {
	private Integer id;
	private String name;
	private String race;
	private Integer age;
	private Double totalRevenue;

	public Pet(Integer id, String name, String race, Integer age) {
		this.id = id;
		this.name = name;
		this.race = race;
		this.age = age;
		totalRevenue = 0.0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", race=" + race + ", age=" + age + ", totalRevenue=" + totalRevenue
				+ "]";
	}

}
