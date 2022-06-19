package gui;

import java.io.IOException;

import java.util.Arrays;

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
	private Button btnRegistrationR;

	// Textfelder
	@FXML
	private TextField txtSurnameR;
	@FXML
	private TextField txtNameR;
	@FXML
	private TextField txtRankR;
	@FXML
	private TextField txtSchoolR;
	@FXML
	private TextField txtDepartmentR;
	@FXML
	private TextField txtTitelR;
	@FXML
	private TextField txtEmailR;
	@FXML
	private TextField txtOriginR;
	@FXML
	private TextField txtLanguagesR;
	@FXML
	private TextField txtEducationR;
	@FXML
	private TextField txtSpecialityR;
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
	private ComboBox<String> cmbGenderR;
	@FXML
	private ComboBox<String> cmbSchoolFinishedR;

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
		cmbGenderR.getItems().removeAll(cmbGenderR.getItems());
		cmbGenderR.getItems().addAll("Männlich", "Weiblich", "Anders");
		cmbGenderR.getSelectionModel().select("Weiblich");

		// Abschluss ComboBox Inhalte:
		cmbSchoolFinishedR.getItems().removeAll(cmbSchoolFinishedR.getItems());
		cmbSchoolFinishedR.getItems().addAll("2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022");
		cmbSchoolFinishedR.getSelectionModel().select("2020");

	}

	@FXML // Aktuell erstellt er immer ein neues txt File =====> soll in bestehendes File
			// hineinschreiben Directory Chooser OpenFile Dialog
	private void handleButtonRegistrationAction(ActionEvent event) throws IOException {
		if (validateData()) {
			if (txtRankR.getText().equals("Pfleger")) {

				String[] pfleger = new String[6];
				String[] user = new String[2];
				int lower = 2000;
				int upper = 2999;

				String id = String.valueOf((int) (Math.random() * (upper - lower) + lower));
				String surName = txtSurnameR.getText();
				String name = txtNameR.getText();
				String rank = txtRankR.getText();
				String school = txtSchoolR.getText();
				String email = txtEmailR.getText();

				String userid = txtLoginR.getText();
				String userpw = pfPasswortR.getText();

				pfleger[0] = id;
				pfleger[1] = surName;
				pfleger[2] = name;
				pfleger[3] = rank;
				pfleger[4] = school;
				pfleger[5] = email;

				user[0] = userid;
				user[1] = userpw;

				String newNurse = id + "," + surName + "," + name + "," + rank + "," + school + "," + email;
				String newUser = userid + "," + userpw;
				application.ReaderWriter.writeStringIntoTxt(newNurse, "Pfleger.txt");
				application.ReaderWriter.writeStringIntoTxt(newUser, "Benutzer.txt");
				Alert mesg = new Alert(AlertType.CONFIRMATION);
				mesg.setContentText("Pfleger hinzugefügt");
				mesg.showAndWait();

			} else {
				if (txtRankR.getText().equals("Arzt")) {
					String[] doctor = new String[6];
					String[] user = new String[2];
					int lower = 1000;
					int upper = 1999;
					String id = String.valueOf((int) (Math.random() * (upper - lower) + lower));
					String surName = txtSurnameR.getText();
					String name = txtNameR.getText();
					String rank = txtRankR.getText();
					String school = txtSchoolR.getText();
					String email = txtEmailR.getText();

					String userid = txtLoginR.getText();
					String userpw = pfPasswortR.getText();

					doctor[0] = id;
					doctor[1] = surName;
					doctor[2] = name;
					doctor[3] = rank;
					doctor[4] = school;
					doctor[5] = email;

					user[0] = userid;
					user[1] = userpw;

					String newDoctor = id + "," + surName + "," + name + "," + rank + "," + school + "," + email;
					String newUser = userid + "," + userpw;

					application.ReaderWriter.writeStringIntoTxt(newDoctor, "Arzt.txt");
					application.ReaderWriter.writeStringIntoTxt(newUser, "Benutzer.txt");
					Alert mesg = new Alert(AlertType.CONFIRMATION);
					mesg.setContentText("Arzt hinzugefügt");
					mesg.showAndWait();

				}
			}
		}
	}

//Valdierung der TextFelder
	private boolean validateData() {
		Alert msg = new Alert(AlertType.ERROR);
		boolean result = true;
		if (txtSurnameR.getText().equals("")) {
			msg.setContentText("Bitte füllen Sie das Vornamen Feld aus!");
			msg.showAndWait();
			result = false;
		} else {
			if (txtNameR.getText().equals("")) {
				msg.setContentText("Bitte füllen Sie das Nachnamen Feld aus!");
				msg.showAndWait();
				result = false;
			} else {
				if (txtRankR.getText().equals("")) {
					msg.setContentText("Bitte füllen Sie das Rang Feld aus!");
					msg.showAndWait();
					result = false;
				} else {
					if (txtSchoolR.getText().equals("")) {
						msg.setContentText("Bitte füllen Sie das Schule Feld aus!");
						msg.showAndWait();
						result = false;
					} else {
						if (txtDepartmentR.getText().equals("")) {
							msg.setContentText("Bitte füllen Sie das Abteilung Feld aus!");
							msg.showAndWait();
							result = false;
						} else {
							if (txtEmailR.getText().equals("")) {
								msg.setContentText("Bitte füllen Sie das Email Feld aus!");
								msg.showAndWait();
								result = false;
							} else {
								if (txtOriginR.getText().equals("")) {
									msg.setContentText("Bitte füllen Sie das Herkunfts Feld aus!");
									msg.showAndWait();
									result = false;
								} else {
									if (txtLanguagesR.getText().equals("")) {
										msg.setContentText("Bitte füllen Sie das Sprachen Feld aus!");
										msg.showAndWait();
										result = false;
									} else {
										if (txtSpecialityR.getText().equals("")) {
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
	public void goToHauptmenue(ActionEvent event) throws IOException // This method loads a new scene in a current
																		// window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
