package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainMenuController extends LoginController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf die Buttons
	@FXML
	private Button btnRegister02;
	@FXML
	private Button btnOpData01;
	@FXML
	private Button btnOpData02;
	@FXML
	private Button btnPatData01;
	@FXML
	private Button btnPatData02;
	@FXML
	private Button btnRoomData01;
	@FXML
	private Button btnRoomData02;
	@FXML
	private Button btnStaffData01;
	@FXML
	private Button btnStaffData02;
	@FXML
	private Button btnLogout01;
	@FXML
	private Button btnLogout02;

	// Button Events

	public void goToPatientdata(ActionEvent event) throws IOException // Diese Methode lädt den Patientendatenbildschirm in dem aktuellen Fenster
																			
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Patientendaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Patienten Daten");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	public void goToOperationData(ActionEvent event) throws IOException // Diese Methode lädt den Operations-Terminbildschirm in dem aktuellen Fenster
																			
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Operationstermine.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Operationstermine");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	public void goToRoomData(ActionEvent event) throws IOException // Diese Methode lädt den Raumbelegungsbildschirm in dem aktuellen Fenster
																		
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Raumbelegung.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Raumbelgung");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	public void goToStaffdata(ActionEvent event) throws IOException // Diese Methode lädt den Personaldatenbildschirm in dem aktuellen Fenster
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Personaldaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Personal Daten");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	public void goToRegistration(ActionEvent event) throws IOException // Diese Methode lädt den Registrierungsbildschirm in dem aktuellen Fenster
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Registrierung.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Registrierung");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	public void logout(ActionEvent event) throws IOException // Diese Methode lädt den Loginbildschirm in dem aktuellen Fenster
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Willkommen im River Krankenhaus");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}
}
