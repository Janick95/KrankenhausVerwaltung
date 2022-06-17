package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {

	// Zugriff auf FXML Elemente
	@FXML
	ImageView imgLogo;

	@FXML
	TextField txtEmail;

	@FXML
	PasswordField pfPasswort;

	@FXML
	Button btnAnmelden;

	// Button Event
	@FXML
	public void handleLoginAction(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		// Pfad zur Text Datei
		Path path = Paths.get("Benutzer.txt");

		// Zähle Zeilen der Text Datei
		long count = Files.lines(path).count();

		// Zeilen auslesen
		for (int i = 0; i < count; i++) {
			String line = Files.readAllLines(path).get(i);
			if (!line.trim().equals("")) {
				// Betreffendes Datei Format Email, Passwort
				String[] benutzer = line.split(",");

				String email = benutzer[0];
				String password = benutzer[1];

				// User vorhanden
				if (email.trim().equals(txtEmail.getText())) {
					// Passwort Überprüfung
					if (password.trim().equals(pfPasswort.getText())) {
						Alert msg = new Alert(AlertType.CONFIRMATION);
						msg.setTitle(txtEmail.getText());
						msg.setContentText("Email und Passwort vorhanden");
						msg.showAndWait();

						// Werte speichern
						Benutzer.setEmail(email);
						Benutzer.setPassword(password);

						// Fenster öffnen
						checkAdmin();
						System.out.println(benutzer[0] +" ," + benutzer[1]);
						openWindow();

						break; // User ID und Passwort stimmen, Schleife geschlossen
					}
				}
			}
			
		}
		if(validateData()) {
			if (Benutzer.getEmail() == null) {
				System.out.println("Diese Email gibt es nicht!");

				Alert msg = new Alert(AlertType.ERROR);
				msg.setTitle(txtEmail.getText());
				msg.setContentText("Diese Email gibt es nicht: " + txtEmail.getText());
				msg.showAndWait();
			} else if (Benutzer.getPassword() == null) {
				System.out.println("Dieses Passwort gibt es nicht!");
				Alert msg = new Alert(AlertType.ERROR);
				msg.setTitle(pfPasswort.getText());
				msg.setContentText("Falsches Passwort " + pfPasswort.getText());
				msg.showAndWait();
			}
		}
	}


	// Hier evtl nur gucken ob man den einen Button nur ausblendet

	public boolean checkAdmin() {
		Alert msg = new Alert(AlertType.ERROR);
		boolean result;
		if (Benutzer.getEmail().contains("Admin")) {
			System.out.println("Dieser Benutzer ist ein Admin");
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@FXML
	private void openWindow() {
		System.out.println("Benutzer eingeloggt");
		if (checkAdmin() == false) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("HauptmenuScreen02.fxml"));
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

	private boolean validateData() {
		Alert msg = new Alert(AlertType.ERROR);
		boolean result = true;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (txtEmail.getText().equals("")) {
			msg.setContentText("Bitte füllen Sie das E-Mail Feld aus!");
			msg.showAndWait();
			result = false;
		} else {
			if (pfPasswort.getText().equals("")) {
				msg.setContentText("Bitte füllen Sie das Passwort Feld aus!");
				msg.showAndWait();
				result = false;
			} else {
				if (!pat.matcher(txtEmail.getText()).matches()) {
					msg.setContentText("Sie haben eine ungültige E-Mail Adresse angegeben!");
					msg.showAndWait();
					result = false;
				}
			}
		}
		return result;
	}

}
