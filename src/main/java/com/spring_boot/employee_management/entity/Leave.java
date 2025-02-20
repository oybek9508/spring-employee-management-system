package com.spring_boot.employee_management.entity;

import com.spring_boot.employee_management.enums.LeaveEnum;
import com.spring_boot.employee_management.enums.LeaveStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "leaves")
@Data
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "leave", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private LeaveEnum name;

    @Column(nullable = false)
    private String description;

    @Column(name = "status")
    private LeaveStatus status;

    private String reason;

    private Date startDate;

    private Date endDate;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdDt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedDt;
}
