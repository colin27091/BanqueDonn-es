import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VUE_BandeauHaut extends JPanel implements Observer{
	
	VUE_BandeauHaut(){
		super();
		this.setPreferredSize(new Dimension(0,50));
		this.setBackground(Color.orange);
		
		
		
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
	
	public static void main(String[] args) {
		VUE_BandeauHaut bh = new VUE_BandeauHaut();
		
		

	}

}
