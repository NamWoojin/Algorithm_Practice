package com.ssafy;

public class TV {
	private int id;
	private String name;
	private int price;
	private int count;
	private int inch;
	private String displayType;
	
	public TV(int id,String name, int price, int count, int inch, String displayType) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.inch = inch;
		this.displayType = displayType;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}
	public int getInch() {return inch;}
	public void setInch(int inch) {this.inch = inch;}
	public String getDisplayType() {return displayType;}
	public void setDisplayType(String displayType) {this.displayType = displayType;}
	
	@Override
	public String toString() {
		String returnString = String.format("%10d |%20s |%10d원 |%10d대 |%10d인치 |%10s", id,name,price,count,inch,displayType);
		return returnString;
	}
}
