package c03.Book;

public class Author {
	private String name;
	private String email;
	private char gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Author(String name, String email, char gender) {
		setName(name);
		setEmail(email);
		setGender(gender);
	}
	public String toString() {
		return String.format("[name = %s, email = %s, gender = %c]" , name, email, gender);
	}
}
