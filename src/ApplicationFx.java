import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;


public class ApplicationFx extends Application {
	
	ArrayList<Pic> pics;
	Stage VuePrincipale;
	AnchorPane panel1;

	public ApplicationFx() {
		this.pics = Pic.fromFiles(new File("images/").listFiles());
	}
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("XMLApplication.fxml"));
		File input = new File("C:/Users/Quentin/Documents/projetjava/images/3d_file.png");
		String localUrl = input.toURI().toURL().toString();
        Image image = new Image(localUrl);
        ImageView imageView = new ImageView(image);
        AnchorPane panel1 = new AnchorPane();
        panel1.getChildren().addAll(imageView);	
        VuePrincipale = primaryStage;
		VuePrincipale.setTitle("Banque de gestion d'images");
		VuePrincipale.setScene(new Scene(loader));
		VuePrincipale.show();
		
 
	}

	public static void main(String[] args) {
		ApplicationFx app = new ApplicationFx();
		System.out.println(app.pics.get(0));
		launch(args);
	}
}
