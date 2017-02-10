package person.customer;

public class CustomerAccount {
	private String id;
	private Customer customer;
	private String bonusPoints;
	
	public String getBonusPoints() {
		return bonusPoints;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public String getId() {
		return id;
	}
	
	public void setBonusPoints(String bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
