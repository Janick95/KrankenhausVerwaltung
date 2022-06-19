package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Benutzer;
import application.Main;
import application.ReaderWriter;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;
	public static boolean isAdmin;

	// Zugriff auf FXML Elemente
	@FXML
	ImageView imgVlogo;

	@FXML
	TextField txtLoginId;
	@FXML
	TextField txtNewLoginId;
	@FXML
	PasswordField pfPasswort;
	@FXML
	PasswordField pfNewPassw;

	@FXML
	Label lblPasswReset;

	@FXML
	Button btnAnmelden;

	@FXML
	Button btnResetOk;
	
	
	
	// Button Event
	@FXML
	//Login Prozess
	public void handleLoginAction(ActionEvent event) throws IOException
	{
		String[] users = ReaderWriter.readToArray("Benutzer.txt");

		String userID = txtLoginId.getText().trim();
		String userPw = pfPasswort.getText().trim();

		String[] u1 = users[0].split(",");
		String[] u2 = users[1].split(",");
		
		Benutzer user1 = new Benutzer(u1[0], u1[1]);
		Benutzer user2 = new Benutzer(u2[0], u2[1]);
		
		Alert msg = new Alert(AlertType.ERROR);
		if (validateData() == true) {
			if (user1.getID().equals(userID)) {
				if (user1.getID().equals(userID) == false) {
					msg.setTitle("Fehlerhafte Login-Id");
					msg.setContentText("Diese Login-Id gibt es nicht: " + txtLoginId.getText());
					msg.showAndWait();
				} else if (user1.getPassword().equals(userPw) == false) {
					msg.setTitle("Fehlerhaftes Passwort");
					msg.setContentText("Das Passwort gibt es nicht");
					msg.showAndWait();
				}
			} else {
				if (user2.getID().equals(userPw)) {
					if (user2.getID().equals(userID) == false) {
						msg.setTitle("Fehlerhafte Login-Id");
						msg.setContentText("Diese Login-Id gibt es nicht: " + txtLoginId.getText());
						msg.showAndWait();
					} else if (user2.getPassword().equals(userPw) == false) {
						msg.setTitle("Fehlerhaftes Passwort");
						msg.setContentText("Falsches Passwort ");
						msg.showAndWait();
					}
				}
			}
			checkAdmin();
			// Fenster öffnen
			openWindow();

		}

	}

	// Hier evtl nur gucken ob man den einen Button nur ausblendet
	@FXML
	public boolean checkAdmin() {
		Alert msg = new Alert(AlertType.CONFIRMATION);
		if (txtLoginId.getText().contains("Admin")) {
			isAdmin = true;
			msg.setTitle("Ist Admin");
			msg.setContentText("Dieser Benutzer ist ein Admin");
			msg.showAndWait();
		} else {
			isAdmin = false;
		}
		return isAdmin;
	}

	@FXML
	private void openWindow() {
		if (isAdmin==false) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("HauptmenuScreen01.fxml"));
				Main.stage.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (isAdmin==true) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("HauptmenuScreen02.fxml"));
				Main.stage.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	private boolean validateData() {
		boolean result = true;
		if (txtLoginId.getText().equals("")) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Bitte füllen Sie das Login-ID Feld aus!");
			msg.showAndWait();
			result = false;
		} else if (pfPasswort.getText().equals("")) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Bitte füllen Sie das Passwort Feld aus!");
			msg.showAndWait();
			result = false;
		} else if (pfPasswort.getText().length() < 8) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Ihr Passwort muss aus min. 8 Zeichen bestehen!");
		msg.showAndWait();}
		return result;
	}

	@FXML
	public void passwReset(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/PasswReset.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Passwort Reset");
		stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	@FXML
	public void resetPassw(ActionEvent event) throws IOException {
		String[] user = new String[2];

		String loginId = txtNewLoginId.getText();
		String passw = pfNewPassw.getText();

		user[0] = loginId;
		user[1] = passw;

		String newuser = loginId + ", " + passw;

		application.ReaderWriter.deleteFromTxt(loginId, "Benutzer.txt");

		application.ReaderWriter.writeStringIntoTxt(newuser, "Benutzer.txt");

		Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Herzlich Willkommen im River Krankenhaus");
		stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}
}
