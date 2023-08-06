package com.example.demo5.Rest;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo5.Service.Empservice;
import com.example.demo5.Entity.Employee;
@Controller
@RequestMapping("/employees")
public class Restcontroller {

    private Empservice empservice;
    public Restcontroller(Empservice empservice1){
        empservice=empservice1;
    }
    /*@GetMapping("/list")
    public List<Employee> findAll(){
        return empservice.findAll();
    }*/
    @GetMapping("/list")
    public String listemployee(Model model){
       List<Employee> employee = empservice.findAll();
        model.addAttribute("employees", employee);
    return "list-employees";
    }
    @GetMapping("/showformforadd")
    public String showformforadd(Model model){
        Employee theemployee = new Employee();
        model.addAttribute("employee", theemployee);
    return "employee-form";
    }
@PostMapping("/save")
public String saveEmployee(@ModelAttribute("employee") Employee themployee){
    empservice.save(themployee);
    return "redirect:/employees/list";
}
    @GetMapping("/showformforupdate")
public String showformforupdate(@RequestParam("employeeId")int theid,Model model){
    Employee theemployee = empservice.findById(theid);
    model.addAttribute("employee", theemployee);
    return "employee-form";
}

@GetMapping("/delete")
public String delete(@RequestParam("employeeId")int theid){
    empservice.deleteById(theid);
    return "redirect:/employees/list";
}

}

