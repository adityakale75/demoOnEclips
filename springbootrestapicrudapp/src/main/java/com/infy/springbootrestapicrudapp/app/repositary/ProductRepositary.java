package com.infy.springbootrestapicrudapp.app.repositary;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.springbootrestapicrudapp.app.model.Product;

@Repository
public interface ProductRepositary extends JpaRepository<com.infy.springbootrestapicrudapp.app.model.Product,Integer>{
	//public Product findByProductName(String productName);

}
