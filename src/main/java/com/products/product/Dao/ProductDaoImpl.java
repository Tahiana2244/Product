package com.products.product.Dao;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.products.product.Model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	private List<Product> products = new ArrayList<>();		
	
	@Override
	public List<Product> findAll() throws IOException {
		return getAllProducts();
	}

	@Override
	public Product findById(int id) {
		for (Product product : products){
			if (product.getId() == id){
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> save(Product product) {
		products.add(product);
		writeJsonFile(products);
		return products;
	}

	@Override
	public List<Product> deleteById(int id) {		 
		 products.remove(products.indexOf(findById(id)));	
		 writeJsonFile(products);
		 return products;
	}	
	
	//Methods	
	public List<Product> getAllProducts() throws IOException {		
		String text = new String(Files.readAllBytes(Paths.get(getPathJsonFile())), StandardCharsets.UTF_8);

		JSONObject jsonObj = new JSONObject(text);
		JSONArray  jsonArray= jsonObj.getJSONArray("data");
		
		for(int i = 0 ; i < jsonArray.length();i++) {
			JSONObject element = jsonArray.getJSONObject(i);
			Product prod= new Product();
			prod.setId((int) element.get("id"));
			prod.setCode((String) element.get("code"));
			prod.setName((String) element.get("name"));
			prod.setDescription((String) element.get("description"));
			prod.setImage((String) element.get("image"));
			prod.setPrice((int) element.get("price"));
			prod.setCategory((String) element.get("category"));
			prod.setQuantity((int) element.get("quantity"));
			prod.setInventoryStatus((String) element.get("inventoryStatus"));
			prod.setRating((int) element.get("rating"));
			products.add(prod);
		}
		return products;
	}
	
	public void writeJsonFile(List<Product> products) {		
		try {
	         FileWriter file = new FileWriter(getPathJsonFile());
	         file.write(ProductsToJson(products).toString());
	         file.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	
	public JSONObject ProductsToJson(List<Product> products) {
		JSONObject jsonObj = new JSONObject();
		return jsonObj.put("data", products);		
	}	
	
	public String getPathJsonFile() {
	    return System.getProperty("user.dir") + "\\src\\main\\resources\\products.json";		
	}
}
