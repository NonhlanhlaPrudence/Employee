package za.co.telkom.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.telkom.Employee.model.Employee;
import za.co.telkom.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // POST - create employee
    // public Employee createEmployee(String name, String surname, String salaryRef) {
    //     Employee employee = new Employee();
    //     employee.setName(name);
    //     employee.setSurname(surname);
    //     employee.setSalaryRef(salaryRef);

    //     return employee;
    // }

    public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
    }

    // -------------------------------GET - get employees--------------------------------------- 
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
   }

    // ---------------------------GET BY ID - get employee by id/salaryRef----------------------
    public Employee getEmployeeId(Long id){
        Employee employee = employeeRepository.findById(id).get();

        return employee;
    }

    // -----------------------------------DELETE - delete employee------------------------------- 
    public  String deleteEmployee(Long id){
        employeeRepository.deleteById(id); 
        return "Employee deleted successfully";
       }

    // ---------------------PUT - update employee information-----------------------------------
    public Employee employeeUpdate(Long id, Employee employee)
    {
       return employeeRepository.save(employee);

    }
    
}
