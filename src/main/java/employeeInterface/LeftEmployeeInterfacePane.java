package employeeInterface;

import client.Client;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftEmployeeInterfacePane extends VBox {
	Button addCustomerButton, realizeTransctionButton, showCustomertransactionsHistoryButton,
			customerAccountDetailsButton;

	public LeftEmployeeInterfacePane() {
		setAddCustomerButton();
		setRealizeTransactionButton();
		setShowCustomertransactionsHistoryButton();
		setShowCustomerAccountDetailsButton();

	}

	private void setAddCustomerButton() {
		addCustomerButton = new Button("Add a customer");
		addCustomerButton.setTranslateX(17);
		addCustomerButton.setTranslateY(170);
		addCustomerButton.setOnAction(e -> {
			Client.mainEmployeeInterfacePane.setCenterAddCustomerPane();
		});
		this.getChildren().add(addCustomerButton);
	}

	private void setRealizeTransactionButton() {
		realizeTransctionButton = new Button("Realize transaction");
		realizeTransctionButton.setTranslateX(17);
		realizeTransctionButton.setTranslateY(180);
		realizeTransctionButton.setOnAction(e -> {
			Client.mainEmployeeInterfacePane.setCenterRealizeTransactionPane();
		});
		this.getChildren().add(realizeTransctionButton);
	}

	private void setShowCustomertransactionsHistoryButton() {
		showCustomertransactionsHistoryButton = new Button("Show customer transactions");
		showCustomertransactionsHistoryButton.setTranslateX(17);
		showCustomertransactionsHistoryButton.setTranslateY(190);
		showCustomertransactionsHistoryButton.setOnAction(e -> {
			Client.mainEmployeeInterfacePane.customerTransactionsHistoryPane.sendFetchCustomers();
		});
		this.getChildren().add(showCustomertransactionsHistoryButton);
	}

	private void setShowCustomerAccountDetailsButton() {
		customerAccountDetailsButton = new Button("Customer account details");
		customerAccountDetailsButton.setTranslateX(17);
		customerAccountDetailsButton.setTranslateY(200);
		customerAccountDetailsButton.setOnAction(e -> {
			Client.mainEmployeeInterfacePane.customerAccountDetails.sendFetchCustomers();
		});
		this.getChildren().add(customerAccountDetailsButton);
	}
}
