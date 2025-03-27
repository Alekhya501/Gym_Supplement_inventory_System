package com.alekhya.dtoclasses;

import java.sql.Timestamp;

public class ProductDto {
	private int id;
    private String category;
    private String name;
    private double purchasePrice;
    private double sellingPrice;
    private int stockQuantity;
    private Timestamp addedDate;
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(int id, String category, String name, double purchasePrice, double sellingPrice,
			int stockQuantity, Timestamp addedDate) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.stockQuantity = stockQuantity;
		this.addedDate = addedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Timestamp getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Timestamp addedDate) {
		this.addedDate = addedDate;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", category=" + category + ", name=" + name + ", purchasePrice=" + purchasePrice
				+ ", sellingPrice=" + sellingPrice + ", stockQuantity=" + stockQuantity + ", addedDate=" + addedDate
				+ "]";
	}
	
    


}
