package com.api.msuser;


import com.api.msuser.model.enuns.RoleName;
import com.api.msuser.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class MsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUserApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha"));
	}

//	CommandLineRunner run(UserService userService){
//		return args->{
//			userService.addRoleToUser("111111111",RoleName.ROLE_ADMIN);
//			userService.addRoleToUser("111111111",RoleName.ROLE_USER);
//			userService.addRoleToUser("22222222",RoleName.ROLE_USER);
//
//
//		};
//	}
	}
