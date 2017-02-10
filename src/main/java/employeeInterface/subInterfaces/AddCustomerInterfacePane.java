package employeeInterface.subInterfaces;

import java.io.IOException;

import client.Client;
import client.ClientMessage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddCustomerInterfacePane extends GridPane {
	private Text firstNameText, lastNameText, PESELText, idNumberText, messageText;
	private TextField firstNameTextField, lastNameTextField, PESELTextField, idNumberTextField;
	private Button acceptDataButton;
	
	private void clearTextFields() {
		firstNameTextField.clear();
		lastNameTextField.clear();
		PESELTextField.clear();
		idNumberTextField.clear();
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
			lastNameText = new Text("Last name: ");
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


	private String[] constructSendingData() {
		String[] customer = new String[6];
		customer[0] = firstNameTextField.getText();
		customer[1] = lastNameTextField.getText();
		customer[2] = PESELTextField.getText();
		customer[3] = idNumberTextField.getText();
		
		return customer;
	}

	private void setAcceptButton() {
		acceptDataButton = new Button("Accept data");
		acceptDataButton.setId("leftPanelButton");
		acceptDataButton.setTranslateX(160);
		acceptDataButton.setTranslateY(100);
		acceptDataButton.setOnAction(e -> {
			if (isPanelProperlyFilled()) {
				String[] customer = new String[4];
				customer = constructSendingData();
				sendAddCustomer(customer);
				clearTextFields();
				setMessageText("Customer has been added");
			} else {
				setMessageText("Incorrect data");
			}
		});
		this.add(acceptDataButton, 2, 6);
	}

	private boolean isPanelProperlyFilled() {
		if (firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")
				|| PESELTextField.getText().equals("") || idNumberTextField.getText().equals("")) {
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
	
	public void sendAddCustomer(String[] customer) {
		try {
			ClientMessage clientMessage = new ClientMessage("addCustomer");
			clientMessage.parameters[0] = customer[0];
			clientMessage.parameters[1] = customer[1];
			clientMessage.parameters[2] = customer[2];
			clientMessage.parameters[3] = customer[3];
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
