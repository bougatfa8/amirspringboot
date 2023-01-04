package com.bougatf.demo.service;

import com.bougatf.demo.entites.Role;
import com.bougatf.demo.entites.User;

public interface UserService {
	
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole ( Role role);
	User addRoleToUser (String username, String rolename);

}
