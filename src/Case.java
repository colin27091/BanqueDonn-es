import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.stage.Stage;

public class Case extends Application {

	Pic picture;

	Case(Pic picture) {
		this.picture = picture;
	}
	
	public static void main(String[] appfx) {
		launch(appfx);

	}
	
	public void start(Stage stage) {
	}

}

class CanvasTest extends JFrame {

	CanvasTest() {
		this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Application");
		this.setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		//jp.add(new Case(new Pic(new File("logo.png"))));
		
		
		this.add(jp);
		
		
		
		this.pack();
	}

}
