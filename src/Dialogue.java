import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dialogue extends JDialog {

	private static final long serialVersionUID = 1L;

	JTextField text = new JTextField(10);

	public Dialogue(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		JPanel pan = new JPanel();
		JLabel b = new JLabel("Le tag � ajouter est :");
		text.setPreferredSize(new Dimension(100, 25));
		pan.add(b);
		pan.add(text);
		this.add(pan);
		this.setLocationRelativeTo(null);
		this.setSize(300, 100);
		this.setResizable(false);
		this.setVisible(true);

	}
}
