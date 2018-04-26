import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Vue extends JFrame implements Observer {

	File[] images;
	File repertoire;
	JPanel panelCentral, panel1, panel2, panel3;

	public Vue() {
		this.setTitle("Banque de données");
		this.setVisible(true);
		this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());


		this.add(new PanelHaut(), BorderLayout.NORTH);
		// this.add(new PanelLateral(), BorderLayout.WEST);
		// this.add(new PanelCentral());
		this.add(new JSplitPane(1, new PanelLateralBis(), new PanelCentral()));

		this.pack();

	}

	void refresh() {

	}

	public static void main(String[] args) {
		Vue app = new Vue();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// rafraichir la fenetre d'affichage

	}

}
