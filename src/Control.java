import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Control implements WindowListener {
	File folderPath;
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
		ed.folderPath = this.folderPath.getAbsolutePath();
		ed.saveData(this.configFile);
	}

	void loadExternalData() throws Exception {
		ExternalData ed = ExternalData.loadData(this.configFile);
		this.folderPath = new File(ed.folderPath);
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

	void chooseFolder() {
		FileSystemView vuesysteme = FileSystemView.getFileSystemView();
		File home = vuesysteme.getHomeDirectory();
		JFileChooser homechooser = new JFileChooser(home);
		homechooser.setDialogTitle("Choisissez un dossier  :");
		homechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		homechooser.showOpenDialog(null);

		File folder = homechooser.getSelectedFile();
		// TODO: gérer le cas où le folder n'existe pas (bien qu'improbable il faut le gérer)
		this.folderPath = folder;
		this.model.refresh();
	}
	
	public static void main(String[] args) throws Exception {
		Control control = new Control("./tests/Control/config.xml");
		Model model = new Model(control);
		control.chooseFolder();
		System.out.println(model.images.toString());
	}

}
