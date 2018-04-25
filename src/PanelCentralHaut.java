import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelCentralHaut extends JPanel {
	
	String[] affichages = {"Affichage1", "Affichage2", "Affichage3"};
	
	private static final long serialVersionUID = 1L;

	PanelCentralHaut(){
		super();
		
		this.setLayout(new BorderLayout());
		
		this.setBorder(BorderFactory.createLineBorder(Color.red));
		
	
		JComboBox<String> aff = new JComboBox<String>(affichages);
		aff.setSelectedIndex(0);
		
		this.add(aff, BorderLayout.EAST);
	}

}
