package com.fafr.model.player;

import org.jetbrains.annotations.NotNull;

public class Player implements Comparable<Player>{

	// Essential member variables
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer height;
	private Integer weight;
	private Integer jersey;
	private String position;
	private String team;
	private String archetype;


	// ratings interface

	public Player() {

	}

	public Player(Integer id, String firstName, String lastName, Integer age, Integer height,
				  Integer weight, Integer jersey, String position, String team, String archetype) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.jersey = jersey;
		this.position = position;
		this.team = team;
		this.archetype = archetype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getJersey() {
		return jersey;
	}

	public void setJersey(Integer jersey) {
		this.jersey = jersey;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getArchetype() {
		return archetype;
	}

	public void setArchetype(String archetype) {
		this.archetype = archetype;
	}

	@Override
	public int compareTo(@NotNull Player o) {
		return this.getId() - o.getId();
	}


	//	@Override
//	public String toString() {
//		return "playerInfo [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
//				+ ", weight=" + weight + ", college=" + college + ", id=" + id + ", position=" + position + ", height="
//				+ height + "]";
//	}


}
