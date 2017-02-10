package logIn;

import javafx.scene.layout.BorderPane;

public class MainLogInPanel extends BorderPane {
	public CenterLogInPanel myCenterPanel;

	public MainLogInPanel() {
		myCenterPanel = new CenterLogInPanel();
		this.setStyle("-fx-background-image: url('rounded_corners.png');" + "-fx-background-radius: 50px;");
		this.setCenter(myCenterPanel);
	}

}