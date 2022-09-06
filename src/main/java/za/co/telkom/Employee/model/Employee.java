package za.co.telkom.Employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable =false , name = "Employee Name")
    private String name;
    @Column(nullable =false )
    private String surname;
    @Column(nullable =false )
    private String salaryRef;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSalaryRef() {
        return salaryRef;
    }
    public void setSalaryRef(String salaryRef) {
        this.salaryRef = salaryRef;
    }


 
}
