package fr.eni.sortdemo.model;

public class Sock {

	private int size;
	private int price;

	public Sock() {

	}

	public Sock(int size, int price) {
		this.size = size;
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Chaussette de taille " + size + " prix : " + price;
	}

}
