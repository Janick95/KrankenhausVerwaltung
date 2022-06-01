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
        Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Willkommen im River Krankenhaus");
        primaryStage.getIcons().add(new Image ("/img/Icon.jpg"));
        primaryStage.show();
		
		
		
		
		
		/**try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml"));
			
			Scene scene = new Scene (root, 1920, 1080);
			
			stage.setTitle("Willkommen im River Hospital");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}**/
	}
	
	public static void main(String[] args) throws IOException {
		
		//Test/Beispiel Daten auslesen
		String [] text = ReaderWriter.readToArray("Patienten.txt");
		
		for(int i = 0; i < text.length; i++) {
		System.out.println(text[i]);
		}

		
		//Test/Beispiel Daten reinschreiben
		String testtext = "Haben Sie schon probiert ihren Rechner neu zu starten?";
		
		ReaderWriter.writeStringIntoTxt(testtext, "Test.txt");
		
		launch(args);
	}
}
