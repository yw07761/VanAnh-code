package c03.association;

public class Student {
	private String firstName;
	private String lastName;
	private Address homeAddress;
	private Address schoolAdress;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getSchoolAdress() {
		return schoolAdress;
	}
	public void setSchoolAdress(Address schoolAdress) {
		this.schoolAdress = schoolAdress;
	}
	public Student(String firtName, String lastName, Address homeAddress, Address schoolAdress ) {
		super ();
		setFirstName(firtName);
		setLastName(lastName);
		setHomeAddress(homeAddress);
		setSchoolAdress(schoolAdress);
	}
	public String toString() {
		return String.format("%s\n%s\n%s\n%s", firstName, lastName, homeAddress,schoolAdress);
	}
}
