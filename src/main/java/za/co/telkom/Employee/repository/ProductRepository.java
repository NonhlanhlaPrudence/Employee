package za.co.telkom.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.telkom.Employee.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

// Query to get all products belonging to a customer
  //  SELECT  * FROM PRODUCT INNER JOIN EMPLOYEE_PRODUCTS ON EMPLOYEE_PRODUCTS.PRODUCT_ID = PRODUCT.ID WHERE EMPLOYEE_ID = 2
}