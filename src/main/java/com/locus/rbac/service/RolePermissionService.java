package com.locus.rbac.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.locus.rbac.entity.Action;
import com.locus.rbac.entity.Resource;
import com.locus.rbac.entity.Role;
import com.locus.rbac.entity.RolePermission;
import com.locus.rbac.repository.RolePermissionRepository;


@Service
public class RolePermissionService {
	
    @Autowired
	RolePermissionRepository  rolePermissionRepository;

    public void createRolePermissin(Role role,Action action,Resource resource) {
    	
		    	RolePermission  rolePermission  = rolePermissionRepository.getRolePermission(role.getId());
		    	if(rolePermission == null) {
		    		 rolePermission = new RolePermission(role,action,resource);
		    	}
		    	rolePermissionRepository.createRolePermission(rolePermission);
    	
    }
    
    public RolePermission getRolePermission(String roleId) {
    	    
    return rolePermissionRepository.getRolePermission(roleId);
    	     
		
	}
    
    

}
