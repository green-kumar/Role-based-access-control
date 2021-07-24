package com.locus.rbac.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.locus.rbac.entity.RolePermission;

@Repository
public class RolePermissionRepository {
	
	
Map<String,RolePermission> rolePermissionMap;
	
	/**
	 * store the permission list in-memory
	 * 
	 */
	public void createRolePermission(RolePermission rolePermission) {
		
		if(rolePermissionMap == null) {
			rolePermissionMap = new HashMap<String,RolePermission>();
		}
		
		String roleId = rolePermission.getRole().getId();
		rolePermissionMap.put(roleId, rolePermission);
		
	}
	
	
	public RolePermission getRolePermission(String roleId) {
		
		if(rolePermissionMap.containsKey(roleId)) {
			return rolePermissionMap.get(roleId);
		}
		
		return null;
		
	}

}
