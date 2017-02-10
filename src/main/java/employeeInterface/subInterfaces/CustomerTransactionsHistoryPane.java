package employeeInterface.subInterfaces;

import java.io.IOException;
import java.util.ArrayList;

import Transaction.Transaction;
import client.Client;
import client.ClientMessage;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import person.customer.Customer;

public class CustomerTransactionsHistoryPane extends GridPane {
	private Text pickTheCustomerText;
	private ComboBox customersComboBox;
	private Button acceptDataButton;

	private ArrayList<Text> transactionDatas;

	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void initAll() {
		getChildren().clear();

		setPickTheCustomerText();
		setCustomersComboBox();
		setAcceptButton();

	}

	public void initTransactionData() {
		getChildren().clear();
		int i = 0;
		
		for (Transaction transaction : transactions) {
			Text transactionData = new Text("Date: " + transaction.getDate() + ", cost: " + transaction.getCost() + ""
					+ ", added points: " + transaction.getAddedBonusPoints());
			transactionData.setId("smallDataText");
			transactionData.setTranslateX(100);
			transactionData.setTranslateY(70);
			this.add(transactionData, 6, i);
			i++;
		}
	}

	private void setPickTheCustomerText() {
		pickTheCustomerText = new Text("Pick the customer: ");
		pickTheCustomerText.setId("smallDataText");
		pickTheCustomerText.setTranslateX(60);
		pickTheCustomerText.setTranslateY(70);
		this.add(pickTheCustomerText, 0, 0);
	}

	private void setCustomersComboBox() {
		customersComboBox = new ComboBox<Customer>(FXCollections.observableList(customers));
		customersComboBox.setTranslateX(70);
		customersComboBox.setTranslateY(70);
		this.add(customersComboBox, 1, 0);
	}

	private void setAcceptButton() {
		acceptDataButton = new Button("Show transactions");
		acceptDataButton.setId("leftPanelButton");
		acceptDataButton.setTranslateX(140);
		acceptDataButton.setTranslateY(70);
		acceptDataButton.setOnAction(e -> {
			sendFetchCustomerTransactions();
		});
		this.add(acceptDataButton, 2, 0);
	}

	public void sendFetchCustomers() {
		try {
			ClientMessage clientMessage = new ClientMessage("fetchCustomers");
			clientMessage.parameters[0] = "0";
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendFetchCustomerTransactions() {
		try {
			ClientMessage clientMessage = new ClientMessage("fetchCustomerTransactions");
			clientMessage.parameters[0] = ((Customer)customersComboBox.getValue()).getId();
			System.out.println(clientMessage.parameters[0]);
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
