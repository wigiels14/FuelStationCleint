package managerInterface.subInterfaces;

import java.io.IOException;

import client.Client;
import client.ClientMessage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class HireEmployeeInterfacePane extends GridPane {
	private Text firstNameText, lastNameText, PESELText, idNumberText, passwordText, branchText, messageText;
	private TextField firstNameTextField, lastNameTextField, PESELTextField, idNumberTextField, passwordTextField,
			branchTextField;
	private Button acceptDataButton;
	
	private void clearTextFields() {
		firstNameTextField.clear();
		lastNameTextField.clear();
		PESELTextField.clear();
		idNumberTextField.clear();
		passwordTextField.clear();
		branchTextField.clear();
	}

	public void initAll() {

		setFirstNameText();
		setFirstNameTextField();

		setLastNameText();
		setLastNameTextField();

		setPESELText();
		setPESELTextField();
		
		setIDNumberText();
		setIDNumberTextField();
		
		setPasswordText();
		setPasswordTextField();
		
		setBranchText();
		setBranchTextField();
		
		setAcceptButton();
		
		setMessageText("");

	}

	private void setFirstNameText() {
		if (firstNameText == null) {
			firstNameText = new Text("First name: ");
			firstNameText.setId("smallDataText");
			firstNameText.setTranslateX(80);
			firstNameText.setTranslateY(60);
			this.add(firstNameText, 0, 0);
		} else {
			firstNameText = new Text("First name: ");
		}
	}

	private void setFirstNameTextField() {
		firstNameTextField = new TextField();
		firstNameTextField.setTranslateX(90);
		firstNameTextField.setTranslateY(60);
		this.add(firstNameTextField, 1, 0);
	}

	private void setLastNameText() {
		if (lastNameText == null) {
			lastNameText = new Text("Last name: ");
			lastNameText.setId("smallDataText");
			lastNameText.setTranslateX(80);
			lastNameText.setTranslateY(60);
			this.add(lastNameText, 0, 1);
		} else {
			lastNameText = new Text("Mark: ");
		}
	}

	private void setLastNameTextField() {
		lastNameTextField = new TextField();
		lastNameTextField.setTranslateX(90);
		lastNameTextField.setTranslateY(60);
		this.add(lastNameTextField, 1, 1);
	}

	private void setPESELText() {
		if (PESELText == null) {
			PESELText = new Text("PESEL: ");
			PESELText.setId("smallDataText");
			PESELText.setTranslateX(80);
			PESELText.setTranslateY(60);
			this.add(PESELText, 0, 2);
		} else {
			PESELText = new Text("PESEL: ");
		}
	}

	private void setPESELTextField() {
		PESELTextField = new TextField();
		PESELTextField.setTranslateX(90);
		PESELTextField.setTranslateY(60);
		this.add(PESELTextField, 1, 2);
	}

	private void setIDNumberText() {
		if (idNumberText == null) {
			idNumberText = new Text("ID number: ");
			idNumberText.setId("smallDataText");
			idNumberText.setTranslateX(80);
			idNumberText.setTranslateY(60);
			this.add(idNumberText, 0, 3);
		} else {
			idNumberText = new Text("ID number: ");
		}
	}

	private void setIDNumberTextField() {
		idNumberTextField = new TextField();
		idNumberTextField.setTranslateX(90);
		idNumberTextField.setTranslateY(60);
		this.add(idNumberTextField, 1, 3);
	}

	private void setPasswordText() {
		if (passwordText == null) {
			passwordText = new Text("Password: ");
			passwordText.setId("smallDataText");
			passwordText.setTranslateX(80);
			passwordText.setTranslateY(60);
			this.add(passwordText, 0, 4);
		} else {
			idNumberText = new Text("Password: ");
		}
	}

	private void setPasswordTextField() {
		passwordTextField = new TextField();
		passwordTextField.setTranslateX(90);
		passwordTextField.setTranslateY(60);
		this.add(passwordTextField, 1, 4);
	}

	private void setBranchText() {
		if (branchText == null) {
			branchText = new Text("Branch: ");
			branchText.setId("smallDataText");
			branchText.setTranslateX(80);
			branchText.setTranslateY(60);
			this.add(branchText, 0, 5);
		} else {
			branchText = new Text("Branch: ");
		}
	}

	private void setBranchTextField() {
		branchTextField = new TextField();
		branchTextField.setTranslateX(90);
		branchTextField.setTranslateY(60);
		this.add(branchTextField, 1, 5);
	}
	
	private String[] constructSendingData() {
		String[] employee = new String[6];
		employee[0] = firstNameTextField.getText();
		employee[1] = lastNameTextField.getText();
		employee[2] = PESELTextField.getText();
		employee[3] = idNumberTextField.getText();
		employee[4] = passwordTextField.getText();
		employee[5] = branchTextField.getText();
		
		return employee;
	}

	private void setAcceptButton() {
		acceptDataButton = new Button("Accept data");
		acceptDataButton.setId("leftPanelButton");
		acceptDataButton.setTranslateX(160);
		acceptDataButton.setTranslateY(100);
		acceptDataButton.setOnAction(e -> {
			if (isPanelProperlyFilled()) {
				String[] employee = new String[6];
				employee = constructSendingData();
				
				sendCreateEmployee(employee);
				clearTextFields();
				setMessageText("Employee has been hired");
			} else {
				setMessageText("Incorrect data");
			}
		});
		this.add(acceptDataButton, 2, 6);
	}

	private boolean isPanelProperlyFilled() {
		if (firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")
				|| PESELTextField.getText().equals("") || idNumberTextField.getText().equals("")
				|| passwordTextField.getText().equals("") || branchTextField.getText().equals("")) {
			return false;
		}
		return true;
	}

	private void setMessageText(String message) {
		if (messageText == null) {
			messageText = new Text(message);
			messageText.setId("smallDataText");
			messageText.setTranslateX(80);
			messageText.setTranslateY(100);
			this.add(messageText, 1, 6);
		} else {
			messageText.setText(message);
		}
	}
	
	public void sendCreateEmployee(String[] employee) {
		try {

			ClientMessage clientMessage = new ClientMessage("createEmployee");
			clientMessage.parameters[0] = employee[0];
			clientMessage.parameters[1] = employee[1];
			clientMessage.parameters[2] = employee[2];
			clientMessage.parameters[3] = employee[3];
			clientMessage.parameters[4] = employee[4];
			clientMessage.parameters[5] = employee[5];
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
