package managerInterface.subInterfaces;

import java.io.IOException;

import client.Client;
import client.ClientMessage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import person.Employee;
import person.Manager;

public class ChangePersonalDataInterfacePane extends GridPane {
	private Manager manager;
	private Button changeFirstNameButton, changePassword, changeLastNameButton;
	private Text managerPasswordText, firstNameText, lastNameText, messageText;
	public TextField changeFirstNameTextField, changePasswordTextField, changeLastNameTextField;

	public void initAll() {
		setMessageText("");
		manager = Client.mainManagerInterfacePane.topManagerInterfacePane.getManager();
		setCustomerFirstNameText();
		createChangeFirstNameField();
		setChangeFirstNameButton();
		setCustomerLastNameText();
		createChangeLastNameField();
		setChangeLastNameButton();
		setManagerPasswordText();
		createChangePasswordField();
		setChangePasswordButton();
	}

	private boolean isFieldProperlyFilled(TextField field) {
		if (field.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	private void setCustomerFirstNameText() {
		if (firstNameText == null) {
			if (manager.getFirstName() == null) {
				firstNameText = new Text("First Name: <empty>");
			} else {
				firstNameText = new Text("First name: " + manager.getFirstName());
			}
			firstNameText.setId("smallDataText");
			firstNameText.setTranslateX(100);
			firstNameText.setTranslateY(40);
			this.add(firstNameText, 0, 0);
		} else {
			if (manager.getFirstName() == null) {
				firstNameText.setText("First Name: <empty>");
			} else {
				firstNameText.setText("First name: " + manager.getFirstName());
			}
		}
	}

	private void refreshTopCustomerInterfaceData() {
		Client.mainManagerInterfacePane.topManagerInterfacePane.setFirstNameText();
		Client.mainManagerInterfacePane.topManagerInterfacePane.setLastNameText();
	}

	private void setCustomerLastNameText() {
		if (lastNameText == null) {
			if (manager.getLastName() == null) {
				lastNameText = new Text("Last name: <empty>");
			} else {
				lastNameText = new Text("Last name: " + manager.getLastName());
			}
			lastNameText.setId("smallDataText");
			lastNameText.setTranslateX(100);
			lastNameText.setTranslateY(40);
			this.add(lastNameText, 0, 1);
		} else {
			if (manager.getLastName() == null) {
				lastNameText.setText("Last Name: <empty>");
			} else {
				lastNameText.setText("Last name: " + manager.getLastName());
			}
		}
	}

	private void setManagerPasswordText() {
		if (managerPasswordText == null) {
			managerPasswordText = new Text("Your Password: " + manager.getPassword());
			managerPasswordText.setId("smallDataText");
			managerPasswordText.setTranslateX(100);
			managerPasswordText.setTranslateY(40);
			this.add(managerPasswordText, 0, 4);
		} else {
			managerPasswordText.setText("Customer Password: " + manager.getPassword());
		}
	}

	private void setMessageText(String message) {
		if (messageText == null) {
			messageText = new Text(message);
			messageText.setId("smallDataText");
			messageText.setTranslateX(100);
			messageText.setTranslateY(120);
			this.add(messageText, 0, 6);
		} else {
			messageText.setText(message);
		}
	}

	private void setChangeFirstNameButton() {
		changeFirstNameButton = new Button("Change first name");
		changeFirstNameButton.setId("leftPanelButton");
		changeFirstNameButton.setTranslateX(140);
		changeFirstNameButton.setTranslateY(40);
		changeFirstNameButton.setOnAction(e -> {
			if (isFieldProperlyFilled(this.changeFirstNameTextField)) {
				Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.setFirstName(changeFirstNameTextField.getText());
				setCustomerFirstNameText();
				String firstName = Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.getFirstName();
				sendChangeManagerFirstName(manager.getIdNumber(), firstName);
				refreshTopCustomerInterfaceData();
				setMessageText("Data changed");
			} else {
				setMessageText("Incorrect data");
			}
		});
		this.add(changeFirstNameButton, 2, 0);
	}

	private void createChangeFirstNameField() {
		changeFirstNameTextField = new TextField();
		changeFirstNameTextField.setTranslateX(130);
		changeFirstNameTextField.setTranslateY(40);
		this.add(changeFirstNameTextField, 1, 0);
	}

	private void createChangeLastNameField() {
		changeLastNameTextField = new TextField();
		changeLastNameTextField.setTranslateX(130);
		changeLastNameTextField.setTranslateY(40);
		this.add(changeLastNameTextField, 1, 1);
	}

	private void createChangePasswordField() {
		changePasswordTextField = new TextField();
		changePasswordTextField.setTranslateX(130);
		changePasswordTextField.setTranslateY(40);
		this.add(changePasswordTextField, 1, 4);
	}

	private void setChangeLastNameButton() {
		changeLastNameButton = new Button("Change last name");
		changeLastNameButton.setId("leftPanelButton");
		changeLastNameButton.setTranslateX(140);
		changeLastNameButton.setTranslateY(40);
		changeLastNameButton.setOnAction(e -> {
			if (isFieldProperlyFilled(this.changeLastNameTextField)) {
				Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.setLastName(changeLastNameTextField.getText());
				String idNumber = Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.getIdNumber();
				String lastName = Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.getLastName();
				sendChangeManagerLastName(idNumber, lastName);
				setCustomerLastNameText();
				refreshTopCustomerInterfaceData();
				setMessageText("Data changed");
			} else {
				setMessageText("Incorrect data");
			}
		});
		this.add(changeLastNameButton, 2, 1);
	}

	private void setChangePasswordButton() {
		changePassword = new Button("Change password");
		changePassword.setId("leftPanelButton");
		changePassword.setTranslateX(140);
		changePassword.setTranslateY(40);
		changePassword.setOnAction(e -> {
			if (isFieldProperlyFilled(this.changePasswordTextField)) {
				Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.setPassword(changePasswordTextField.getText());
				setManagerPasswordText();
				String idNumber = Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.getIdNumber();
				String password =Client.mainManagerInterfacePane.topManagerInterfacePane.getManager()
						.getPassword();
				sendChangeManagerPassword(idNumber, password);
				setMessageText("Data changed");
			} else {
				setMessageText("Incorrect data");
			}
		});
		this.add(changePassword, 2, 4);
	}

	public Text getCustomerPasswordText() {
		return managerPasswordText;
	}


	public void sendChangeManagerFirstName(String idNumber, String firstName) {
		try {

			ClientMessage clientQuery = new ClientMessage("changeManagerFirstName");
			clientQuery.parameters[0] = idNumber;
			clientQuery.parameters[1] = firstName;
			Client.out.writeObject(clientQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendChangeManagerLastName(String idNumber, String lastName) {
		try {

			ClientMessage clientQuery = new ClientMessage("changeManagerLastName");
			clientQuery.parameters[0] = idNumber;
			clientQuery.parameters[1] = lastName;
			Client.out.writeObject(clientQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendChangeManagerPassword(String idNumber, String password) {
		try {

			ClientMessage clientQuery = new ClientMessage("changeManagerPassword");
			clientQuery.parameters[0] = idNumber;
			clientQuery.parameters[1] = password;
			Client.out.writeObject(clientQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
