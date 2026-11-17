package org.example.aop.service;

import org.example.aop.configuration.TrackExecution;
import org.example.aop.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    @TrackExecution
    public EmployeeDTO getEmployee(String id){
        return new EmployeeDTO(id,"John");
    }

    @TrackExecution
    public String saveEmployee(EmployeeDTO employeeDTO){
        return "employee saved successfully";
    }

    public String deleteEmployee(String id){
        return "employee deleted successfully";
    }
}
