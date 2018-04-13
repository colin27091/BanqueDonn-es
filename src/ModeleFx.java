import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ModeleFx extends AnchorPane{
	@FXML
	Button b1;

	public void initialize() {
		
	}
	
	public ModeleFx() {
        GridPane gridpane = new GridPane();
		ImageView image = new ImageView(new Image(ModeleFx.class.getResourceAsStream("images/3d_file.png")));
		image.setPreserveRatio(true);
		gridpane.add(image, 1, 0);
		
        this.getChildren().add(gridpane);
		
	}
	
	
}
