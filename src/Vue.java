import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Vue extends JFrame implements Observer {

	File[] images;
	File repertoire;
	JPanel panelCentral, panel1, panel2, panel3;

	public Vue() {
		/* Test avec dossier image */

		this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocationRelativeTo(null);
		// this.setVisible(true);
		this.setTitle("Application");

		this.setLayout(new BorderLayout());

		this.add(new BandeauHaut(), BorderLayout.NORTH);
		this.add(new BandeauLateral(), BorderLayout.WEST);
		this.add(new BandeauCentral());
		// JScrollPane scroll = new JScrollPane(new BandeauCentral(),
		// JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		// JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// this.add(scroll, BorderLayout.CENTER);

		/*
		 * BandeauCentral cent = new BandeauCentral(); BandeauLateral lat = new
		 * BandeauLateral(); JSplitPane split = new
		 * JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cent, lat);
		 * this.getContentPane().add(split, BorderLayout.CENTER);
		 * split.setOneTouchExpandable(true); this.add(cent); this.add(lat);
		 * this.add(split);
		 */

		this.pack();

	}

	void refresh() {

	}

	public static void main(String[] args) {
		Vue app = new Vue();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// rafraichir la fenetre d'affichage

	}

}

class Dialogue extends JDialog {
	JTextField text = new JTextField(10);

	public Dialogue(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		JPanel pan = new JPanel();
		JLabel b = new JLabel("Le tag � ajouter est :");
		text.setPreferredSize(new Dimension(100, 25));
		pan.add(b);
		pan.add(text);
		this.add(pan);
		this.setLocationRelativeTo(null);
		this.setSize(300, 100);
		this.setResizable(false);
		this.setVisible(true);

	}

}

class BandeauCentral extends JPanel {
	String[] couleurs = { "rouge", "bleu", "vert", "noir", "blanc" };

	public BandeauCentral() {

		this.setLayout(new FlowLayout());
		this.setBackground(Color.white);

		File images = new File("images");
		String[] taille_repertoire = images.list();

		for (int i = 0; i < taille_repertoire.length; i++) {

			this.add(new JLabel(new ImageIcon("images/" + taille_repertoire[i])));

			// System.out.println(taille_repertoire[i]);
		}

		this.setVisible(true);

	}

}

class BandeauLateral extends JPanel {
	String[] couleurs = { "rouge", "bleu", "vert", "noir", "blanc" };
	String[] tailles = { "petite image", "image moyenne", " grande image" };
	String[] themes = { "..." };

	BandeauLateral() {
		super();

		this.setLayout(new GridBagLayout());

		/* Creation du boutton pour ajouter un tag */
		JButton AddImage = new JButton("Ajouter un tag");
		AddImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.orange, Color.white));
		AddImage.setBackground(Color.lightGray);
		AddImage.setForeground(Color.WHITE);

		for (int i = 0; i < couleurs.length; i++) {
			JCheckBox liste_couleurs = new JCheckBox(couleurs[i]);
			liste_couleurs.setBounds(85, 300 + 20 * i, 100, 25);
			this.add(liste_couleurs);
			liste_couleurs.setBackground(new Color(255, 235, 204));

		}

		for (int i = 0; i < tailles.length; i++) {
			JCheckBox liste_tailles = new JCheckBox(tailles[i]);
			liste_tailles.setBounds(85, 500 + 20 * i, 100, 25);
			this.add(liste_tailles);
			liste_tailles.setBackground(new Color(255, 235, 204));

		}

		for (int i = 0; i < themes.length; i++) {
			JCheckBox liste_themes = new JCheckBox(themes[i]);
			liste_themes.setBounds(85, 700 + 20 * i, 100, 25);
			this.add(liste_themes);
			liste_themes.setBackground(new Color(255, 235, 204));

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
		this.setBackground(new Color(255, 235, 204));
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

	}

	public void paintComponent(Graphics g) {
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
	}

}

class BandeauHaut extends JPanel {

	BandeauHaut() {
		super();
		this.setBackground(new Color(255, 179, 102));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(0, 100));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
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
		super.paintComponent(g);

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
