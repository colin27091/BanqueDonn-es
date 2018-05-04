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
	ArrayList<Case> cases;
	ArrayList<String> tri;
	ArrayList<String> filtre;

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

	void setParam(ArrayList<String> tri, ArrayList<String> filtre) {
		ArrayList<Pic> data = new ArrayList<Pic>();
		if (!filtre.isEmpty()) {

		}
		if (tri.get(0) == "Date") {
			if (tri.get(1) == "Croissant") {
				data = Tri.dateC(this.model.data);
			} else {
				data = Tri.dateD(this.model.data);
			}
		} else {
			if (tri.get(1) == "Croissant") {
				data = Tri.nomC(this.model.data);
			} else {
				data = Tri.nomD(this.model.data);
			}
		}

		this.model.setData(data);

	}

	void removePic(ArrayList<Pic> pics) {
		ArrayList<Pic> data = new ArrayList<Pic>();
		for (int i = 0; i < this.model.data.size(); i++) {
			if(! pics.contains(this.model.data.get(i))) {
				data.add(this.model.data.get(i));
			}
		}
		for(Pic pic : pics) {
			pic.file.delete();
		}
		

		this.model.setData(data);
	}

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

		if (e.getActionCommand() == "Add_folder") {
			JFileChooser choix = new JFileChooser();
			choix.setApproveButtonText("Ajouter dossier");
			choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			// System.out.println(choix.getSelectedFile());
			if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				this.model.setData(Pic.fromFiles(new File(choix.getSelectedFile().getAbsolutePath().toString())));

			} else {
				System.out.println("fail");
			}
		}

		if (e.getActionCommand() == "Add_file") {
			JFileChooser choix = new JFileChooser();
			choix.setApproveButtonText("Ajouter images");
			choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}

	}

}
