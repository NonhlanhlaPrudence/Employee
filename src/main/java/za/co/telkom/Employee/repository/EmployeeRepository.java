package za.co.telkom.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.telkom.Employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
