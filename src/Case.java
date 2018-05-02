import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Case extends JPanel {

        Pic pic;
        JCheckBox selection;
        JLabel image;
        JLabel nom;
    
	private static final long serialVersionUID = 1L;

	Case(Pic pic) {
		super();
                this.pic = pic;
                this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(new Color(255, 166, 77)));
		this.setBackground(Color.white);
               
                image = new JLabel(pic.image, SwingConstants.CENTER);
                
                
                
                nom = new JLabel(pic.name);
                
                
                selection = new JCheckBox();
                selection.setBackground(null);
                
                this.add(selection, BorderLayout.NORTH);
		this.add(image);
		this.add(nom, BorderLayout.SOUTH);


	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
        
        static ArrayList<Case> fromPics(ArrayList<Pic> pics){
            ArrayList<Case> cases = new ArrayList<Case>();
            for(Pic pic : pics){
                cases.add(new Case(pic));
            }
            return cases;
        }

}
