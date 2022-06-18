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
        Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml")); //hier wird die fxml Datei geladen
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
		
		//Test/Beispiel mergeSort
		//String[] patienten = ReaderWriter.readToArray("Patienten.txt");
		
		
		///////////////////////////////////////////////////////////////////////////
		/*String[] arzt = ReaderWriter.readToArray("Arzt.txt");
		//String[] test = ReaderWriter.readToArray("Test.txt");
		
		String[] sorted = Sortieren.sortSpecialFieldAscending(arzt);
		
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}*/
		///////////////////////////////////////////////////////////////////////////
		
		/*String[] sorted2 = Sortieren.sortIDDescending(patienten);
		
		for(int i = 0; i < sorted2.length; i++) {
			System.out.println(sorted2[i]);
		}*/
		
		//Test Daten löschen
		//ReaderWriter.deleteFromTxt(testtext, "Test.txt");
		
		
		/*String[] test = new String[10];
		test[0] = "Haus";
		test[1] = "Hund";
		test[2] = "Blume";
		test[3] = "Pizza";
		test[4] = "Auto";
		test[5] = "mehr Pizza";
		test[6] = "PC";
		test[7] = "Mathe";
		test[8] = "Pc";
		test[9] = "Uni";
		System.out.println("");
				
		for(int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
		Sortieren.sortiereAlphabetisch(test);
		for(int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}*/
		

		//Test/Beispiel Suchen
		String[] patienten = ReaderWriter.readToArray("Patienten.txt");
		
		String[] sorted = Sortieren.sortIDAscending(patienten);
		
		String[] searched = Suchen.searchReasonForStay("Corona", sorted);
		
		for(int i = 0; i < searched.length; i++) {
		System.out.println(searched[i]);
		}
		
		launch(args);
	}
}
