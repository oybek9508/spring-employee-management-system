package com.spring_boot.employee_management.repository;

import com.spring_boot.employee_management.entity.Role;
import com.spring_boot.employee_management.entity.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
