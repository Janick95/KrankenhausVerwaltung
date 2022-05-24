package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegistrierungController {

	// Zugriff auf FXML Elemente
	@FXML
	// Buttons
	private Button btnHauptmenüR;
	@FXML
	private Button btnRegistrierenR;

	// Textfelder
	@FXML
	private TextField txtVornameR;
	@FXML
	private TextField txtNachnameR;
	@FXML
	private TextField txtRangR;
	@FXML
	private TextField txtSchuleR;
	@FXML
	private TextField txtAbteilungR;
	@FXML
	private TextField txtTitelR;
	@FXML
	private TextField txtEmailR;
	@FXML
	private TextField txtHerkunftR;
	@FXML
	private TextField txtSprachenR;
	@FXML
	private TextField txtAusbildungR;
	@FXML
	private TextField txtSpezialitätR;
	@FXML
	private TextField txtLoginR;

	// Passwortfeld
	@FXML
	private PasswordField pfPasswortR;

	// Radiobuttons
	@FXML
	private RadioButton rbtnAktivR;
	@FXML
	private RadioButton rbtnInaktivR;

	// ComboBox
	@FXML
	private ComboBox<String> cmbPrefixR;
	@FXML
	private ComboBox<String> cmbGeschlechtR;
	@FXML
	private ComboBox<String> cmbAbgeschlossenR;

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Methoden

	@FXML
	public void initialize() {
		// Prefix ComboBox Inhalte:
		cmbPrefixR.getItems().removeAll(cmbPrefixR.getItems());
		cmbPrefixR.getItems().addAll("Mann", "Frau", "Divers");
		cmbPrefixR.getSelectionModel().select("Frau");

		// Geschlecht ComboBox Inhalte:
		cmbGeschlechtR.getItems().removeAll(cmbGeschlechtR.getItems());
		cmbGeschlechtR.getItems().addAll("Männlich", "Weiblich", "Anders");
		cmbGeschlechtR.getSelectionModel().select("Weiblich");

		// Abschluss ComboBox Inhalte:
		cmbAbgeschlossenR.getItems().removeAll(cmbAbgeschlossenR.getItems());
		cmbAbgeschlossenR.getItems().addAll("2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022");
		cmbAbgeschlossenR.getSelectionModel().select("2020");

	}

	@FXML // Aktuell erstellt er immer ein neues txt File =====> soll in bestehendes File
			// hineinschreiben Directory Chooser OpenFile Dialog
	private void handleButtonRegistrationAction(ActionEvent event) throws IOException {
		if (validateData()) {
			if (txtRangR.getText().equals("Pfleger")) {
				try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Pfleger.txt", true)))) {
					out.println(cmbPrefixR.getValue() + "," + txtVornameR.getText() + "," + txtNachnameR.getText() + ","
							+ txtRangR.getText() + "," + txtSchuleR.getText() + "," + txtAbteilungR.getText() + ","
							+ txtTitelR.getText() + "," + txtEmailR.getText() + "," + cmbGeschlechtR.getValue() + ","
							+ txtHerkunftR.getText() + "," + txtSprachenR.getText() + "," + rbtnAktivR.isSelected()
							+ "," + rbtnInaktivR.isSelected() + "," + txtAusbildungR.getText() + ","
							+ txtSpezialitätR.getText() + "," + cmbAbgeschlossenR.getValue());
					Alert mesg = new Alert(AlertType.CONFIRMATION);
					mesg.setContentText("Pfleger hinzugefügt");
					mesg.showAndWait();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			} else {
				if (txtRangR.getText().equals("Arzt")) {
					try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Arzt.txt", true)))) {
						out.println(cmbPrefixR.getValue() + "," + txtVornameR.getText() + "," + txtNachnameR.getText()
								+ "," + txtRangR.getText() + "," + txtSchuleR.getText() + "," + txtAbteilungR.getText()
								+ "," + txtTitelR.getText() + "," + txtEmailR.getText() + ","
								+ cmbGeschlechtR.getValue() + "," + txtHerkunftR.getText() + ","
								+ txtSprachenR.getText() + "," + rbtnAktivR.isSelected() + ","
								+ rbtnInaktivR.isSelected() + "," + txtAusbildungR.getText() + ","
								+ txtSpezialitätR.getText() + "," + cmbAbgeschlossenR.getValue());
						Alert mesg = new Alert(AlertType.CONFIRMATION);
						mesg.setContentText("Arzt hinzugefügt");
						mesg.showAndWait();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		}
	}

	private boolean validateData() {
		Alert msg = new Alert(AlertType.ERROR);
		boolean result = true;
		/*
		 * String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" +
		 * "(?:[a-zA-Z0-9-]+\\.)+[a-z"+ "A-Z]{2,7}$"; Pattern pat =
		 * Pattern.compile(emailRegex);
		 */

		if (txtVornameR.getText().equals("")) {
			msg.setContentText("Bitte füllen Sie das Vornamen Feld aus!");
			msg.showAndWait();
			result = false;
		} else {
			if (txtNachnameR.getText().equals("")) {
				msg.setContentText("Bitte füllen Sie das Nachnamen Feld aus!");
				msg.showAndWait();
				result = false;
			} else {
				if (txtRangR.getText().equals("")) {
					msg.setContentText("Bitte füllen Sie das Rang Feld aus!");
					msg.showAndWait();
					result = false;
				} else {
					if (txtSchuleR.getText().equals("")) {
						msg.setContentText("Bitte füllen Sie das Schule Feld aus!");
						msg.showAndWait();
						result = false;
					} else {
						if (txtAbteilungR.getText().equals("")) {
							msg.setContentText("Bitte füllen Sie das Abteilung Feld aus!");
							msg.showAndWait();
							result = false;
						} else {
							if (txtEmailR.getText().equals("")) {
								msg.setContentText("Bitte füllen Sie das Email Feld aus!");
								msg.showAndWait();
								result = false;
							} else {
								if (txtHerkunftR.getText().equals("")) {
									msg.setContentText("Bitte füllen Sie das Herkunfts Feld aus!");
									msg.showAndWait();
									result = false;
								} else {
									if (txtSprachenR.getText().equals("")) {
										msg.setContentText("Bitte füllen Sie das Sprachen Feld aus!");
										msg.showAndWait();
										result = false;
									} else {
										if (txtSpezialitätR.getText().equals("")) {
											msg.setContentText("Bitte füllen Sie das Spezialitäts Feld aus!");
											msg.showAndWait();
											result = false;
										} else {
											if (txtLoginR.getText().equals("")) {
												msg.setContentText("Bitte füllen Sie das LoginID Feld aus!");
												msg.showAndWait();
												result = false;
											} else {
												if (pfPasswortR.getText().equals("")) {
													msg.setContentText("Bitte füllen Sie das Passwort Feld aus!");
													msg.showAndWait();
													result = false;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}

	@FXML
	public void goToHauptmenü(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
