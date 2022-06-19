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
		Parent root = FXMLLoader.load(getClass().getResource("/gui/AnmeldeScreen.fxml")); // hier wird die fxml
																							// Datei geladen
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Willkommen im River Krankenhaus");// Titel des Fensters
		primaryStage.getIcons().add(new Image("/img/Icon.jpg")); // Diese Zeile zur Not auskommentieren, da es hier
																	// evtl. zu Konflikten mit der gelöschten
																	// Module-info.java gibt
		primaryStage.show();
	}

	public static void main(String[] args) throws IOException {
		launch(args);
	}
}
