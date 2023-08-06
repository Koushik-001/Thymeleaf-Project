package com.example.demo5.Service;

import java.util.List;

import com.example.demo5.Entity.Employee;

public interface Empservice  {
public List<Employee> findAll();
void save(Employee employee);  
Employee findById(int Id);
public void deleteById(int Id);
}
