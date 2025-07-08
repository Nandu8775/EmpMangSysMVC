package com.ty.EmployeeManagementSystemMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.EmployeeManagementSystemMVC.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
