package za.co.telkom.Employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.telkom.Employee.model.Employee;
import za.co.telkom.Employee.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // -----------------------------create
    // employee------------------------------------
    @PostMapping(value = "/employee/createEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.OK);
    }

    // ----------------------------Get all
    // employees---------------------------------
    @GetMapping(value = "/employee/getEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  getEmployees() {

        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);

    }

    // -----------------------------Get by
    // Id-----------------------------------------
    @RequestMapping(value = "/employee/getEmployeeId/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeId(@PathVariable(name = "id", required = true) Long id) {

        return new ResponseEntity<>(employeeService.getEmployeeId(id), HttpStatus.OK);
    }

    // -------------------------------Deleting by
    // ID-----------------------------------------
    @RequestMapping(value = "/employee/deleteEmployee/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable(name = "id", required = true) Long id) {
       
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);

    }

    // -------------------------------Updating--------------------------------------
    @RequestMapping(value = "/employee/employeeUpdate/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Object> employeeUpdate(@PathVariable(name = "id", required = true) Long id,@RequestBody Employee employeeUpdate) {
        
        return new ResponseEntity<>(employeeService.employeeUpdate(id, employeeUpdate), HttpStatus.OK);

    }

}
