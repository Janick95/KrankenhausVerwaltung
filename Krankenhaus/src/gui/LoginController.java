package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import application.Benutzer;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	TextField txtLoginID;

	@FXML
	PasswordField pfPasswort;

	@FXML
	Button btnAnmelden;

	// Button Event
	@FXML
	public void login(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		// Pfad zur Text Datei
		Path path = Paths.get("Benutzer.txt");

		// Zähle Zeilen der Text Datei
		long count = Files.lines(path).count();

		// Zeilen auslesen
		for (int i = 0; i < count; i++) {
			String line = Files.readAllLines(path).get(i);
			if (!line.trim().equals("")) {
				// Betreffendes Datei Format User-ID, Passwort
				String[] user = line.split(",");

				String userID = user[0];
				String password = user[1];

				// User vorhanden
				if (userID.trim().equals(txtLoginID.getText())) {
					// Passwort Überprüfung
					if (password.trim().equals(pfPasswort.getText())) {
						Alert msg = new Alert(AlertType.CONFIRMATION);
						msg.setTitle(txtLoginID.getText());
						msg.setContentText("User-ID und Passwort vorhanden");
						msg.showAndWait();

						// Werte speichern
						Benutzer.setUserID(userID);
						Benutzer.setPassword(password);

						// Fenster öffnen
						checkAdmin();
						openWindow();

						break; // User ID und Passwort stimmen, Schleife geschlossen
					}
				}
			}
		}

		if (Benutzer.getUserID() == null) {
			System.out.println("Dieser Benutzer existiert nicht");
			Alert msg = new Alert(AlertType.ERROR);
			msg.setTitle(txtLoginID.getText());
			msg.setContentText("Der User: " + txtLoginID.getText() + " existiert nicht!");
			msg.showAndWait();
		} else if (Benutzer.getPassword() == null) {
			System.out.println("Dieses Passwort existiert nicht");
			Alert msg = new Alert(AlertType.ERROR);
			msg.setTitle(pfPasswort.getText());
			msg.setContentText("Das Passwort: " + pfPasswort.getText() + " existiert nicht!");
			msg.showAndWait();
		}
	}

	//Hier evtl nur gucken ob man den einen Button nur ausblendet
	
	public boolean checkAdmin() {
		Alert msg = new Alert(AlertType.ERROR);
		boolean result;
		if (Benutzer.getUserID().contains("Admin")) {
			System.out.println("Dieser Benutzer ist ein Admin");
			result = true;
		}else {
			result = false;
		}
		return result;
	}

	private void openWindow() {
		System.out.println("Benutzer eingeloggt");
		if (checkAdmin() == false) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("HauptmenuScreen01.fxml"));
				Main.stage.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (checkAdmin() == true) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("HauptmenuScreen02.fxml"));
				Main.stage.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
