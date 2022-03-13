package com.demos.springtest;

import com.demos.springtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringtestApplication implements CommandLineRunner {

    final EmployeeService employeeService;

    public SpringtestApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        System.setProperty("jasypt.encryptor.password", "change");
        SpringApplication.run(SpringtestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(employeeService.findAllEmployees());
    }
}