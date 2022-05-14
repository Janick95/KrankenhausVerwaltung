package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml"));
			
			Scene scene = new Scene (root, 1920, 1080);
			
			stage.setTitle("Willkommen im River Hospital");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		PersonenVerwaltung.zeigePersonalListe();

		launch(args);
	}
}
