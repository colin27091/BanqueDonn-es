import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHaut extends JPanel {

	private static final long serialVersionUID = 1L;

	PanelHaut() {
		this.setBackground(Color.lightGray);
		this.setLayout(new BorderLayout());

		/* Creation boutton setting */
		JButton setting_bt = new JButton();
		try {
			setting_bt.setIcon(new ImageIcon("Button/setting_bt.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		setting_bt.setBackground(Color.lightGray);
		setting_bt.setBorder(null);
		setting_bt.setMargin(new Insets(10,10,10,10));
		this.add(setting_bt, BorderLayout.EAST);
		
		
		JButton refresh = new JButton("");
		refresh.setIcon(new ImageIcon("refresh.png"));
		refresh.setPreferredSize(new Dimension(40, 40));
		refresh.setBounds(1870, 5, 40, 40);
		this.add(refresh, BorderLayout.EAST);

		JButton setting_button = new JButton( /* Icon icon ... */);
		/*
		 * partie courespoondante au bouton parametre addActionListener
		 */

		JButton logo = new JButton(/* Icon icon ... */);
		/*
		 * partie correspondante au boutant du logo quand on clique dessus, une nouvelle
		 * fenetre s'ouvre comme un lancement parallèle addActionListener
		 */

		// this.add(setting_button);
		// this.add(logo);

	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("logo.png"));

			/* Le logo est trop grand pour être afficher , je changerait ça ce week-end */
			g.drawImage(img, 0, 0, this);
			Font font = new Font("Arial", Font.ITALIC, 18);
			g.setFont(font);
			g.setColor(Color.blue);
			g.drawString("Projet Java", getWidth() / 2, 30);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
