package branch;

import java.util.ArrayList;

import tank.Tank;

public class Branch {
	private String id;
	private String city;
	private ArrayList<Tank> tanks;

	public String getCity() {
		return city;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Tank> getTanks() {
		return tanks;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTanks(ArrayList<Tank> tanks) {
		this.tanks = tanks;
	}

}
