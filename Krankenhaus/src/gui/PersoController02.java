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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PersoController02 {
	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente des zweiten Personal-Bildschirms
		@FXML
		Button btnMainmenu;
		@FXML
		TextField txtStaffSurname;
		@FXML
		TextField txtStaffName;
		@FXML
		TextField txtStaffRank;
		@FXML
		TextField txtStaffSchool;
		@FXML
		TextField txtStaffDep;
		@FXML
		Button btnCreateStaff;
		
		
		// Events
		@FXML
		public void goToMainmenu(ActionEvent event) throws IOException // Diese Methode lädt den Hauptmenübildschirm in dem
																		// aktuellen Fenster
		{
			Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		

		// Methode um neues Personal zu erstellen
		@FXML
		public void createStaff(ActionEvent event) throws IOException {
			if (txtStaffRank.getText().equals("Arzt")) {
				String[] arzt = new String[6];
				int lower = 1000;
				int upper = 1999;
				String id = String.valueOf((int) (Math.random() * (upper - lower))) + lower;

				String surname = txtStaffSurname.getText();
				String name = txtStaffName.getText();
				String rank = txtStaffRank.getText();
				String school = txtStaffSchool.getText();
				String department = txtStaffDep.getText();

				arzt[0] = id;
				arzt[1] = surname;
				arzt[2] = name;
				arzt[3] = rank;
				arzt[4] = school;
				arzt[5] = department;
				for (int i = 0; i < arzt.length; i++) {
					arzt[i].trim();
					arzt[i].toString().split(",");

				}				
				Alert mesg = new Alert(AlertType.CONFIRMATION);
				mesg.setContentText("Arzt hinzugefügt");
				mesg.showAndWait();
				application.ReaderWriter.writeStringIntoTxt(Arrays.toString(arzt).split(","), "Arzt.txt");
			} else if (txtStaffRank.getText().equals("Pfleger")) {
				String[] nurse = new String[6];
				int lower = 2000;
				int upper = 2999;

				String id = String.valueOf((int) (Math.random() * (upper - lower) + lower));
				String surname = txtStaffSurname.getText();
				String name = txtStaffName.getText();
				String rank = txtStaffRank.getText();
				String school = txtStaffSchool.getText();
				String department = txtStaffDep.getText();

				nurse[0] = id;
				nurse[1] = surname;
				nurse[2] = name;
				nurse[3] = rank;
				nurse[4] = school;
				nurse[5] = department;

				for (int i = 0; i < nurse.length; i++) {
					nurse[i].trim();
					nurse[i].toString().split(",");
				}
				application.ReaderWriter.writeStringIntoTxt(Arrays.toString(nurse), "Pfleger.txt");

				Alert mesg = new Alert(AlertType.CONFIRMATION);
				mesg.setContentText("nurse hinzugefügt");
				mesg.showAndWait();
			}
		}
}
