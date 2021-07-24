package com.locus.rbac.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.locus.rbac.entity.User;

@Repository
public class UserRepository {

	Map<String,User> userMap;
	
	 public void createUser(User user) {
		 
		 if(userMap == null) {
			 userMap = new HashMap<String,User>();
		 }
		 userMap.put(user.getId(),user);
		 
	 }
	 
	 public User getUser(String userId) {
		 return userMap.get(userId);
	 }
}
