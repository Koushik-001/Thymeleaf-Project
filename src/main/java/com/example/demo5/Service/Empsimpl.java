package com.example.demo5.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo5.Dao.Empdao;
import com.example.demo5.Entity.Employee;
@Service
public class Empsimpl implements Empservice {
private Empdao empdao;
public Empsimpl(Empdao empdao1){
    empdao=empdao1;
}
    @Override
    public List<Employee> findAll() {
    return empdao.findAll();   
    }

    @Override
    public void save(Employee employee) {
    empdao.save(employee);    
    }
    @Override
    public Employee findById(int Id) {
        Optional<Employee> result = empdao.findById(Id);
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + Id);
		}
        return theEmployee;    
    }
    
    @Override
    public void deleteById(int Id) {
     empdao.deleteById(Id);    
    }

       
}
