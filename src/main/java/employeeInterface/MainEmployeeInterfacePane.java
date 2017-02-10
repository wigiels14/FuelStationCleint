package employeeInterface;

import employeeInterface.subInterfaces.AddCustomerInterfacePane;
import employeeInterface.subInterfaces.CustomerAccountDetails;
import employeeInterface.subInterfaces.CustomerTransactionsHistoryPane;
import employeeInterface.subInterfaces.RealizeTransactionInterfacePane;
import javafx.scene.layout.BorderPane;
import managerInterface.LeftManagerInterfacePane;
import managerInterface.TopManagerInterfacePane;

public class MainEmployeeInterfacePane extends BorderPane {
	public TopEmployeeInterfacePane topEmployeeInterfacePane;
	public LeftEmployeeInterfacePane leftEmployeeInterfacePane;
	public AddCustomerInterfacePane addCustomerInterfacePane;
	public RealizeTransactionInterfacePane realizeTransactionInterfacePane;
	public CustomerTransactionsHistoryPane customerTransactionsHistoryPane;
	public CustomerAccountDetails customerAccountDetails;
	
	public MainEmployeeInterfacePane() {
		topEmployeeInterfacePane = new TopEmployeeInterfacePane();
		leftEmployeeInterfacePane = new LeftEmployeeInterfacePane();
		addCustomerInterfacePane = new AddCustomerInterfacePane();
		realizeTransactionInterfacePane = new RealizeTransactionInterfacePane();
		customerTransactionsHistoryPane = new CustomerTransactionsHistoryPane();
		customerAccountDetails = new CustomerAccountDetails();
		
		setLeft(leftEmployeeInterfacePane);
		setStyle("-fx-background-image: url('rounded_corners_interface.png');" + "-fx-background-radius: 50px;");
	}

	public void setTopEmployeeInterfacePane() {
		topEmployeeInterfacePane.initAll();
		setTop(topEmployeeInterfacePane);
	}
	
	public void setCenterAddCustomerPane() {
		addCustomerInterfacePane.initAll();
		setCenter(addCustomerInterfacePane);
	}
	
	public void setCenterRealizeTransactionPane() {
		realizeTransactionInterfacePane.initAll();
		setCenter(realizeTransactionInterfacePane);
	}
	
	public void setCenterCustomerTransactionsHistoryPane() {
		customerTransactionsHistoryPane.initAll();
		setCenter(customerTransactionsHistoryPane);
	}
	
	public void setCenterCustomerAccountDetails() {
		customerAccountDetails.initAll();
		setCenter(customerAccountDetails);
	}

}