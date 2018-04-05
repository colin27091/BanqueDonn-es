import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application extends JFrame {

	File[] images;
	File repertoire;
	JPanel panelCentral,panel1, panel2, panel3;
	

	public Application() {
		
		
		
		
		/*Test avec dossier image*/
		
		
		
		
		this.panelCentral = new JPanel();
		
		
		
		this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Application");
		this.setLayout(new BorderLayout());
		
		this.add(new BandeauHaut(), BorderLayout.NORTH);
		this.add(new BandeauLateral(), BorderLayout.WEST);
		this.add(new BandeauCentral());
		
		
		
		
		this.pack();
		
	}
	
	
	void refresh() {
		
	}
	
	/*void BandeauCentral() {
		this.panelCentral = new JPanel();
		this.add(this.panelCentral);
		this.panelCentral.add(new JLabel(new ImageIcon("images/3d_file.png")));
		
	}*/
	
	
	public static void main(String[] args) {
		Application app = new Application();
	}

}

class BandeauCentral extends JPanel{
	public BandeauCentral() {
		this.add(new JLabel(new ImageIcon("images/3d_file.png")));
	}
	
}




class BandeauLateral extends JPanel{
	String[] couleurs= {"rouge", "bleu", "vert", "noir" , "blanc" };
	String[] tailles = {"petite image", "image moyenne" , " grande image"};
	String[] themes = {"..."};
	
	BandeauLateral(){
		super();
		JButton AddImage = new JButton("Ajouter une image");
		AddImage.setBackground(new Color(51,204,255));
		AddImage.setForeground(Color.WHITE);
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
		
		
		
		this.add(new JLabel(new ImageIcon("images/3d_file.png")));
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
	
}


class BandeauHaut extends JPanel{
	
	
	BandeauHaut(){
		super();
		this.setPreferredSize(new Dimension(0,50));
		
		
		JButton setting_button = new JButton( /*Icon icon ...*/);
		/*partie courespoondante au bouton parametre
		 * addActionListener
		 */
		
		
		JButton logo = new JButton(/*Icon icon ...*/);
		/*partie correspondante au boutant du logo
		 * quand on clique dessus, une nouvelle fenetre s'ouvre comme un lancement parallèle
		 * addActionListener
		 */
		
		
		//this.add(setting_button);
		//this.add(logo);
	
	}

	
	
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("logo.png"));
			/* Le logo est trop grand pour être afficher , je changerait ça ce week-end */
			g.drawImage(img,0,0, this);
			Font font = new Font("Arial", Font.ITALIC, 18);
			g.setFont(font);
			g.setColor(Color.blue);
			g.drawString("Projet Java",getWidth()/2 , 30);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}











