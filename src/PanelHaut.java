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
		this.setBackground(new Color(255, 166, 77));
		this.setLayout(new BorderLayout());
		
		
		this.add(new JLabel(new ImageIcon("logobis.png")));

		JButton logo = new JButton(/* Icon icon ... */);
		/*
		 * partie correspondante au boutant du logo quand on clique dessus, une nouvelle
		 * fenetre s'ouvre comme un lancement parallèle addActionListener
		 */

		// this.add(setting_button);
		// this.add(logo);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

}
