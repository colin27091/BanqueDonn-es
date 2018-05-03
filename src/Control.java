import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Control implements WindowListener, MouseListener, ActionListener {

	Model model;
	

	Control(Model mdl) {
		this.model = mdl;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		Tools.log("tentative sauvegarde données externes:");
		try {
			Tools.log("- succès!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tools.log("fin du programme");
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * static ArrayList<Pic> addFile(ArrayList<Pic> pics /*Celle presente dans le
	 * modele) { FileSystemView vuesysteme = FileSystemView.getFileSystemView();
	 * File home = vuesysteme.getHomeDirectory(); JFileChooser homechooser = new
	 * JFileChooser(home); homechooser.setDialogTitle("Choisissez un dossier  :");
	 * homechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	 * 
	 * homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf",
	 * "pdf")); homechooser.addChoosableFileFilter(new
	 * FileNameExtensionFilter("*.png", "png"));
	 * homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg",
	 * "jpg")); homechooser.addChoosableFileFilter(new
	 * FileNameExtensionFilter("*.bmp", "bmp"));
	 * homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.psd",
	 * "psd")); homechooser.addChoosableFileFilter(new
	 * FileNameExtensionFilter("*.jpeg", "jpeg"));
	 * homechooser.setAcceptAllFileFilterUsed(false);
	 * 
	 * homechooser.showOpenDialog(null); File file = homechooser.getSelectedFile();
	 * String name = file.getName(); String
	 * 
	 * }
	 */

	void chooseFolder() {
		FileSystemView vuesysteme = FileSystemView.getFileSystemView();
		File home = vuesysteme.getHomeDirectory();
		JFileChooser homechooser = new JFileChooser(home);
		homechooser.setDialogTitle("Choisissez un dossier  :");
		homechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		homechooser.showOpenDialog(null);

		File folder = homechooser.getSelectedFile();
		// TODO: gérer le cas où le folder n'existe pas (bien qu'improbable il faut le
		// gérer)
		// this.model.folderPath = folder;

		// this.model.refresh();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Appliquer") {
			this.model.setData(Pic.fromFiles(new File("/home/colin/Documents/Licence Info/S4/projetjava/images")));
		}

		if (e.getActionCommand() == "Add_folder") {
			JFileChooser choix = new JFileChooser();
			choix.setApproveButtonText("Ajouter dossier");
			choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			// System.out.println(choix.getSelectedFile());
			if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				this.model.setData(Pic.fromFiles(new File(choix.getSelectedFile().getAbsolutePath().toString())));
				System.out.println(choix.getSelectedFile().getAbsolutePath().toString());
			} else {
				System.out.println("fail");
			}
			//this.model.setData(Pic.fromFiles(new File(
			/*if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				System.out.println(choix.getSelectedFile().getAbsolutePath());
			}*/
		}

		if (e.getActionCommand() == "Add_file") {
			JFileChooser choix = new JFileChooser();
			choix.setApproveButtonText("Ajouter images");
			choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			/*
			 * if ( choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			 * this.model.setData(Pic.fromFiles(new
			 * File(choix.getSelectedFile().getAbsolutePath().toString())));
			 */
			
			
		}

	}

}
