package book;

public class Book {
	private String name;
	private Author author;
	private double price;
	private int qty;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public Author getAuthor() {
		return author;
	}
	public Book(String name, Author author, double price, int qty) {
		this.name  = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	public Book(String name, Author author, double price) {
		this(name, author, price, 0);
	}
	public String toString() {
		return String.format("Book[name = %s, %s , price = %f, qty = %d]", name, author, price, qty);
	}
}