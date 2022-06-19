package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PVController02 {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Element des zweiten Patienten-Bildschirms
	@FXML
	Button btnMainmenu02;
	@FXML
	TextField txtSurname02;
	@FXML
	TextField txtName02;
	@FXML
	TextField txtAge02;
	@FXML
	TextField txtFamstat02;
	@FXML
	TextField txtReasonForStay;
	@FXML
	TextField txtDoctor02;
	@FXML
	Button btnCreate02;

	@FXML
	// Diese Methode fügt einen neuen Patienten der Text Datei hinzu
	public void goToPatList(ActionEvent event) throws IOException {
		String[] patient2 = new String[7];
		int lower = 3000;
		int upper = 3999;

		String id = String.valueOf((int) (Math.random() * (upper - lower)));
		String surname = txtSurname02.getText();
		String name = txtName02.getText();
		String age = txtAge02.getText();
		String reason = txtReasonForStay.getText();
		String famstat = txtFamstat02.getText();
		String doctor = txtDoctor02.getText();

		patient2[0] = id;
		patient2[1] = surname;
		patient2[2] = name;
		patient2[3] = age;
		patient2[4] = reason;
		patient2[5] = famstat;
		patient2[6] = doctor;

		String newPat = id + "," + surname + "," + name + "," + age + "," + reason + "," + famstat + "," + doctor;

		application.ReaderWriter.writeStringIntoTxt(newPat, "Patienten.txt");

		Parent root = FXMLLoader.load(getClass().getResource("/gui/Patientendaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Neuen Patienten erstellen");
		stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	// Events
	@FXML
	public void goToMainmenu(ActionEvent event) throws IOException // Diese Methode lädt den Hauptmenübildschirm
	{
		if (LoginController.isAdmin == true) {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen01.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
}
