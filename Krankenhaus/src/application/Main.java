package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {

	public static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml")); //hier wird die fxml Datei geladen
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Willkommen im River Krankenhaus");//Titel des Fensters
       // primaryStage.getIcons().add(new Image ("/img/Icon.jpg")); //Eigentlich sollte hier das Explorer Icon gesetzt werden, allerdings führt dies seit der Integrierung der module-info.java zu Fehlern  
        primaryStage.show();
	}





	public static void main(String[] args) throws IOException {
//		PersonenVerwaltung.zeigePersonalListe();


		//Test/Beispiel Daten reinschreiben
		//String testtext = "Donut";
		//ReaderWriter.writeStringIntoTxt(testtext, "Test.txt");
		
		//Test/Beispiel Daten löschen
		//ReaderWriter.deleteFromTxt(testtext, "Test.txt");
		
		//Test Daten löschen
		//ReaderWriter.deleteFromTxt(testtext, "Test.txt");
		
		
		
		//Test/Beispiel Sortieren
		/*String[] patients = ReaderWriter.readToArray("Patienten.txt");
		String[] nurses = ReaderWriter.readToArray("Pfleger.txt");
		String[] doctors = ReaderWriter.readToArray("Arzt.txt");
		String[] rooms = ReaderWriter.readToArray("Räume.txt");
		String[] meetings = ReaderWriter.readToArray("Termine.txt");
		
		
		String[] sortedPatients1 = Sortieren.sortIDAscending(patients);
		String[] sortedPatients2 = Sortieren.sortIDDescending(patients);*/
		/*String[] sortedPatients3 = Sortieren.sortNameAscending(patients);
		String[] sortedPatients4 = Sortieren.sortNameDescending(patients);
		String[] sortedPatients5 = Sortieren.sortAgeAscending(patients);
		String[] sortedPatients6 = Sortieren.sortAgeDescending(patients);
		String[] sortedPatients7 = Sortieren.sortReasonForStayAscending(patients);
		String[] sortedPatients8 = Sortieren.sortReasonForStayDescending(patients);
		
		String[] sortedNurses1 = Sortieren.sortIDAscending(nurses);
		String[] sortedNurses2 = Sortieren.sortIDDescending(nurses);
		String[] sortedNurses3 = Sortieren.sortNameAscending(nurses);
		String[] sortedNurses4 = Sortieren.sortNameDescending(nurses);
		
		String[] sortedDoctors1 = Sortieren.sortIDAscending(doctors);
		String[] sortedDoctors2 = Sortieren.sortIDDescending(doctors);
		String[] sortedDoctors3 = Sortieren.sortNameAscending(doctors);
		String[] sortedDoctors4 = Sortieren.sortNameDescending(doctors);
		String[] sortedDoctors5 = Sortieren.sortSpecialFieldAscending(doctors);
		String[] sortedDoctors6 = Sortieren.sortSpecialFieldDescending(doctors);
		
		String[] sortedRooms1 = Sortieren.sortIDAscending(rooms);
		String[] sortedRooms2 = Sortieren.sortIDDescending(rooms);
		
		String[] sortedMeetings1 = Sortieren.sortIDAscending(meetings);
		String[] sortedMeetings2 = Sortieren.sortIDDescending(meetings);
		String[] sortedMeetings3 = Sortieren.sortOperationDateAscending(meetings);
		*/
		
		/*System.out.println("IDAs");
		for(int i = 0; i < sortedPatients1.length; i++) {
			System.out.println(sortedPatients1[i]);
		}
		System.out.println("");
		System.out.println("IDDes");
		for(int i = 0; i < sortedPatients2.length; i++) {
			System.out.println(sortedPatients2[i]);
		}
		System.out.println("");
		System.out.println("NameAs");
		for(int i = 0; i < sortedPatients3.length; i++) {
			System.out.println(sortedPatients3[i]);
		}
		System.out.println("");
		System.out.println("NameDes");*/
		/*for(int i = 0; i < sortedPatients4.length; i++) {
			System.out.println(sortedPatients4[i]);
		}
		System.out.println("");
		System.out.println("AgeAs");
		for(int i = 0; i < sortedPatients5.length; i++) {
			System.out.println(sortedPatients5[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedPatients6.length; i++) {
			System.out.println(sortedPatients6[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedPatients7.length; i++) {
			System.out.println(sortedPatients7[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedPatients8.length; i++) {
			System.out.println(sortedPatients8[i]);
		}
		System.out.println("");
		
		
		for(int i = 0; i < sortedNurses1.length; i++) {
			System.out.println(sortedNurses1[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedNurses2.length; i++) {
			System.out.println(sortedNurses2[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedNurses3.length; i++) {
			System.out.println(sortedNurses3[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedNurses4.length; i++) {
			System.out.println(sortedNurses4[i]);
		}
		System.out.println("");
		
		
		for(int i = 0; i < sortedDoctors1.length; i++) {
			System.out.println(sortedDoctors1[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedDoctors2.length; i++) {
			System.out.println(sortedDoctors2[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedDoctors3.length; i++) {
			System.out.println(sortedDoctors3[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedDoctors4.length; i++) {
			System.out.println(sortedDoctors4[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedDoctors5.length; i++) {
			System.out.println(sortedDoctors5[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedDoctors6.length; i++) {
			System.out.println(sortedDoctors6[i]);
		}
		System.out.println("");
		
		
		for(int i = 0; i < sortedRooms1.length; i++) {
			System.out.println(sortedRooms1[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedRooms2.length; i++) {
			System.out.println(sortedRooms2[i]);
		}
		System.out.println("");
		
		
		for(int i = 0; i < sortedMeetings1.length; i++) {
			System.out.println(sortedMeetings1[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedMeetings2.length; i++) {
			System.out.println(sortedMeetings2[i]);
		}
		System.out.println("");
		for(int i = 0; i < sortedMeetings3.length; i++) {
			System.out.println(sortedMeetings3[i]);
		}
		System.out.println("");
		*/
		
		

		//Test/Beispiel Suchen
		/*String[] patients = ReaderWriter.readToArray("Patienten.txt");
		String[] nurses = ReaderWriter.readToArray("Pfleger.txt");
		String[] doctors = ReaderWriter.readToArray("Arzt.txt");
		String[] rooms = ReaderWriter.readToArray("Räume.txt");
		String[] meetings = ReaderWriter.readToArray("Termine.txt");
		
		String[] sortedPatients1 = Sortieren.sortIDAscending(patients);
		String[] sortedNurses1 = Sortieren.sortIDAscending(nurses);
		String[] sortedDoctors1 = Sortieren.sortIDAscending(doctors);
		String[] sortedRooms1 = Sortieren.sortIDAscending(rooms);
		String[] sortedMeetings1 = Sortieren.sortIDAscending(meetings);
		
		String searchedPatients1 = Suchen.searchID("3512", sortedPatients1);
		String[] searchedPatients2 = Suchen.searchFirstName("Robin", patients);
		String[] searchedPatients3 = Suchen.searchLastName("Schmidt", patients);
		String[] searchedPatients4 = Suchen.searchReasonForStay("Herzprobleme", patients);
		
		String searchedNurses1 = Suchen.searchID("2730", sortedNurses1);
		String[] searchedNurses2 = Suchen.searchFirstName("Sibylle", nurses);
		String[] searchedNurses3 = Suchen.searchLastName("Meyer", nurses);
		String[] searchedNurses4 = Suchen.searchLastName("Travnik", nurses);
		
		String searchedDoctors1 = Suchen.searchID("1611", sortedDoctors1);
		String[] searchedDoctors2 = Suchen.searchFirstName("Julia", doctors);
		String[] searchedDoctors3 = Suchen.searchLastName("Falk", doctors);
		String[] searchedDoctors4 = Suchen.searchSpecialField("Anästhesie", doctors);
		
		String searchedRooms1 = Suchen.searchID("4434",sortedRooms1);
		String[] searchedRooms2 = Suchen.searchFreeRooms(rooms);
		
		String searchedMeetings1 = Suchen.searchID("5028",sortedMeetings1);
		String[] searchedMeetings2 = Suchen.searchOperationDate("01,07,2022",meetings);
		
		System.out.println("Patienten");
		System.out.println(searchedPatients1);
		System.out.println();
		for(int i = 0; i < searchedPatients2.length; i++) {
		System.out.println(searchedPatients2[i]);
		}
		System.out.println();
		for(int i = 0; i < searchedPatients3.length; i++) {
		System.out.println(searchedPatients3[i]);
		}
		System.out.println();
		for(int i = 0; i < searchedPatients4.length; i++) {
		System.out.println(searchedPatients4[i]);
		}
		System.out.println();
		System.out.println("Pfleger");
		System.out.println(searchedNurses1);
		System.out.println();
		for(int i = 0; i < searchedNurses2.length; i++) {
		System.out.println(searchedNurses2[i]);
		}
		System.out.println();
		for(int i = 0; i < searchedNurses3.length; i++) {
		System.out.println(searchedNurses3[i]);
		}
		System.out.println();
		for(int i = 0; i < searchedNurses4.length; i++) {
		System.out.println(searchedNurses4[i]);
		}
		System.out.println();
		System.out.println("Ärzte");
		System.out.println(searchedDoctors1);
		System.out.println();
		for(int i = 0; i < searchedDoctors2.length; i++) {
			System.out.println(searchedDoctors2[i]);
		}
		System.out.println();
		for(int i = 0; i < searchedDoctors3.length; i++) {
			System.out.println(searchedDoctors3[i]);
		}
		System.out.println();
		for(int i = 0; i < searchedDoctors4.length; i++) {
			System.out.println(searchedDoctors4[i]);
		}
		System.out.println();
		System.out.println("Räume");
		System.out.println(searchedRooms1);
		System.out.println();
		for(int i = 0; i < searchedRooms2.length; i++) {
			System.out.println(searchedRooms2[i]);
		}
		System.out.println();
		System.out.println("Termine");
		System.out.println(searchedMeetings1);
		System.out.println();
		for(int i = 0; i < searchedMeetings2.length; i++) {
			System.out.println(searchedMeetings2[i]);
		}
		System.out.println();
		*/
		
		launch(args);
	}
}
