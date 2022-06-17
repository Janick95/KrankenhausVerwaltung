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
	public Button btnRegistrierung02;
	@FXML
	private Button btnOpTermine01;
	@FXML
	private Button btnOpTermine02;
	@FXML
	private Button btnPatDaten01;
	@FXML
	private Button btnPatDaten02;
	@FXML
	private Button btnRaumbelegung01;
	@FXML
	private Button btnRaumbelegung02;
	@FXML
	private Button btnPersonaldaten01;
	@FXML
	private Button btnPersonaldaten02;
	@FXML
	private Button btnLogout01;
	@FXML
	private Button btnLogout02;

	// Button Events

	public void goToPatientendaten(ActionEvent event) throws IOException // Diese Methode l�dt den Patientendatenbildschirm in dem aktuellen Fenster
																			
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Patientendaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Patienten Daten");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
		PVController pvc = new PVController();
		pvc.zeigePatientenListe();
	}

	public void goToOperationsTermine(ActionEvent event) throws IOException // Diese Methode l�dt den Operations-Terminbildschirm in dem aktuellen Fenster
																			
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Operationstermine.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Operationstermine");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
		TVController tvc = new TVController();
		tvc.zeigeOpListAn();
	}

	public void goToRaumbelegung(ActionEvent event) throws IOException // Diese Methode l�dt den Raumbelegungsbildschirm in dem aktuellen Fenster
																		
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Raumbelegung.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Raumbelgung");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
		RVController rvc = new RVController();
		rvc.zeigeRaumListAn();
	}

	public void goToPersonaldaten(ActionEvent event) throws IOException // Diese Methode l�dt den Personaldatenbildschirm in dem aktuellen Fenster
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Personaldaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Personal Daten");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	public void goToRegistrierung(ActionEvent event) throws IOException // Diese Methode l�dt den Registrierungsbildschirm in dem aktuellen Fenster
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Registrierung.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Registrierung");
		//stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	public void logout(ActionEvent event) throws IOException // Diese Methode l�dt den Loginbildschirm in dem aktuellen Fenster
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
