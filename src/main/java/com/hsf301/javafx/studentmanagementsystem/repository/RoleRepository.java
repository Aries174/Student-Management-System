package com.hsf301.javafx.studentmanagementsystem.repository;

import com.hsf301.javafx.studentmanagementsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
