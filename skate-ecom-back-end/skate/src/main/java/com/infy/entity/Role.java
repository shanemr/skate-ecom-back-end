package com.infy.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	
	public Role() {};
	
	
	public Role(String name, List<UserEntity> users) {
		super();
		this.name = name;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy="role")
	private List<UserEntity> users;

	
	public int getId() {
		return id;
	}


	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<UserEntity> getUsers() {
		return users;
	}


	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
