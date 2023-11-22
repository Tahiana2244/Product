package com.products.product.Model;

public class Product {

	public Product() {
	}
	
	
	public Product(int id, String code, String name, String description, String image, 
			int price, String category, int quantity, String inventoryStatus, int rating) {
		this.id=id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.image= image;
		this.price = price;
		this.category=category;
		this.quantity=quantity;
		this.inventoryStatus=inventoryStatus;
		this.rating= rating;
		
	}
	
	private int id;
	private String code;
	private String name;
	private String description;
	private String image;
	private int price;
	private String category;
	private int quantity;
	private String inventoryStatus;
	private int rating;
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getInventoryStatus() {
		return inventoryStatus;
	}
	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}


	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", image='" + image + '\'' +
				", price=" + price + '\'' +
				", category='" + category + '\'' +
				", quantity=" + quantity + '\'' +
				", inventoryStatus='" + inventoryStatus + '\'' +
				", rating=" + rating +				
				'}';
	}
}
