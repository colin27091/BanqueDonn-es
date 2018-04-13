import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class ApplicationFx extends Application {
	Stage VuePrincipale;

	@Override
	public void start(Stage primaryStage) throws IOException {
		VuePrincipale = primaryStage;
		VuePrincipale.setTitle("Banque de gestion d'images");
		Parent loader = FXMLLoader.load(getClass().getResource("XMLApplication.fxml"));
		VuePrincipale.setScene(new Scene(loader));
		VuePrincipale.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
