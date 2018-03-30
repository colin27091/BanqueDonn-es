import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VUE_BandeauHaut extends JPanel implements Observer{
	
	VUE_BandeauHaut(){
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

	@Override
	public void update(Observable arg0, Object arg1) {	
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
	
	public static void main(String[] args) {
		VUE_BandeauHaut bh = new VUE_BandeauHaut();
		
		

	}

}
