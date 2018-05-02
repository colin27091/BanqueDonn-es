
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author colin
 */
public class Pane extends javax.swing.JPanel {

   
     
    public Pane() {
        initComponents(); 
    }

    public void setPics(ArrayList<Case> cases){
    	
		for (int i = 0; i < cases.size(); i++) {

			GridBagConstraints c = new GridBagConstraints();
			c.gridx = i % 5;
			c.gridy = i / 5;
			c.insets = new Insets(10, 10, 10, 10);

			this.PanelGeneral.add(cases.get(i), c);

		}
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHaut = new javax.swing.JPanel();
        PanelCentral = new javax.swing.JPanel();
        PanelHaut2 = new javax.swing.JPanel();
        Add_Tag = new javax.swing.JButton();
        Supp = new javax.swing.JButton();
        All_select = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Add_folder = new javax.swing.JButton();
        SplitCentral = new javax.swing.JSplitPane();
        PanelLateral = new javax.swing.JPanel();
        recherche = new javax.swing.JTextField();
        nom = new javax.swing.JButton();
        tag = new javax.swing.JButton();
        Filtre_tri = new javax.swing.JTabbedPane();
        Tri = new javax.swing.JPanel();
        TriPar = new javax.swing.JComboBox<>();
        Croisant_dec = new javax.swing.JComboBox<>();
        Filtrage = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Aplliquer = new javax.swing.JButton();
        Remove_choice = new javax.swing.JButton();
        PanelGeneral = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

        setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        setLayout(new java.awt.BorderLayout());

        PanelHaut.setBackground(new java.awt.Color(226, 134, 90));

        javax.swing.GroupLayout PanelHautLayout = new javax.swing.GroupLayout(PanelHaut);
        PanelHaut.setLayout(PanelHautLayout);
        PanelHautLayout.setHorizontalGroup(
            PanelHautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1598, Short.MAX_VALUE)
        );
        PanelHautLayout.setVerticalGroup(
            PanelHautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        add(PanelHaut, java.awt.BorderLayout.NORTH);

        PanelCentral.setBackground(new java.awt.Color(207, 208, 84));
        PanelCentral.setLayout(new java.awt.BorderLayout());

        Add_Tag.setText("Ajouter un Tag");
        

        Supp.setText("Supprimer");
        

        All_select.setText("Tout selectionner");

        jButton8.setText("Tout deselectionner");

        Add_folder.setText("Ajouter Dossier");

        javax.swing.GroupLayout PanelHaut2Layout = new javax.swing.GroupLayout(PanelHaut2);
        PanelHaut2.setLayout(PanelHaut2Layout);
        PanelHaut2Layout.setHorizontalGroup(
            PanelHaut2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHaut2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Add_Tag, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Supp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(All_select, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 736, Short.MAX_VALUE)
                .addComponent(Add_folder)
                .addContainerGap())
        );
        PanelHaut2Layout.setVerticalGroup(
            PanelHaut2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHaut2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(PanelHaut2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Tag)
                    .addComponent(Supp)
                    .addComponent(All_select)
                    .addComponent(jButton8)
                    .addComponent(Add_folder))
                .addContainerGap())
        );

        PanelCentral.add(PanelHaut2, java.awt.BorderLayout.NORTH);

        PanelLateral.setBackground(new java.awt.Color(226, 134, 90));
        PanelLateral.setPreferredSize(new java.awt.Dimension(100, 409));

        recherche.setText("Recherche");

        nom.setText("Par Nom");

        tag.setText("Par Tag");

        Filtre_tri.setPreferredSize(new java.awt.Dimension(100, 450));

        TriPar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Nom"}));

        Croisant_dec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout TriLayout = new javax.swing.GroupLayout(Tri);
        Tri.setLayout(TriLayout);
        TriLayout.setHorizontalGroup(
            TriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TriPar, 0, 125, Short.MAX_VALUE)
                    .addComponent(Croisant_dec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TriLayout.setVerticalGroup(
            TriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TriLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(TriPar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Croisant_dec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        Filtre_tri.addTab("Tri", Tri);

        Filtrage.setBackground(new java.awt.Color(213, 204, 188));

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 411));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        Filtrage.setViewportView(jPanel1);

        Filtre_tri.addTab("Filtrage", Filtrage);

        Aplliquer.setText("Appliquer");

        Remove_choice.setText("Annuler");

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Filtre_tri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recherche, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Remove_choice)
                        .addGap(11, 11, 11)
                        .addComponent(Aplliquer)))
                .addContainerGap())
        );
        PanelLateralLayout.setVerticalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Filtre_tri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aplliquer)
                    .addComponent(Remove_choice))
                .addContainerGap())
        );

        SplitCentral.setLeftComponent(PanelLateral);

        PanelGeneral.setBackground(new java.awt.Color(226, 134, 90));

        PanelGeneral.setLayout(new GridBagLayout());

        SplitCentral.setRightComponent(PanelGeneral);

        PanelCentral.add(SplitCentral, java.awt.BorderLayout.CENTER);

        add(PanelCentral, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add_Tag;
    public javax.swing.JButton Add_folder;
    public javax.swing.JButton All_select;
    public javax.swing.JButton Aplliquer;
    public javax.swing.JComboBox<String> Croisant_dec;
    public javax.swing.JScrollPane Filtrage;
    public javax.swing.JTabbedPane Filtre_tri;
    public javax.swing.JPanel PanelCentral;
    public javax.swing.JPanel PanelGeneral;
    public javax.swing.JPanel PanelHaut;
    public javax.swing.JPanel PanelHaut2;
    public javax.swing.JPanel PanelLateral;
    public javax.swing.JButton Remove_choice;
    public javax.swing.JSplitPane SplitCentral;
    public javax.swing.JButton Supp;
    public javax.swing.JPanel Tri;
    public javax.swing.JComboBox<String> TriPar;
    public javax.swing.JButton jButton8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JButton nom;
    public javax.swing.JTextField recherche;
    public javax.swing.JButton tag;
    // End of variables declaration//GEN-END:variables

}
