package person;

import branch.Branch;

public class Manager {
	private String id;
	private String firstName;
	private String lastName;
	private String PESEL;
	private String idNumber;
	private String password;
	private Branch branch;

	public Branch getBranch() {
		return branch;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getPESEL() {
		return PESEL;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPESEL(String pESEL) {
		PESEL = pESEL;
	}
}
