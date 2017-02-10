package managerInterface;

import client.Client;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftManagerInterfacePane extends VBox {
	Button changePersonalDataButton, fireEmployeeButton, hireEmployeeButton;

	public LeftManagerInterfacePane() {
		setChangePersonalDataButton();
		setHireEmployeeButton();
		setFireEmployeeButton();

	}

	private void setChangePersonalDataButton() {
		changePersonalDataButton = new Button("Change personal data");
		changePersonalDataButton.setTranslateX(17);
		changePersonalDataButton.setTranslateY(170);
		changePersonalDataButton.setOnAction(e -> {
			Client.mainManagerInterfacePane.setCenterChangePersonalDatapane();
		});
		this.getChildren().add(changePersonalDataButton);
	}

	private void setHireEmployeeButton() {
		hireEmployeeButton = new Button("Hire an employee");
		hireEmployeeButton.setTranslateX(17);
		hireEmployeeButton.setTranslateY(180);
		hireEmployeeButton.setOnAction(e -> {
			Client.mainManagerInterfacePane.setCenterHireEmployeePane();
		});
		this.getChildren().add(hireEmployeeButton);
	}

	private void setFireEmployeeButton() {
		fireEmployeeButton = new Button("Fire an employee");
		fireEmployeeButton.setTranslateX(17);
		fireEmployeeButton.setTranslateY(190);
		fireEmployeeButton.setOnAction(e -> {
			String city = Client.mainManagerInterfacePane.topManagerInterfacePane.getManager().getBranch().getCity();
			Client.mainManagerInterfacePane.fireEmployeeInterfacePane.sendFetchEmployeesByBranchID(city);
		});
		this.getChildren().add(fireEmployeeButton);
	}
}
