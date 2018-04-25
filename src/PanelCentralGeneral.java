import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCentralGeneral extends JPanel {
	
	ArrayList<Pic> images;

	private static final long serialVersionUID = 1L;

	PanelCentralGeneral() {
		super();
		
		this.images = Pic.fromFiles(new File("images/").listFiles());
		
		this.setLayout(new GridBagLayout());
		
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		for(int i = 0; i < images.size(); i++) {
		
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = i%5;
			c.gridy = i/5;
			c.insets = new Insets(10,10,10,10);
			
			this.add(new Case(images.get(i)), c);
			
		}

	}

}
