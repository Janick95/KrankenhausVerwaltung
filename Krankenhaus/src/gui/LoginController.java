package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import application.Benutzer;
import application.Main;
import application.ReaderWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

	@FXML
	Label lblPasswort;

	@FXML
	TextField txtResetUserID;

	@FXML
	TextField txtResetPasswort;
	@FXML
	Button btnResetPasswort;

	// Button Event
	@FXML
	public void handleLoginAction(ActionEvent event) throws IOException // This method loads a new scene in a current
																		// window
	{

		String[] user = ReaderWriter.readToArray("Benutzer.txt");

		ObservableList<String> benutzer = FXCollections.observableArrayList(user);

		for (int i = 0; i < benutzer.size(); i++) {

			String[] userdaten = user[i].split(",");

			String userid = userdaten[0];
			String password = userdaten[1];
			// User vorhanden
			if (userid.trim().equals(txtEmail.getText())) {
				// Passwort Überprüfung
				if (password.trim().equals(pfPasswort.getText())) {
					Alert msg = new Alert(AlertType.CONFIRMATION);
					msg.setTitle(txtEmail.getText());
					msg.setContentText("Email und Passwort vorhanden");
					msg.showAndWait();

					// Werte speichern
					Benutzer.setUserId(userid);
					Benutzer.setPassword(password);

					// Fenster öffnen
					checkAdmin();
					System.out.println(userdaten[0] + " ," + userdaten[1]);
					openWindow();

					break; // User ID und Passwort stimmen, Schleife geschlossen
				}
			}
		}

		/*
		 * if (validateData()) { if (Benutzer.getUserId() == null) {
		 * System.out.println("Diese ID gibt es nicht!");
		 * 
		 * Alert msg = new Alert(AlertType.ERROR); msg.setTitle(txtEmail.getText());
		 * msg.setContentText("Diese Email gibt es nicht: " + txtEmail.getText());
		 * msg.showAndWait(); } else if (Benutzer.getPassword() == null) {
		 * System.out.println("Dieses Passwort gibt es nicht!"); Alert msg = new
		 * Alert(AlertType.ERROR); msg.setTitle(pfPasswort.getText());
		 * msg.setContentText("Falsches Passwort " + pfPasswort.getText());
		 * msg.showAndWait(); } }
		 */
	}

	// Hier evtl nur gucken ob man den einen Button nur ausblendet
	@FXML
	public boolean checkAdmin() {
		boolean result;
		if (Benutzer.getUserId().contains("Admin")) {
			Alert msg = new Alert(AlertType.CONFIRMATION);
			msg.setContentText(Benutzer.getUserId() + " ist ein Admin");
			msg.showAndWait();
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

// Passwort Validierung auf 8 Zeichen und Sonderzeichen !!!!
	@FXML
	private boolean validateData() {
		Alert msg = new Alert(AlertType.ERROR);
		boolean result = true;
		if (txtEmail.getText().equals("")) {
			msg.setContentText("Bitte füllen Sie das Login-ID Feld aus!");
			msg.showAndWait();
			result = false;
		} else {
			if (pfPasswort.getText().equals("")) {
				msg.setContentText("Bitte füllen Sie das Passwort Feld aus!");
				msg.showAndWait();
				result = false;
			} else {
				if (pfPasswort.getText().length() < 8) {
					msg.setContentText("Ihr Passwort muss aus mindestens 8 Zeichen bestehen");
					msg.showAndWait();
					result = false;
				}
			}

		}
		return result;
	}

	// Methode um neues Passwort zu generieren
	@FXML
	public void handlePasswVerg(MouseEvent event) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("PasswortReset.fxml"));
			Main.stage.setScene(new Scene(root));

			String[] user = ReaderWriter.readToArray("Benutzer.txt");

			ObservableList<String> benutzer = FXCollections.observableArrayList(user);

			for (int i = 0; i < benutzer.size(); i++) {

				String[] userdaten = user[i].split(",");

				String userid = userdaten[0];
				String password = userdaten[1];

				if (userid.equals(txtResetUserID)) {
					
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
