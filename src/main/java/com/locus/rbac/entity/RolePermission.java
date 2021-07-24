package com.locus.rbac.entity;

public class RolePermission {
	
	Role role;
	
	Action action;
	
	Resource resource;

	public RolePermission(Role role, Action action2, Resource resource) {
		super();
		this.role = role;
		this.action = action2;
		this.resource = resource;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	
	
	
}
