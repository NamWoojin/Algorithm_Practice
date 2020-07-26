package com.ssafy;

public class Refrigerator {
	private int id;
	private String name;
	private int price;
	private int count;
	private int volume;
	
	public Refrigerator(int id,String name, int price, int count, int volume) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.volume = volume;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}
	public int getVolume() {return volume;}
	public void setVolume(int volume) {this.volume = volume;}
	
	@Override
	public String toString() {
		String returnString = String.format("%10d |%20s |%10d¿ø |%10d´ë |%10dL", id,name,price,count,volume);
		return returnString;
	}
}
