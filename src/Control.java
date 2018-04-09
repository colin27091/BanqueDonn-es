import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Control implements WindowListener {
	String folderPath;
	String configFile;
	Model model;
	Application app;
	
	Control(Application app, Model model){
		this.model = model;
		this.app = app;
	}

	Control(String configFile) throws Exception {
		this.configFile = configFile;
		this.loadExternalData();
	}

	void saveExternalData() throws Exception {
		ExternalData ed = new ExternalData();
		ed.folderPath = this.folderPath;
		ed.saveData(this.configFile);
	}

	void loadExternalData() throws Exception {
		ExternalData ed = ExternalData.loadData(this.configFile);
		this.folderPath = ed.folderPath;
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
			this.saveExternalData();
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

	/*static ArrayList<Pic> addFile(ArrayList<Pic> pics /*Celle presente dans le modele) {
		FileSystemView vuesysteme = FileSystemView.getFileSystemView();
		File home = vuesysteme.getHomeDirectory();
		JFileChooser homechooser = new JFileChooser(home);
		homechooser.setDialogTitle("Choisissez un dossier  :");
		homechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
		homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.png", "png"));
		homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
		homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.bmp", "bmp"));
		homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.psd", "psd"));
		homechooser.addChoosableFileFilter(new FileNameExtensionFilter("*.jpeg", "jpeg"));
		homechooser.setAcceptAllFileFilterUsed(false);

		homechooser.showOpenDialog(null);
		File file = homechooser.getSelectedFile();
		String name = file.getName();
		String

	}*/

	static ArrayList<Pic> chooseFolder() {
		FileSystemView vuesysteme = FileSystemView.getFileSystemView();
		File home = vuesysteme.getHomeDirectory();
		JFileChooser homechooser = new JFileChooser(home);
		homechooser.setDialogTitle("Choisissez un dossier  :");
		homechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		homechooser.showOpenDialog(null);

		File[] files = homechooser.getSelectedFile().listFiles();/* Liste des fichiers dans le dossier selectionné */

		ArrayList<Pic> images = new ArrayList<Pic>();
		Integer id = 0;
		for (File file : files) {
			if (!file.isDirectory()) {
				String name = file.getName();
				String[] bits = name.split("\\.");
				if (bits.length >= 2) {
					String extension = bits[bits.length - 1];
					if (extension.matches(Pic.formats)) {
						id++;
						images.add(new Pic(id, name, file, extension));
					}
				}
			}
		}
		return images;

	}

}
