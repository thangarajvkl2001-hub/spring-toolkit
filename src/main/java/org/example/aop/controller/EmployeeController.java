package org.example.aop.controller;

import org.example.aop.dto.EmployeeDTO;
import org.example.aop.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployerService employerService;

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable String id){
        return employerService.getEmployee(id);
    }
}
