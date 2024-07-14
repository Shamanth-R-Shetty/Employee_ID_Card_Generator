package com.boostmytool.bestemp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Integer> {
    

}
