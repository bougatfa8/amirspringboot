package com.bougatf.demo;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.JsonPath;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/register")
@SpringBootApplication
public class UsersMicroservicesApplication {

	@Autowired
	UserService userService;
	@Autowired
	RoleRepository roleRepository;
	
	
	@Autowired

	 BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	@Autowired
	UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(  UsersMicroservicesApplication.class, args);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public User insert(@RequestBody  User user) {

		
		
		
		user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		

		 
	
	return user;
	}

	
/*	@PostConstruct
	void init_users() {
	ajouter les rôles
	userService.addRole (new Role (null, "ADMIN") );
	userService.addRole (new Role (null, "USER"));
	
	
	//ajouter les users
	
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"ahmed","123",true,null));
	userService.saveUser(new User(null,"bougatfa","123",true,null));
	
	
	//ajouter ies roLes aux userS

	userService.addRoleToUser( "admin","ADMIN" );
	userService.addRoleToUser("admin", "USER");
	userService.addRoleToUser("ahmed", "USER");
	userService. addRoleToUser("bougatfa", "USER");
	}
	

	*/
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}
	

}
