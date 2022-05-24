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

public class MainMenuController {
	

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;
	
	
	//Zugriff auf die Buttons 
	@FXML
	private Button btnOpTermine01;
	private Button btnOpTermine02;
	
	private Button btnPatDaten01;
	private Button btnPatDaten02;

	private Button btnRaumbelegung01;
	private Button btnRaumbelegung02;
	
	private Button btnPersonaldaten01;
	private Button btnPersonaldaten02;
	
	private Button btnLogout01;
	private Button btnLogout0;
	
	
	//Button Events

	public void goToPatientendaten(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Patientendaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Patienten Daten");
		stage.getIcons().add(new Image ("/img/Icon.jpg"));
		stage.show();
	}
	public void goToOperationsTermine(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Operationstermine.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Operationstermine");
		stage.getIcons().add(new Image ("/img/Icon.jpg"));
		stage.show();
	}
	public void goToRaumbelegung(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Raumbelegung.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Raumbelgung");
		stage.getIcons().add(new Image ("/img/Icon.jpg"));
		stage.show();
	}
	public void goToPersonaldaten(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Personaldaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Personal Daten");
		stage.getIcons().add(new Image ("/img/Icon.jpg"));
		stage.show();
	}
	
	public void goToRegistrierung(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Registrierung.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Registrierung");
		stage.getIcons().add(new Image ("/img/Icon.jpg"));
		stage.show();
	}
	public void logout(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Willkommen im River Krankenhaus");
		stage.getIcons().add(new Image ("/img/Icon.jpg"));
		stage.show();
	}
	
	
	
	
	
	

}
