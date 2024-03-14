package com.example.springdatajpa;

import com.example.springdatajpa.model.Employee;
import com.example.springdatajpa.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        EmployeeRepository employeeRepo = context.getBean(EmployeeRepository.class);

        List<Employee> employees = List.of(
                new Employee("John Doe", LocalDate.of(2014, 12, 4), true),
                new Employee("Jane Doe", LocalDate.of(2015, 1, 5), false),
                new Employee("Jack Doe", LocalDate.of(2016, 2, 6), true),
                new Employee("Jill Doe", LocalDate.of(2017, 3, 7), false)
        );
        employeeRepo.saveAll(employees);

        employeeRepo.findAllByMarriedIsFalse().forEach(System.out::println);
    }

}
