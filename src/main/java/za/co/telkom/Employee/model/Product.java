package za.co.telkom.Employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	
	private String productName;
	@Column(nullable = false)
	private String quantity;
	@Column(nullable =false )
	private String price;
	@Column(nullable =false )
	private String date;
	@Column(nullable =false )
	

	   //Relationship between Product and Employee
   //Many to One Relationship
   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   //define new table for product and employee
   @JoinTable(name="Employee_Products", 
   //define the names of the columns starting with product(pid) and employee(id)
   joinColumns={
   @JoinColumn(name="pid")},inverseJoinColumns={@JoinColumn(name="id")})
   private Employee employee;
	
	public Long getId() {
		return pid;
	}
	public void setId(Long pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
