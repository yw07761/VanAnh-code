package hoHoangVanAnh.bai07;

public abstract class Employee {
	private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setSocialSecurityNumber(socialSecurityNumber);
	}

	public Employee() {
		this("un-known", "un-known", "un-known");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(!firstName.equals(""))
			this.firstName = firstName;
		else
			this.firstName = "un-known";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(!lastName.equals(""))
			this.lastName = lastName;
		else
			this.lastName = "un- knowm";
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		if(!socialSecurityNumber.equals(""))
			this.socialSecurityNumber = socialSecurityNumber;
		else
			this.socialSecurityNumber = "un-known";
	}

	@Override
	public String toString() {
		return String.format("%s %s\nsocial security number: %s", 
				firstName,lastName,socialSecurityNumber);
	}
	
	public abstract double earnings();
	
    
	
    
}

