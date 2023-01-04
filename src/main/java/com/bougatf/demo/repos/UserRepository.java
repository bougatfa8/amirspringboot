package com.bougatf.demo.repos;



import org.springframework.data.jpa.repository. JpaRepository;

import com.bougatf.demo.entites.User;
public interface UserRepository extends JpaRepository <User, Long>{
	User findByUsername(String username);

}
