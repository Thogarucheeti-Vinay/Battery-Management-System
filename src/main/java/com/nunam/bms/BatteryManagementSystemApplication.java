package com.nunam.bms;

import com.nunam.bms.dao.entity.User;
import com.nunam.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan("com.nunam.bms.*")
public class BatteryManagementSystemApplication {

    @Autowired
    private static UserRepository userRepository;

    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static void main(String[] args) {

        System.out.println("Application Started..!!");
        SpringApplication.run(BatteryManagementSystemApplication.class, args);

        User user1 = new User();
        user1.setUsername("vinay");
        user1.setPassword(passwordEncoder.encode("vinay@123"));
        user1.setRoles("normal");
        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword(passwordEncoder.encode("admin@123"));
        user2.setRoles("ROLE_USER,ROLE_ADMIN");
        userRepository.save(user1);
        userRepository.save(user2);
    }

}
