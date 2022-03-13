package com.demos.springtest.service;

import com.demos.springtest.dao.EmployeeRepository;
import com.demos.springtest.entity.Employee;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
@Data
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees(){
        ExecutorService service = Executors.newFixedThreadPool(2);
        justCheck(service);
        return employeeRepository.findAll();
    }

    public void justCheck(ExecutorService executorService){
        System.out.println(executorService);
    }
}
