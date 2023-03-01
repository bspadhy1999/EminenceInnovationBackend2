package com.eminanceinnovation;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eminanceinnovation.model.Role;
import com.eminanceinnovation.model.User;
import com.eminanceinnovation.model.UserRole;
import com.eminanceinnovation.service.UserService;

@SpringBootApplication

public class EminenceInnovationDatabaseApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(EminenceInnovationDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Project is running...");
		
		/* User user=new User();
		user.setFirstName("Bhabani Sankar");
		user.setLastName("Padhy");
		user.setEmail("bspadhy1999@gmail.com");
		user.setPhone("6370023010");
		user.setProfile("profile.png");
		user.setUsername("bspadhy1999");
		user.setPassword(this.bCryptPasswordEncoder.encode("123456"));
		
		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		
		User user1=this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername()); */
	}

}
