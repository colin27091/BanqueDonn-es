import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class VUE_BandeauCentral extends JPanel implements Observer {

	VUE_BandeauCentral(){
		
		super();
		this.setBounds(200,200,100,100);
		this.setBackground(Color.gray);
		this.setLayout(null);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	/* Contient les images a afficher en fonction des paramètre de recherche */

}
