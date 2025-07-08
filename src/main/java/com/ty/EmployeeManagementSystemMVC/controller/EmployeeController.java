package com.ty.EmployeeManagementSystemMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.EmployeeManagementSystemMVC.entity.Employee;
import com.ty.EmployeeManagementSystemMVC.repository.EmployeeRepo;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;

   
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("employees", repo.findAll());
        return "list";  
    }

    
    @GetMapping("/new")
    public String showEmpForm(Model model) {
        model.addAttribute("employee", new Employee()); 
        return "form";  
    }

    
    @PostMapping("/save")
    public String saveEmp(@Valid@ModelAttribute("employee") Employee emp,BindingResult result,Model model) {
    	if(result.hasErrors()) {
    		return"form";
    	}
        repo.save(emp);
        return "redirect:/";
    }

   
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("employee", repo.findById(id).get());
        return "form";
    }

    
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
