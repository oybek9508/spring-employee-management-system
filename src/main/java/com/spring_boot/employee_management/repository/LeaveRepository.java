package com.spring_boot.employee_management.repository;

import com.spring_boot.employee_management.entity.Leave;
import com.spring_boot.employee_management.enums.LeaveEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveRepository extends CrudRepository<Leave, Integer> {
    Optional<Leave> findByName(LeaveEnum name);
}
