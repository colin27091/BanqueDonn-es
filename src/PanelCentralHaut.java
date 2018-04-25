import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelCentralHaut extends JPanel {
	
	String[] affichages = {"Petites icones", "Grande icones", "Mosaïque"};
	
	private static final long serialVersionUID = 1L;

	PanelCentralHaut(){
		super();
		
		this.setLayout(new BorderLayout());
		
		
		JLabel AffichePar = new JLabel("Afficher par :");
		
		JButton zoomIn = new JButton("");
		JButton zoomOut = new JButton("");
		zoomIn.setIcon(new ImageIcon("zoom-in.png"));
		zoomOut.setIcon( new ImageIcon("zoom-out.png"));
		zoomIn.setPreferredSize(new Dimension(25,25));
		zoomOut.setPreferredSize(new Dimension(25,25));
		zoomIn.setBounds(1094,0,25,26);
		zoomOut.setBounds(1120,0,30,26);
		zoomIn.setBackground(new Color(255, 223, 183));
		zoomOut.setBackground(new Color(255, 223, 183));
		
		AffichePar.setBounds(1180,0,100,28);
		JComboBox<String> aff = new JComboBox<String>(affichages);
		aff.setSelectedIndex(0);
		aff.setBackground(new Color(255, 223, 183));
		this.setBackground(new Color(255, 223, 183));
		this.add(AffichePar,BorderLayout.EAST);
		this.add(zoomIn, BorderLayout.EAST);
		this.add(zoomOut, BorderLayout.EAST);
		this.add(aff, BorderLayout.EAST);
		
	}

}
