package com.bougatf.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bougatf.demo.entites.Role;
import com.bougatf.demo.entites.User;
import com.bougatf.demo.repos.RoleRepository;
import com.bougatf.demo.repos.UserRepository;

@Transactional
@Service
public class UsersServiceImpl implements UserService { 

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Autowired

	 BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public Role addRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRepository.findByUsername(username);
		Role role =roleRepository.findByRole(rolename);
		
		usr.getRoles().add(role);
		
		//userRepository.save(usr);
		
		return usr; 
	}

}
