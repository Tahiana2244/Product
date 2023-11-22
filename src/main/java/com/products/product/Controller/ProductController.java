package com.products.product.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.products.product.Dao.ProductDao;
import com.products.product.Model.Product;


@RestController
public class ProductController {

	private final ProductDao productDao;

	public ProductController(ProductDao productDao){
		this.productDao = productDao;
	}

	@GetMapping("/Products")
	public List<Product> allProducts() throws IOException {
		return productDao.findAll();
	}

	@GetMapping(value = "/Products/{id}")
	public Product displayProduct(@PathVariable int id) {
		return productDao.findById(id);
	}
	
	@PostMapping("/Products")
	public List<Product> addProduct(@RequestBody Product product) {
		return  productDao.save(product);			
	}
	
	@DeleteMapping("/Products/{id}")
	public List<Product> supprimerUnProduit(@PathVariable int id) {
		return productDao.deleteById(id);
	}
}
