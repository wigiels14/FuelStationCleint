package employeeInterface.subInterfaces;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import client.Client;
import client.ClientMessage;

public class RealizeTransactionInterfacePane extends GridPane {
	private Text costText, idNumberText, dateText, messageText;
	private TextField costTextField, idNumberTextField;
	private DatePicker datePicker;
	private Button acceptDataButton;

	public void initAll() {

		setCostText();
		setCostTextField();
		
		setDateText();
		setDatePicker();
		
		setIDNumberText();
		setIDNumberTextField();
		
		setAcceptButton();

		
		setMessageText("");

	}

	private void setCostText() {
		if (costText == null) {
			costText = new Text("Cost: ");
			costText.setId("smallDataText");
			costText.setTranslateX(80);
			costText.setTranslateY(60);
			this.add(costText, 0, 0);
		} else {
			costText = new Text("Cost: ");
		}
	}

	private void setCostTextField() {
		costTextField = new TextField();
		costTextField.setTranslateX(90);
		costTextField.setTranslateY(60);
		this.add(costTextField, 1, 0);
	}
	
	private void setDateText() {
		if (dateText == null) {
			dateText = new Text("Date: ");
			dateText.setId("smallDataText");
			dateText.setTranslateX(80);
			dateText.setTranslateY(70);
			this.add(dateText, 0, 1);
		} else {
			dateText = new Text("Date: ");
		}
	}


	private void setDatePicker() {
		if (datePicker == null) {
			datePicker = new DatePicker();
			datePicker.setValue(LocalDate.now());
			datePicker.setTranslateX(90);
			datePicker.setTranslateY(70);
			this.add(datePicker, 1, 1);
		} else {
			datePicker.setValue(LocalDate.now());
		}
	}

	private void setIDNumberText() {
		if (idNumberText == null) {
			idNumberText = new Text("ID number: ");
			idNumberText.setId("smallDataText");
			idNumberText.setTranslateX(80);
			idNumberText.setTranslateY(80);
			this.add(idNumberText, 0, 2);
		} else {
			idNumberText = new Text("ID number: ");
		}
	}

	private void setIDNumberTextField() {
		idNumberTextField = new TextField();
		idNumberTextField.setTranslateX(90);
		idNumberTextField.setTranslateY(80);
		this.add(idNumberTextField, 1, 2);
	}

	private void setAcceptButton() {
		acceptDataButton = new Button("Realize transaction");
		acceptDataButton.setId("leftPanelButton");
		acceptDataButton.setTranslateX(160);
		acceptDataButton.setTranslateY(100);
		acceptDataButton.setOnAction(e -> {
			if (isPanelProperlyFilled()) {
				String[] data = new String[3];
				
				data[0] = idNumberTextField.getText();
				data[1] = costTextField.getText();
				data[2] = Client.mainEmployeeInterfacePane.topEmployeeInterfacePane.getEmployee().getId();
				Date date = Date.valueOf(datePicker.getValue());
				
				sendRealizeTransaction(data, date);
				setMessageText("Transaction has been added");
			} else {
				setMessageText("Incorrect data");
			}
		});
		this.add(acceptDataButton, 1, 3);
	}
	
	private void setMessageText(String message) {
		if (messageText == null) {
			messageText = new Text(message);
			messageText.setId("smallDataText");
			messageText.setTranslateX(80);
			messageText.setTranslateY(100);
			this.add(messageText, 0, 3);
		} else {
			messageText.setText(message);
		}
	}
	
	private boolean isPanelProperlyFilled() {
		if(costTextField.getText().equals("") || idNumberTextField.getText().equals(""))
			return false;
		return true;
	}
	
	public void sendRealizeTransaction(String[] data, Date date) {
		try {
			ClientMessage clientMessage = new ClientMessage("realizeTransaction");
			clientMessage.parameters[0] = data[0];
			clientMessage.parameters[1] = data[1];
			clientMessage.parameters[2] = data[2];
			
			Object object = (Object) date;
			
			ArrayList<Object> list = new ArrayList<>();
			list.add(object);
			clientMessage.setSendingObjects(list);
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
