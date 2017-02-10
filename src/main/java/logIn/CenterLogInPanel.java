package logIn;

import java.io.IOException;

import client.Client;
import client.ClientMessage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CenterLogInPanel extends VBox {
	GridPane customerPanel = new GridPane();
	Text logoText, idNumberText, passwordText, wrongDataField;
	TextField passwordField, idNumberField;
	Button myLogInButton;
	public boolean isUserAvail, isUserLoggedIn;

	public CenterLogInPanel() {
		idNumberText = new Text("ID Number");
		idNumberText.setId("loginText");
		idNumberText.setTranslateX(375);
		idNumberText.setTranslateY(205);
		customerPanel.add(idNumberText, 0, 0);

		passwordText = new Text("Password");
		passwordText.setId("loginText");
		passwordText.setTranslateX(375);
		passwordText.setTranslateY(210);
		customerPanel.add(passwordText, 0, 1);

		idNumberField = new TextField();
		idNumberField.setTranslateX(490);
		idNumberField.setTranslateY(160);
		customerPanel.add(idNumberField, 0, 2);

		passwordField = new TextField();
		passwordField.setTranslateX(490);
		passwordField.setTranslateY(165);
		customerPanel.add(passwordField, 0, 3);

		myLogInButton = new Button("Log in");
		myLogInButton.setTranslateX(600);
		myLogInButton.setTranslateY(300);
		myLogInButton.setOnAction(e -> {
			isUserInSystemDatabase();
		});
		customerPanel.add(myLogInButton, 0, 4);

		wrongDataField = new Text("");
		wrongDataField.setTranslateX(270);
		wrongDataField.setTranslateY(400);
		wrongDataField.setId("smallDataText");
		customerPanel.add(wrongDataField, 1, 0);

		getChildren().add(customerPanel);
	}

	boolean isUserInSystemDatabase() {
		String idNumber = this.idNumberField.getText();
		String password = this.passwordField.getText();
		if (isLogInPanelProperlyFilled()) {
			sendQueryIsUserInSystemDatabase(idNumber, password);
		} else {
			setWrongDataField("Incorrect data");
		}
		return false;
	}

	private boolean isIDNumberFieldFilled() {
		return (idNumberField.getText().length() > 0 && idNumberField.getText().length() < 10);
	}

	private boolean isPasswordFieldFilled() {
		return (passwordField.getText().length() > 0 && passwordField.getText().length() < 31);
	}

	boolean isLogInPanelProperlyFilled() {
		return isIDNumberFieldFilled() && isPasswordFieldFilled();
	}

	public void setWrongDataField(String content) {
		wrongDataField.setText(content);
	}

	private void sendQueryIsUserInSystemDatabase(String idNumber, String password) {
		try {
			ClientMessage clientMessage = new ClientMessage("isUserInSystemDatabase");
			clientMessage.parameters[0] = idNumber;
			clientMessage.parameters[1] = password;
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void sendFetchManager(String idNumber) {
		try {
			ClientMessage clientMessage = new ClientMessage("sendFetchManager");
			clientMessage.parameters[0] = idNumber;
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void sendFetchEmployee(String idNumber) {
		try {
			ClientMessage clientMessage = new ClientMessage("sendFetchEmployee");
			clientMessage.parameters[0] = idNumber;
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void clearFields() {
		idNumberField.clear();
		passwordField.clear();
	}

	public void clearTexts() {
		wrongDataField.setText("");
	}
}