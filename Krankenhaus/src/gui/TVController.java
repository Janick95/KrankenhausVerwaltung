package gui;

import java.io.IOException;
import java.util.Arrays;

import application.ReaderWriter;
import application.Sortieren;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	Button btnMainmenu;
	@FXML
	Button btnCreateDate;
	@FXML
	Button btnDeleteDate;
	@FXML
	TextField txtSearchOpDate;
	@FXML
	TextField txtPatSur;
	@FXML
	TextField txtPatName;
	@FXML
	TextField txtDocSur;
	@FXML
	TextField txtDocName;
	@FXML
	TextField txtDocId;
	@FXML
	TextField txtOpReason;
	@FXML
	TextField txtOpDate;
	@FXML
	TextField txtOpId;
	@FXML
	ListView<String> lvOpT = new ListView<String>();
	@FXML
	ComboBox<String> cmbOpDateSort;
	@FXML
	ComboBox<String> cmbOpSearch;
	@FXML
	Button btnOpSearch;

	@FXML
	public void initialize() throws IOException {
		// Sortieren ComboBox Inhalte:
		cmbOpSearch.getItems().removeAll(cmbOpSearch.getItems());
		cmbOpSearch.getItems().addAll("Suchen nach", "ID", "Op-Datum");
		cmbOpSearch.getSelectionModel().select("Suchen nach");
		// Sortieren ComboBox Inhalte:
		cmbOpDateSort.getItems().removeAll(cmbOpDateSort.getItems());
		cmbOpDateSort.getItems().addAll("Sortieren nach", "ID-aufsteigend", "ID-absteigend", "Name-aufsteigend",
				"Name-absteigend", "age-aufsteigend", "age-absteigend", "Aufenthaltsreason-aufsteigend",
				"Aufenthaltsreason-absteigend");
		cmbOpDateSort.getSelectionModel().select("Sortieren nach");
		String[] dates = ReaderWriter.readToArray("Termine.txt");
		showOpList(dates);
	}

	@FXML
	public void showOpList(String[] dates) throws IOException {

		ObservableList<String> date = FXCollections.observableArrayList(dates);
		lvOpT.setItems(date);

	}

	// Events
	@FXML
	public void goToMainmenu(ActionEvent event) throws IOException // This method loads a new scene in a current window
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

	@FXML
	public void opSearch(ActionEvent evt) throws IOException {
		pickSearch();
	}

	// Nach der Auswahl des gewünschten Suchparameters wird der
	// Suchalgorithmus auf das Element angewandt
	@FXML
	public void pickSearch() throws IOException {
		String[] ops1 = ReaderWriter.readToArray("Termine.txt");
		ObservableList<String> opTs = FXCollections.observableArrayList(ops1);
		String search = txtSearchOpDate.getText();
		if (cmbOpSearch.getValue().contains("ID")) {
			String[] sortedOpId1 = Sortieren.sortIDAscending(ops1);
			String searchID = application.Suchen.searchID(search, sortedOpId1);
			opTs = FXCollections.observableArrayList(searchID);
			lvOpT.setItems(opTs);
		} else if (cmbOpSearch.getValue().contains("Op-Datum")) {
			String[] searchOpDate = application.Suchen.searchOperationDate(search, ops1);
			opTs = FXCollections.observableArrayList(searchOpDate);
			lvOpT.setItems(opTs);
		}

	}

	@FXML
	public void erstelleTermin(ActionEvent event) throws IOException {
		String[] opD = new String[8];

		String idDate = txtOpId.getText();

		String patSurname = txtPatSur.getText();
		String patName = txtPatName.getText();

		String idDoc = txtDocId.getText();

		String docSurname = txtDocSur.getText();
		String docName = txtDocName.getText();
		String opReason = txtOpReason.getText();
		String opDate = txtOpDate.getText();

		opD[0] = idDate;
		opD[1] = patSurname;
		opD[2] = patName;
		opD[3] = idDoc;
		opD[4] = docSurname;
		opD[5] = docName;
		opD[6] = opReason;
		opD[7] = opDate;

		String newDate = idDate + "," + patSurname + "," + patName + "," + idDoc + "," + docSurname + "," + docName
				+ "," + opReason + "," + opDate;

		for (int i = 0; i < opD.length; i++) {
			opD[i].trim();
		}
		Alert mesg = new Alert(AlertType.CONFIRMATION);
		mesg.setContentText("Termin hinzugefügt");
		mesg.showAndWait();
		application.ReaderWriter.writeStringIntoTxt(newDate, "Termine.txt");
		lvOpT.getItems();

	}

	// Nach der Auswahl des gewünschten Sortierparameters wird der
	// Sortieralgorithmus auf das Element angewandt
	@FXML
	public void pickSort(ActionEvent event) throws IOException {
		String[] dates1 = ReaderWriter.readToArray("Termine.txt");
		ObservableList<String> date = FXCollections.observableArrayList(dates1);
		lvOpT.getItems();
		if (cmbOpDateSort.getValue().contains("ID-aufsteigend")) {
			String[] sortedID = application.Sortieren.sortIDAscending(dates1);
			date = FXCollections.observableArrayList(sortedID);
			lvOpT.setItems(date);
		} else if (cmbOpDateSort.getValue().contains("ID-absteigend")) {
			String[] sortedID = application.Sortieren.sortIDDescending(dates1);
			date = FXCollections.observableArrayList(sortedID);
			lvOpT.setItems(date);
		} else if (cmbOpDateSort.getValue().contains("Name-aufsteigend")) {
			String[] sortedName = application.Sortieren.sortNameAscending(dates1);
			date = FXCollections.observableArrayList(sortedName);
			lvOpT.setItems(date);
		} else if (cmbOpDateSort.getValue().contains("Name-absteigend")) {
			String[] sortedName = application.Sortieren.sortNameAscending(dates1);
			date = FXCollections.observableArrayList(sortedName);
			lvOpT.setItems(date);
		} else if (cmbOpDateSort.getValue().contains("OpTyp-aufsteigend")) {
			String[] sortedType = application.Sortieren.sortReasonForStayAscending(dates1);
			date = FXCollections.observableArrayList(sortedType);
			lvOpT.setItems(date);
		} else if (cmbOpDateSort.getValue().contains("OpTyp-absteigend")) {
			String[] sortedType = application.Sortieren.sortReasonForStayDescending(dates1);
			date = FXCollections.observableArrayList(sortedType);
			lvOpT.setItems(date);
		}
	}

	@FXML
	// Methode um einen Termin zu löschen
	public void loescheTermin(ActionEvent event) throws IOException {

		String deleteDate = lvOpT.getSelectionModel().getSelectedItem();
		String[] dateDelete = deleteDate.split(",");

		application.ReaderWriter.deleteFromTxt(dateDelete[0], "Termine.txt");

		String[] patients = ReaderWriter.readToArray("Termine.txt");
		showOpList(patients);

	}
}
