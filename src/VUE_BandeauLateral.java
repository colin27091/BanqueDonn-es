import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class VUE_BandeauLateral extends JPanel implements Observer{
	String[] couleurs= {"rouge", "bleu", "vert", "noir" , "blanc" };
	String[] tailles = {"petite image", "image moyenne" , " grande image"};
	String[] themes = {"..."};
	VUE_BandeauLateral(){
		super();
		JButton AddImage = new JButton("Ajouter une image");
		JComboBox liste_couleurs = new JComboBox(couleurs);
		JComboBox liste_tailles = new JComboBox(tailles);
		JComboBox liste_themes = new JComboBox(themes);


		/* this.setBorder(BorderFactory.createLineBorder(Color.black));*/
		this.setPreferredSize(new Dimension(300,0));
		this.setLayout(null);
		this.add(AddImage);
		this.add(liste_couleurs);
		this.add(liste_tailles);
		this.add(liste_themes);
		
		
		liste_couleurs.setPreferredSize(new Dimension(100, 20));
		liste_tailles.setPreferredSize(new Dimension(100, 20));
		liste_themes.setPreferredSize(new Dimension(100, 20));
		
		AddImage.setBounds(25, 50, 250, 80);
		liste_couleurs.setBounds(85,300,100,25);
		liste_tailles.setBounds(85,400,100,25);
		liste_themes.setBounds(85,500,100,25);
		/*Contient les bouton de recherche*/
	}

	
	public void paintComponent(Graphics g){
		Font font_couleur = new Font("Arial", Font.BOLD, 14);
		g.setFont(font_couleur);
		g.drawString("Choisir une couleur",60 , 280);
		
		Font font_taille = new Font("Arial", Font.BOLD, 14);
		g.setFont(font_taille);
		g.drawString("Choisir une taille",60 , 380);
		
		Font font_theme = new Font("Arial", Font.BOLD, 14);
		g.setFont(font_theme);
		g.drawString("Choisir un theme",60 , 480);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
