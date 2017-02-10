package tank;

public class Tank {
	private String id;
	private double capacity;
	private double filledSpace;

	public double getCapacity() {
		return capacity;
	}

	public double getFilledSpace() {
		return filledSpace;
	}

	public String getId() {
		return id;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public void setFilledSpace(double filledSpace) {
		this.filledSpace = filledSpace;
	}

	public void setId(String id) {
		this.id = id;
	}

}
