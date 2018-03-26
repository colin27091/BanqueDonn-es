import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class VUE_BandeauLateral extends JPanel implements Observer{

	VUE_BandeauLateral(){
		super();
		this.setPreferredSize(new Dimension(300,0));
		this.setBackground(Color.blue);
		this.setLayout(null);
		
		
		/*Contient les bouton de recherche*/
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
