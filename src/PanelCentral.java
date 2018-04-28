import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class PanelCentral extends JPanel {

	private static final long serialVersionUID = 1L;

	PanelCentral() {
	
		super();
		
		this.setLayout(new BorderLayout());
		
		/*this.add(new JPanel());
		this.add(new LabelCentralHaut(), BorderLayout.NORTH);
		this.add(new ScrollPane());*/
		
		this.add(new PanelCentralHautBis(), BorderLayout.NORTH);
		JScrollPane scroll = new JScrollPane(new PanelCentralGeneral());
		this.add(scroll);
		scroll.getVerticalScrollBar().setUnitIncrement(15);

		
		
		
	}

}
