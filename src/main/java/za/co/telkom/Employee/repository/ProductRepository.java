package za.co.telkom.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.telkom.Employee.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}