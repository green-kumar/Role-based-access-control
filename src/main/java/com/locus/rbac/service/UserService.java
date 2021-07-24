package com.locus.rbac.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locus.rbac.entity.Action;
import com.locus.rbac.entity.Resource;
import com.locus.rbac.entity.Role;
import com.locus.rbac.entity.RolePermission;
import com.locus.rbac.entity.User;
import com.locus.rbac.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RolePermissionService rolePermissionService;
	
	public void createUser(User user) {
		
		userRepository.createUser(user);
		
	}
	
	public void addRole(String userId,Role role) {
		User user = userRepository.getUser(userId);
		Set<Role> roleList = user.getRoleList();
		
		 if(roleList == null) {
			 roleList = new HashSet<Role>();
			 roleList.add(role);
			 userRepository.createUser(user);
		 }else {
			 if(!roleList.contains(role)) {
				 roleList.add(role);
				 userRepository.createUser(user);
			 }
			 
		 }
		
	}
	
	
	public void removeRole(String userId,Role role) {
		User user = userRepository.getUser(userId);
		Set<Role> roleList = user.getRoleList();
		
		 if(roleList != null && roleList.contains(role)) {
			
			 roleList.remove(role);
			 userRepository.createUser(user);
		 }
		 }
	

  public boolean checkAccess(User user, Action action,Resource resource) {
	  
	  Set<Role> roleList = user.getRoleList();
	  
	  boolean access = false;
	  
	  for(Role role : roleList) {
		  
		  RolePermission rolePermission = rolePermissionService.getRolePermission(role.getId());
		  
		  if(rolePermission.getAction().equals(action) && rolePermission.getResource().equals(resource)) {
			  access = true;
			  break;
		  }
	  }
	  
	  return access;
	  
	  
	  
  }
}