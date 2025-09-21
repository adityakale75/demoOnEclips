package com.infy.springbootrestapicrudapp.app.servicei;



import java.util.List;

import com.infy.springbootrestapicrudapp.app.model.Product;



public interface ProductServiceI {

	public Product saveProduct(Product p);

	public Product updateProduct(Integer productId, Product p);
	public List<Product> getProducts();
	public void deleteProduct(Integer productId);

	//public Product searchproduct(String productName);

}
