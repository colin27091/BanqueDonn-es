import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PanelLateral extends JPanel {

	String[] couleurs = { "rouge", "bleu", "vert", "noir", "blanc" };
	String[] tailles = { "petite image", "image moyenne", " grande image" };
	String[] themes = { "..." };

	private static final long serialVersionUID = 1L;

	PanelLateral() {
		super();
		
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.add(new JButton("Bonjour"));
		
		this.setLayout(new GridBagLayout());

		/* Creation du boutton pour ajouter un tag */
		JButton AddImage = new JButton("Ajouter un tag");
		AddImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new Color(255, 166, 77), Color.white));
		AddImage.setBackground(Color.lightGray);
		AddImage.setForeground(Color.WHITE);

		for (int i = 0; i < couleurs.length; i++) {
			JCheckBox liste_couleurs = new JCheckBox(couleurs[i]);
			liste_couleurs.setBounds(85, 300 + 20 * i, 100, 25);
			this.add(liste_couleurs);
			liste_couleurs.setBackground(new Color(255, 223, 183));

		}

		for (int i = 0; i < tailles.length; i++) {
			JCheckBox liste_tailles = new JCheckBox(tailles[i]);
			liste_tailles.setBounds(85, 500 + 20 * i, 100, 25);
			this.add(liste_tailles);
			liste_tailles.setBackground(new Color(255, 223, 183));

		}

		for (int i = 0; i < themes.length; i++) {
			JCheckBox liste_themes = new JCheckBox(themes[i]);
			liste_themes.setBounds(85, 700 + 20 * i, 100, 25);
			this.add(liste_themes);
			liste_themes.setBackground(new Color(255, 223, 183));

		}
		JComboBox liste_tailles = new JComboBox(tailles);
		JComboBox liste_themes = new JComboBox(themes);
		AddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialogue d = new Dialogue(null, "Entrer le tag a ajouter", true);
			}

		});

		JLabel tag_search = new JLabel("Rechercher un tag :");
		JTextField text = new JTextField(10);
		this.add(tag_search);
		this.add(text);
		this.setBackground(new Color(255, 223, 183));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(300, 0));
		this.setLayout(null);
		this.add(AddImage);
		this.add(liste_tailles);
		this.add(liste_themes);

		/*
		 * liste_couleurs.setPreferredSize(new Dimension(100, 20));
		 * liste_tailles.setPreferredSize(new Dimension(100, 20));
		 * liste_themes.setPreferredSize(new Dimension(100, 20));
		 */

		tag_search.setBounds(80, 180, 150, 25);
		text.setBounds(85, 200, 100, 25);
		AddImage.setBounds(25, 50, 250, 80);
		// liste_couleurs.setBounds(85,300,100,25);
		/* Contient les bouton de recherche */
		
		/*public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Font font_couleur = new Font("Arial", Font.BOLD, 14);
			g.setFont(font_couleur);
			g.drawString("Choisir une couleur", 60, 280);

			Font font_taille = new Font("Arial", Font.BOLD, 14);
			g.setFont(font_taille);
			g.drawString("Choisir une taille", 60, 480);

			Font font_theme = new Font("Arial", Font.BOLD, 14);
			g.setFont(font_theme);
			g.drawString("Choisir un theme", 60, 680);
		}*/

	}

}
