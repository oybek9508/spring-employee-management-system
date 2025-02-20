package com.spring_boot.employee_management.bootstrap;

import com.spring_boot.employee_management.dtos.RegisterUserDto;
import com.spring_boot.employee_management.entity.Role;
import com.spring_boot.employee_management.entity.RoleEnum;
import com.spring_boot.employee_management.entity.User;
import com.spring_boot.employee_management.repository.RoleRepository;
import com.spring_boot.employee_management.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AdminSeeder(
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.createSuperAdministrator();
    }

    private void createSuperAdministrator() {
        RegisterUserDto userDto = new RegisterUserDto();
        userDto.setFullName("Super Admin");
        userDto.setEmail("super_admin@email.com");
        userDto.setPassword("123456");

        Role role = roleRepository.findByName(RoleEnum.SUPER_ADMIN).orElseThrow(() -> new RuntimeException("Role Super Admin not found"));
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            return;
        }

        var user = new User();

        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(role);

        userRepository.save(user);
    }
}
