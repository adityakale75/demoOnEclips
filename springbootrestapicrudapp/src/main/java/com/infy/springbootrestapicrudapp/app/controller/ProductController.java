package com.infy.springbootrestapicrudapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
	@Autowired
	ProductServiceI psi;
	
	// post api
	@PostMapping(value = "/product")
	public ResponseEntity<Product>   saveProduct(@RequestBody Product p)
	{
	               
		Product product=psi.saveProduct(p);
		
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	//put api
	@PutMapping(value = "/product/{productId}")
	public  ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody Product p) {
		Product product=psi.updateProduct(productId,p);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	//GetAPI
	
		@GetMapping(value = "/products")
		public  ResponseEntity<List<Product>> getProducts(){
		System.out.println("in controller");
			List list=psi.getProducts();
			return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
		
		//Delete API
		@DeleteMapping(value = "/product/{productId}")
		public ResponseEntity deleteProduct(@PathVariable Integer productId){
			 psi.deleteProduct(productId);
			 return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		// searchproduct API
		
	/*	@GetMapping(value = "/product/{productName}")
		public ResponseEntity<Product> searchproduct(@PathVariable String productName)
		{
			Product p=psi.searchproduct(productName);
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		}*/
		
	
	
}
