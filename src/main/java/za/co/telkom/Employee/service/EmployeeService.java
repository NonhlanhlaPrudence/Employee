package za.co.telkom.Employee.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.telkom.Employee.exceptions.ResourceNotFoundException;
import za.co.telkom.Employee.model.Employee;
import za.co.telkom.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
    }

    // -------------------------------GET - get employees--------------------------------------- 
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();

        if (Objects.isNull(employees) || employees.isEmpty()) {
            throw new ResourceNotFoundException("Employees not found");
        }

        return employees;
   }

    // ---------------------------GET BY ID - get employee by id/salaryRef----------------------
    public Employee getEmployeeId(Long id){
        Employee employee = employeeRepository.findById(id).get();
        //.orElseThrow(() -> new ResourceNotFoundException(String.format("Employee not found for ID : %s", id)));

        return employee;
    }

    // -----------------------------------DELETE - delete employee------------------------------- 
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id); 
       }

    // ---------------------PUT - update employee information-----------------------------------
    public Employee employeeUpdate(Long id, Employee employee)
    {
       return employeeRepository.save(employee);

    }
    
}
