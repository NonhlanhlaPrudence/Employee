package za.co.telkom.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.telkom.Employee.model.Employee;
import za.co.telkom.Employee.service.EmployeeService;


@RestController
public class EmployeeController {
    

    @Autowired
    private EmployeeService employeeService;

    // -----------------------------create employee------------------------------------
    @PostMapping(value = "/employee/createEmployee",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@RequestBody Employee employee){
     
        return employeeService.createEmployee(employee);
    }


    // ----------------------------Get all employees---------------------------------
    @GetMapping(value = "/employee/getEmployees",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    //-----------------------------Get by Id-----------------------------------------
    @RequestMapping(value = "/employee/getEmployeeId/{id}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Employee getEmployeeId(@PathVariable(name = "id", required = true) Long id){
    return employeeService.getEmployeeId(id);   
    }

    //-------------------------------Deleting by ID-----------------------------------------
    @RequestMapping(value = "/employee/deleteEmployee/{id}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable(name = "id", required = true) Long id){
        employeeService.deleteEmployee(id);
    }

    //-------------------------------Updating-------------------------------------- 
    @RequestMapping(value = "/employee/employeeUpdate/{id}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public Employee employeeUpdate(@PathVariable(name = "id", required = true) Long id, @RequestBody Employee employeeUpdate){
        return employeeService.employeeUpdate(id, employeeUpdate);

    }


}
