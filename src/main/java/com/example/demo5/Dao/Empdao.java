package com.example.demo5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo5.Entity.Employee;

public interface Empdao  extends JpaRepository<Employee,Integer>{
    
}
