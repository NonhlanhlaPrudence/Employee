package za.co.telkom.Employee.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.telkom.Employee.model.Product;
import za.co.telkom.Employee.repository.ProductRepository;

@Service
	public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	//------------------------------To save details on the database---------------------
	public Product createStock (Product product) {
			return productRepository.save(product);
		}
	
//----------------------------To get all products from products------------------------- 
	  public List<Product> getStock(){
  	  List<Product> product = productRepository.findAll();
	  return product;
	  }
	 
	
//------------------------To find product by ID---------------------------------
	public Product getStockById (Long pid) {
		Product product = productRepository.findById(pid).get();
		return product;
	}
	
// -----------------------------------DELETE - delete employee------------------------------- 
		public void deleteStock(Long pid){
			productRepository.deleteById(pid); 
		   }

 // ---------------------PUT - update employee information-----------------------------------
 public Product stockUpdate(Long pid, Product products)
 {
	return productRepository.save(products);

 }
 
	
}
