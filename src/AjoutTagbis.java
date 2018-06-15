import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AjoutTagbis extends JFrame implements ActionListener {
	
	private javax.swing.JButton apply_button;
    private javax.swing.JButton cancel_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tag_area;
    
    ArrayList<Pic> pics;
    Control ctr;
    
    
    AjoutTagbis(ArrayList<Pic> pics, Control ctr){
    	this.pics = pics;
    	this.ctr = ctr;
    	this.setVisible(true);
    	this.setTitle("Ajout d'un tag");
    	initComponents();
    }
	
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        apply_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        tag_area = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());
        
        
        for (int i = 0; i < this.pics.size(); i++) {
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = i % 4;
			c.insets = new Insets(10, 10, 10, 10);
			
			JLabel scroll = new JLabel();
			scroll.setBackground(Color.green);

			scroll.add(new JLabel(this.pics.get(i).image), c);
			
			this.jScrollPane2.add(scroll);

		}

        apply_button.setText("Appliquer");
        apply_button.setActionCommand("apply_button");
        apply_button.addActionListener(this /*controleur*/);

        cancel_button.setText("Annuler");
        cancel_button.setActionCommand("cancel"
        		+ "_button");
        cancel_button.addActionListener(this /*controleur*/);

        tag_area.setText("Votre Tag");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tag_area, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apply_button, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apply_button)
                    .addComponent(cancel_button)
                    .addComponent(tag_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "cancel_button") {
			dispose();
		}
		
		if(e.getActionCommand() == "apply_button") {
			dispose();
			this.ctr.model.addTag(tag_area.getText(), pics);
			
		}
		
	}

}
