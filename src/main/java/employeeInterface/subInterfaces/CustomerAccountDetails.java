package employeeInterface.subInterfaces;

import java.io.IOException;
import java.util.ArrayList;

import client.Client;
import client.ClientMessage;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import person.customer.Customer;
import person.customer.CustomerAccount;

public class CustomerAccountDetails extends GridPane {
	private Text pickTheCustomerText;
	private ComboBox customersComboBox;
	private Button acceptDataButton;

	private CustomerAccount customerAccount;
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public void initAll() {
		getChildren().clear();

		setPickTheCustomerText();
		setCustomersComboBox();
		setAcceptButton();

	}

	public void initCustomerAccountData() {
		initAll();
		Text transactionData = new Text("Bonus points " + customerAccount.getBonusPoints());
		transactionData.setId("smallDataText");
		transactionData.setTranslateX(80);
		transactionData.setTranslateY(80);
		this.add(transactionData, 1, 2);
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
		acceptDataButton = new Button("Show details");
		acceptDataButton.setId("leftPanelButton");
		acceptDataButton.setTranslateX(140);
		acceptDataButton.setTranslateY(70);
		acceptDataButton.setOnAction(e -> {
			customerAccount = new CustomerAccount();
			customerAccount.setCustomer((Customer) customersComboBox.getValue());
			sendFetchCustomerAccount(((Customer) customersComboBox.getValue()).getId());
		});
		this.add(acceptDataButton, 2, 0);
	}

	public void sendFetchCustomerAccount(String customerID) {
		try {
			ClientMessage clientMessage = new ClientMessage("fetchCustomerAccount");
			clientMessage.parameters[0] = customerID;
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendFetchCustomers() {
		try {
			ClientMessage clientMessage = new ClientMessage("fetchCustomers");
			clientMessage.parameters[0] = "1";
			Client.out.writeObject(clientMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}