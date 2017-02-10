package managerInterface.subInterfaces;

import java.io.IOException;
import java.util.ArrayList;

import client.Client;
import client.ClientMessage;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import person.Employee;

public class FireEmployeeInterfacePane extends GridPane {
	private ArrayList<Employee> employees = new ArrayList<>();
	Text selectOptionText, acceptText;
	Button acceptButton;
	ComboBox employeesComboBox;

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void initAll() {
		getChildren().clear();
		setSelectOptionText();
		setEmployeesCoboBox();
		setAcceptButton();
		setAcceptText("");
	}

	private void setSelectOptionText() {
		selectOptionText = new Text("Select employee: ");
		selectOptionText.setId("smallDataText");
		selectOptionText.setTranslateX(80);
		selectOptionText.setTranslateY(60);
		this.add(selectOptionText, 0, 0);
	}

	private void setEmployeesCoboBox() {
		employeesComboBox = new ComboBox<Employee>(FXCollections.observableList(employees));
		employeesComboBox.setTranslateX(100);
		employeesComboBox.setTranslateY(60);
		add(employeesComboBox, 1, 0);
	}

	private void setAcceptButton() {
		acceptButton = new Button("Fire");
		acceptButton.setTranslateX(120);
		acceptButton.setTranslateY(60);
		acceptButton.setOnAction(e -> {
			sendFireEmployeeByID(((Employee) employeesComboBox.getValue()).getId());
			setAcceptText("WYLALES GO");
		});
		add(acceptButton, 2, 0);
	}

	private void setAcceptText(String text) {
		if (acceptText == null) {
			acceptText = new Text(text);
			acceptText.setId("smallDataText");
			acceptText.setTranslateX(80);
			acceptText.setTranslateY(60);
			this.add(acceptText, 2, 2);
		} else {
			acceptText = new Text(text);
		}
	}

	public void sendFetchEmployeesByBranchID(String city) {
		try {
			ClientMessage clientMessage = new ClientMessage("fetchEmployees");
			clientMessage.parameters[0] = city;
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendFireEmployeeByID(String id) {
		try {
			ClientMessage clientMessage = new ClientMessage("fireEmployee");
			clientMessage.parameters[0] = id;
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
