package employeeInterface;

import java.io.IOException;

import client.Client;
import client.ClientMessage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import person.Employee;
import person.Manager;

public class TopEmployeeInterfacePane extends HBox {
	private Employee employee;
	Text idText, firstNameText, lastNameText, branchCityText, positionText;
	Button endAppButton;

	public TopEmployeeInterfacePane() {
		setEndAppButton();
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	
	public void initAll() {
		getChildren().clear();
		
		setEndAppButton();
		setIDText();
		setFirstNameText();
		setLastNameText();
		setBranchCityText();
		setPosition();
	}

	public void setIDText() {
		idText = new Text("ID Number: " + employee.getIdNumber());
		idText.setId("smallDataText");
		idText.setTranslateX(110);
		idText.setTranslateY(30);
		this.getChildren().add(idText);
	}

	public void setFirstNameText() {
		if (firstNameText == null) {
			firstNameText = new Text("First name: " + employee.getFirstName());
			firstNameText.setId("smallDataText");
			firstNameText.setTranslateX(130);
			firstNameText.setTranslateY(30);
			this.getChildren().add(firstNameText);
		} else {
			firstNameText.setText("First name: " + employee.getFirstName());
		}
	}

	public void setLastNameText() {
		if (lastNameText == null) {
			lastNameText = new Text("Last name: " + employee.getLastName());
			lastNameText.setId("smallDataText");
			lastNameText.setTranslateX(160);
			lastNameText.setTranslateY(30);
			this.getChildren().add(lastNameText);
		}
		lastNameText.setText("Last name: " + employee.getLastName());
	}

	public void setBranchCityText() {
		if (branchCityText == null) {
			branchCityText = new Text("Type: " + employee.getBranch().getCity());
			branchCityText.setId("smallDataText");
			branchCityText.setTranslateX(190);
			branchCityText.setTranslateY(30);
			this.getChildren().add(branchCityText);
		}
		lastNameText.setText("Last name: " + employee.getLastName());
	}
	
	public void setPosition() {
		if (positionText == null) {
			positionText = new Text("Position: employee");
			positionText.setId("smallDataText");
			positionText.setTranslateX(220);
			positionText.setTranslateY(30);
			this.getChildren().add(positionText);
		}
		lastNameText.setText("Last name: " + employee.getLastName());
	}


	public void setEndAppButton() {
		endAppButton = new Button("Log out");
		endAppButton.setTranslateX(100);
		endAppButton.setTranslateY(30);
		endAppButton.setOnAction(e -> {
			sendQuitApp();
			Client.primaryStage.close();
			System.exit(0);
		});
		this.getChildren().add(endAppButton);
	}

	public void sendQuitApp() {
		try {

			ClientMessage clientQuery = new ClientMessage("sendQuitApp");
			Client.out.writeObject(clientQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}