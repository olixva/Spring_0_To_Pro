package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findAllByFullName(String fullName);

    Optional<Employee> findByFullNameAndBirthday(String fullName, LocalDate birthday);

    List<Employee> findAllByBirthdayBetween(LocalDate min, LocalDate max);

    List<Employee> findAllByMarriedIsFalse();

}
