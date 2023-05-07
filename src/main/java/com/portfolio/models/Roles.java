package com.portfolio.models;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;



@Entity
public class Roles  {
	@Id
	private int roleId;

	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> user;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(String roleName, List<User> user) {
		super();
		this.roleName = roleName;
		this.user = user;
	}
	

	public Roles(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}


}
