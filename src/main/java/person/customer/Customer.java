package person.customer;

public class Customer {
	private String id;
	private String firstName;
	private String lastName;
	private String pesel;
	private String idNumber;
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getId() {
		return id;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPesel() {
		return pesel;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	@Override
	public String toString() {
		return "First name: " + firstName + ", last name: " + lastName + ", pesel: " + pesel + ", id number:" + idNumber;
	}

}
