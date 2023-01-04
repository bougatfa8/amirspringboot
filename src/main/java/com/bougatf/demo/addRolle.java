package com.bougatf.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bougatf.demo.entites.Role;
import com.bougatf.demo.entites.User;
import com.bougatf.demo.repos.RoleRepository;
import com.bougatf.demo.repos.UserRepository;
import com.bougatf.demo.service.UserService;

@RestController
@RequestMapping("/role")
public class addRolle {
	 
	@Autowired
	UserService userService;
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(  UsersMicroservicesApplication.class, args);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public void insert(@RequestBody  User user) {

		
		
		
		
		

		 userRepository.findByUsername(user.getUsername());
		 User usr = userRepository.findByUsername(user.getUsername());
			Role role =roleRepository.findByRole("USER");
			
			userService.addRoleToUser( user.getUsername(),user.getPassword() );
	
	
	}




}
