package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import employeeInterface.MainEmployeeInterfacePane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logIn.MainLogInPanel;
import managerInterface.MainManagerInterfacePane;

public class Client extends Application {
	public static Stage primaryStage;

	public static MainLogInPanel mainLogInPanel;
	public static MainManagerInterfacePane mainManagerInterfacePane;
	public static MainEmployeeInterfacePane mainEmployeeInterfacePane;

	private static Scene logInPanelScene;
	private static Scene mainManagerScene;
	private static Scene mainEmployeeScene;

	static InetAddress IP;
	static Socket socket;
	static public ObjectOutputStream out;
	static public ObjectInputStream in;
	static OutputStream outPut;
	static InputStream inPut;
	public static ServerCommunicationThread serverCommunicationThread;

	@Override
	public void start(Stage primaryStage) throws Exception {
		connectToServer();
		Client.primaryStage = primaryStage;

		mainLogInPanel = new MainLogInPanel();
		mainManagerInterfacePane = new MainManagerInterfacePane();
		mainEmployeeInterfacePane = new MainEmployeeInterfacePane();

		logInPanelScene = new Scene(mainLogInPanel, 1180, 564, Color.TRANSPARENT);
		logInPanelScene.getStylesheets().add("style.css");
		
		mainManagerScene = new Scene(mainManagerInterfacePane, 1180, 564, Color.TRANSPARENT);
		mainManagerScene.getStylesheets().add("style.css");
		
		mainEmployeeScene = new Scene(mainEmployeeInterfacePane, 1180, 564, Color.TRANSPARENT);
		mainEmployeeScene.getStylesheets().add("style.css");

		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

		primaryStage.setScene(logInPanelScene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();

		serverCommunicationThread.start();

	}

	public static void main(String[] args) {
		launch(args);
	}

	void connectToServer() {
		try {
			serverCommunicationThread = new ServerCommunicationThread();
			IP = InetAddress.getByName("localhost");
			socket = new Socket(IP, 8080);

			Client.outPut = socket.getOutputStream();
			Client.out = new ObjectOutputStream(Client.outPut);

			Client.inPut = socket.getInputStream();
			in = new ObjectInputStream(Client.inPut);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	public static void setLogInSceneActive() {
		primaryStage.setScene(logInPanelScene);
	}

	public static void setManagerInterfaceSceneActive() {
		primaryStage.setScene(mainManagerScene);
	}
	
	public static void setEmployeeInterfaceSceneActive() {
		primaryStage.setScene(mainEmployeeScene);
	}
}
