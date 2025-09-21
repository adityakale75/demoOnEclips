package com.infy.springbootrestapicrudapp.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.repositary.ProductRepositary;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;


@Service
public class ProductServiceImpl implements ProductServiceI{

	@Autowired
	ProductRepositary pr;
	
	@Override
	public Product saveProduct(Product p) {
		return pr.save(p);
	}

	@Override
	public Product updateProduct(Integer productId, Product p) {
	   Optional<Product> op= pr.findById(productId);
	        if(op.isPresent()) {
	        	 Product product=op.get();
	        	if(p.getProductName()!=null) {
	        		product.setProductName(p.getProductName());
	        	}
	        	if(p.getProductprice()!=null) {
	        		product.setProductprice(p.getProductprice());
	        	}
	        	return pr.save(product);
	        }
	       else {
			;throw new ProductNotFoundException("product not found");
		}
	           
		 
	}
	@Override
	public List<Product> getProducts() {
		System.out.println("in service");
		return pr.findAll();
	}
	@Override
	public void deleteProduct(Integer productId) {
		pr.deleteById(productId);
		
	}

	/*@Override
	public Product searchproduct(String productName) {
		  Product product=pr.findByProductName(productName);
		if(product!=null) {
			return product;
		}
		else {
			throw new ProductNotFoundException("product not found");
		}
	}*/

}
