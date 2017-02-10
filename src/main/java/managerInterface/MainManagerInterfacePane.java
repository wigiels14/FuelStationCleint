package managerInterface;

import javafx.scene.layout.BorderPane;
import managerInterface.subInterfaces.ChangePersonalDataInterfacePane;
import managerInterface.subInterfaces.FireEmployeeInterfacePane;
import managerInterface.subInterfaces.HireEmployeeInterfacePane;

public class MainManagerInterfacePane extends BorderPane {
	public TopManagerInterfacePane topManagerInterfacePane;
	public LeftManagerInterfacePane leftManagerInterfacePane;
	public ChangePersonalDataInterfacePane changePersonalDataPane;
	public HireEmployeeInterfacePane hireEmployeeInterfacePane;
	public FireEmployeeInterfacePane fireEmployeeInterfacePane;

	public MainManagerInterfacePane() {
		topManagerInterfacePane = new TopManagerInterfacePane();
		leftManagerInterfacePane = new LeftManagerInterfacePane();
		changePersonalDataPane = new ChangePersonalDataInterfacePane();
		hireEmployeeInterfacePane = new HireEmployeeInterfacePane();
		fireEmployeeInterfacePane = new FireEmployeeInterfacePane();

		setLeftManagerInterfacePane();
		setStyle("-fx-background-image: url('rounded_corners_interface.png');" + "-fx-background-radius: 50px;");
	}

	public void setTopManagerInterfacePane() {
		topManagerInterfacePane.initAll();
		setTop(topManagerInterfacePane);
	}

	public void setLeftManagerInterfacePane() {
		setLeft(leftManagerInterfacePane);
	}

	public void setCenterChangePersonalDatapane() {
		changePersonalDataPane.initAll();
		setCenter(changePersonalDataPane);
	}

	public void setCenterHireEmployeePane() {
		hireEmployeeInterfacePane.initAll();
		setCenter(hireEmployeeInterfacePane);
	}
	
	public void setCenterFireEmployeePane() {
		fireEmployeeInterfacePane.initAll();
		setCenter(fireEmployeeInterfacePane);
	}

}