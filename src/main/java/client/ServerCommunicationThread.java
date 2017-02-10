package client;

import java.io.IOException;
import java.util.ArrayList;

import Transaction.Transaction;
import branch.Branch;
import javafx.application.Platform;
import person.Employee;
import person.Manager;
import person.customer.Customer;

public class ServerCommunicationThread extends Thread {

	@Override
	public void run() {
		while (true) {
			Object response = convertServerResponce();

			if (response instanceof ClientMessage) {
				if (((ClientMessage) response).messageType.equals("isUserInSystemDatabase")) {
					proceedIsUserInSystemDatabaseResponce((ClientMessage) response);
				}
				if (((ClientMessage) response).messageType.equals("sendFetchManager")) {
					proceedSendFetchManager((ClientMessage) response);
				}
				if (((ClientMessage) response).messageType.equals("sendFetchEmployee")) {
					proceedSendFetchEmployee((ClientMessage) response);
				}
				if (((ClientMessage) response).messageType.equals("fetchEmployees")) {
					proceedFetchEmployees((ClientMessage) response);
				}
				if (((ClientMessage) response).messageType.equals("fireEmployee")) {
					proceedFireEmployee((ClientMessage) response);
				}
				if (((ClientMessage) response).messageType.equals("fetchCustomers")) {
					proceedFetchCustomers((ClientMessage) response);
				}
				if (((ClientMessage) response).messageType.equals("fetchCustomerTransactions")) {
					proceedFetchCustomerTransactions((ClientMessage) response);
				}
				if (((ClientMessage) response).messageType.equals("fetchCustomerAccount")) {
					proceedFetchCustomerAccount((ClientMessage) response);
				}
			}
		}
	}

	private void proceedFetchCustomerAccount(ClientMessage response) {
		Client.mainEmployeeInterfacePane.customerAccountDetails.getCustomerAccount().setId(response.parameters[0]);
		Client.mainEmployeeInterfacePane.customerAccountDetails.getCustomerAccount()
				.setBonusPoints(response.parameters[1]);
		
		Platform.runLater(() -> Client.mainEmployeeInterfacePane.customerAccountDetails.initCustomerAccountData());
	}

	private void proceedFetchCustomerTransactions(ClientMessage response) {
		ArrayList<Object> notConvertedCustomers = response.getSendingObjects();

		ArrayList<Transaction> transactions = new ArrayList<>();

		for (Object notConvertedCustomer : notConvertedCustomers) {
			String[] convertedObject = (String[]) notConvertedCustomer;

			Transaction transaction = new Transaction();
			transaction.setId(convertedObject[0]);
			transaction.setDate(convertedObject[4]);
			transaction.setCost(convertedObject[3]);
			transaction.setEmployeeiD(convertedObject[2]);
			transaction.setAddedBonusPoints(convertedObject[5]);

			transactions.add(transaction);
		}

		Client.mainEmployeeInterfacePane.customerTransactionsHistoryPane.setTransactions(transactions);

		Platform.runLater(() -> Client.mainEmployeeInterfacePane.customerTransactionsHistoryPane.initTransactionData());
	}

	private void proceedFetchCustomers(ClientMessage response) {
		ArrayList<Object> notConvertedCustomers = response.getSendingObjects();

		ArrayList<Customer> customers = new ArrayList<>();

		for (Object notConvertedCustomer : notConvertedCustomers) {
			String[] convertedObject = (String[]) notConvertedCustomer;

			Customer customer = new Customer();
			customer.setId(convertedObject[0]);
			customer.setFirstName(convertedObject[1]);
			customer.setLastName(convertedObject[2]);
			customer.setPesel(convertedObject[3]);
			customer.setIdNumber(convertedObject[4]);

			customers.add(customer);
		}

		if (response.parameters[0].equals("0")) {
			Client.mainEmployeeInterfacePane.customerTransactionsHistoryPane.setCustomers(customers);
			Platform.runLater(() -> Client.mainEmployeeInterfacePane.setCenterCustomerTransactionsHistoryPane());
		}
		else {
			Client.mainEmployeeInterfacePane.customerAccountDetails.setCustomers(customers);
			Platform.runLater(() -> Client.mainEmployeeInterfacePane.setCenterCustomerAccountDetails());
		}
	}

	private void proceedFireEmployee(ClientMessage response) {
		Manager manager = Client.mainManagerInterfacePane.topManagerInterfacePane.getManager();
		Client.mainManagerInterfacePane.fireEmployeeInterfacePane
				.sendFetchEmployeesByBranchID(manager.getBranch().getCity());

		Platform.runLater(() -> Client.mainManagerInterfacePane.setCenterFireEmployeePane());

	}

	private void proceedFetchEmployees(ClientMessage response) {
		ArrayList<Object> notConvertedEmloyees = response.getSendingObjects();

		ArrayList<Employee> employees = new ArrayList<>();

		for (Object notConvertedEmployee : notConvertedEmloyees) {
			String[] convertedObject = (String[]) notConvertedEmployee;
			Employee employee = new Employee();
			employee.setId(convertedObject[0]);
			employee.setFirstName(convertedObject[1]);
			employee.setLastName(convertedObject[2]);
			employee.setPESEL(convertedObject[3]);
			employee.setIdNumber(convertedObject[4]);
			employee.setPassword(convertedObject[5]);
			Branch branch = new Branch();
			branch.setId(convertedObject[6]);
			employee.setBranch(branch);

			employees.add(employee);
		}

		Client.mainManagerInterfacePane.fireEmployeeInterfacePane.setEmployees(employees);

		Platform.runLater(() -> Client.mainManagerInterfacePane.setCenterFireEmployeePane());
	}

	private void proceedSendFetchEmployee(ClientMessage response) {
		Employee employee = new Employee();
		employee.setId(response.parameters[0]);
		employee.setFirstName(response.parameters[1]);
		employee.setLastName(response.parameters[2]);
		employee.setPESEL(response.parameters[3]);
		employee.setPassword(response.parameters[4]);
		employee.setIdNumber(response.parameters[5]);
		Branch branch = new Branch();
		branch.setId(response.parameters[6]);
		branch.setCity(response.parameters[7]);
		employee.setBranch(branch);

		Client.mainEmployeeInterfacePane.topEmployeeInterfacePane.setEmployee(employee);

		Platform.runLater(() -> Client.mainEmployeeInterfacePane.setTopEmployeeInterfacePane());

		Platform.runLater(() -> Client.setEmployeeInterfaceSceneActive());
	}

	private void proceedSendFetchManager(ClientMessage response) {
		Manager manager = new Manager();
		manager.setId(response.parameters[0]);
		manager.setFirstName(response.parameters[1]);
		manager.setLastName(response.parameters[2]);
		manager.setPESEL(response.parameters[3]);
		manager.setPassword(response.parameters[4]);
		manager.setIdNumber(response.parameters[5]);
		Branch branch = new Branch();
		branch.setId(response.parameters[6]);
		branch.setCity(response.parameters[7]);
		manager.setBranch(branch);

		Client.mainManagerInterfacePane.topManagerInterfacePane.setManager(manager);

		Platform.runLater(() -> Client.mainManagerInterfacePane.setTopManagerInterfacePane());

		Platform.runLater(() -> Client.setManagerInterfaceSceneActive());
	}

	private void proceedIsUserInSystemDatabaseResponce(ClientMessage response) {
		if (response.isMessageTrue) {
			String whoIsLoggedIn = response.parameters[9];
			if (whoIsLoggedIn.equals("employee")) {
				Client.mainLogInPanel.myCenterPanel.sendFetchEmployee(response.parameters[0]);
			} else {
				Client.mainLogInPanel.myCenterPanel.sendFetchManager(response.parameters[0]);
			}
		} else {
			Client.mainLogInPanel.myCenterPanel.setWrongDataField("Invalid data");
		}
	}

	private Object convertServerResponce() {
		Object response = null;
		try {
			response = Client.in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
