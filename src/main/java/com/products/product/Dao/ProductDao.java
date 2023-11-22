package com.products.product.Dao;

import java.io.IOException;
import java.util.List;

import com.products.product.Model.Product;

public interface ProductDao {
	List<Product> findAll() throws IOException;
	Product findById(int id);
	List<Product> save(Product product);
	List<Product> deleteById(int id);
}
