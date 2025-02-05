package com.spring_boot.employee_management.repository;

import com.spring_boot.employee_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
