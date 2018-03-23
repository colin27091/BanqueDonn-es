import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	File[] images;
	File repertoire;
	JPanel panel1, panel2, panel3;

	public Fenetre() {
		this.setVisible(true);// construction de la frame
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		this.panel1 = new JPanel(); // panel1 bandeau du haut
		this.panel1.setBounds(0, 0, this.getWidth(), this.getHeight() / 15);
		this.panel1.setBackground(Color.orange);
		this.panel1.setLayout(null);

		this.panel2 = new JPanel(); // panel2 bandeau cote
		this.panel2.setBounds(0, this.getHeight() / 15, this.getWidth() / 5, this.getHeight());
		this.panel2.setBackground(Color.blue);
		this.panel2.setLayout(null);

		this.panel3 = new JPanel(); // panel3 panel central (contenant les
									// image)
		this.panel3.setBounds(this.getWidth() / 5, this.getHeight() / 15, this.getWidth() - this.getWidth() / 5,
				this.getHeight() - this.getHeight() / 15);
		this.panel3.setBackground(Color.gray);
		this.panel3.setLayout(null);

		this.repertoire = new File("/home/cregourd/Documents/projetjava/images");
		images = repertoire.listFiles();

		JLabel label1 = new JLabel(new ImageIcon(images[0].toString()));

		this.panel3.add(label1);

		
		 this.add(this.panel1); this.add(this.panel2); this.add(this.panel3);
		 

	}

	public void paint(Graphics g)  {

		Image img1 = ImageIO.read(images[0]);
		g.drawImage(img1, 50, 50, panel3);

	}

	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre();

	}

}
