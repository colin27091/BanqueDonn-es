import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Case extends JComponent {

	Pic picture;

	Case(Pic picture) {
		this.picture = picture;
	}

	public void paint(Graphics g) {
	}

	public static void main(String[] args) {
		new CanvasTest();

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
