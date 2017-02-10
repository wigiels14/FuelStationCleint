package Transaction;

public class Transaction {
	private String id;
	private String employeeiD;
	private String cost;
	private String date;
	private String addedBonusPoints;
	
	public String getAddedBonusPoints() {
		return addedBonusPoints;
	}
	
	public String getCost() {
		return cost;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getEmployeeiD() {
		return employeeiD;
	}
	
	public String getId() {
		return id;
	}
	
	public void setAddedBonusPoints(String addedBonusPoints) {
		this.addedBonusPoints = addedBonusPoints;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public void setEmployeeiD(String employeeiD) {
		this.employeeiD = employeeiD;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
