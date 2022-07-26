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

import za.co.telkom.Employee.model.Product;
import za.co.telkom.Employee.service.ProductService;

@RestController
public class ProductController {
	@Autowired

	private ProductService productService;
	//-----------------------------Creating stock-------------------------------------------
	@PostMapping(value = "/employee/createStock/",produces = MediaType.APPLICATION_JSON_VALUE)
	public Product createStock(@RequestBody Product product) {
		return productService.createStock(product);
	}

	//-------------------------------Getting stock---------------------------------------  
 	@GetMapping(value ="/employee/getStock/",produces = MediaType.APPLICATION_JSON_VALUE)
 	public List<Product> getStock(){
 		return productService.getStock();	
   }

    //-----------------------------Get by Id-----------------------------------------
    @RequestMapping(value = "/employee/getStockById/{pid}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Product getStockById(@PathVariable(name = "pid", required = true) Long pid){
    return productService.getStockById(pid);   
    }

	 //-------------------------------Deleting by ID-----------------------------------------
	 @RequestMapping(value = "/employee/deleteStock/{pid}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	 public void deleteStock(@PathVariable(name = "pid", required = true) Long pid){
		 productService.deleteStock(pid);
	 }

	 //-----------------------------------------------Updating------------------------------------------------------------ 
	 @RequestMapping(value = "/employee/stockUpdate/{pid}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	 public Product stockUpdate(@PathVariable(name = "pid", required = true) Long pid, @RequestBody Product stockUpdate){
		 return productService.stockUpdate(pid, stockUpdate);
 
	 }
 

}
