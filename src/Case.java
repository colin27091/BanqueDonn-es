import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Case extends JPanel {

	private static final long serialVersionUID = 1L;

	Case(Pic pic) {
		super();

		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.orange));

		this.add(new JLabel(pic.image), BorderLayout.NORTH);
		this.add(new JLabel(pic.name, SwingConstants.CENTER), BorderLayout.SOUTH);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}
