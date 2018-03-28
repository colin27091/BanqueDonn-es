import java.awt.BorderLayout;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application extends JFrame {

	File[] images;
	File repertoire;
	JPanel panel,panel1, panel2, panel3;

	public Application() {
		
		
		this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Application");
		this.setLayout(new BorderLayout());
	
		this.add(new VUE_BandeauHaut(), BorderLayout.NORTH);
		this.add(new VUE_BandeauLateral(), BorderLayout.WEST);
		this.add(new VUE_BandeauCentral());
		this.pack();
		
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		System.out.println(app.getSize());
	}

}
