import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Control extends WindowAdapter {
	File folderPath;
	String sessionsFolder;
	Model model;

	Control(Model model, String sessionsFolder) throws Exception {
		this.model = model;
		this.sessionsFolder = sessionsFolder;
		//this.loadExternalData();
	}

//	void saveExternalData() throws Exception {
//		ExternalData ed = new ExternalData();
//		ed.folderPath = this.folderPath.getAbsolutePath();
//		ed.saveData(this.configFile);
//	}
//
//	void loadExternalData() throws Exception {
//		ExternalData ed = ExternalData.loadData(this.configFile);
//		this.folderPath = new File(ed.folderPath);
//	}
	
	void openSession(String sessionName) throws Exception {
		File sessionFile = new File(this.sessionsFolder + "/" + sessionName);
		SessionData data = SessionData.fromFile(sessionFile);
		this.model.loadSession(data.toSession());
	}
	
	void closeSession() {
		// TODO check if there's actually a model.session (and not null)
		Tools.log("tentative sauvegarde données de session:");
		try {
			this.saveSessionData();
			Tools.log("- succès!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void saveSessionData() throws Exception {
		SessionData data = SessionData.fromSession(this.model.session);
		File sessionFile = new File(this.sessionsFolder + "/" + this.model.session.name);
		data.toFile(sessionFile);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.closeSession();
		Tools.log("fin du programme");
		System.exit(0);
	}

//	void chooseFolder() {
//		FileSystemView vuesysteme = FileSystemView.getFileSystemView();
//		File home = vuesysteme.getHomeDirectory();
//		JFileChooser homechooser = new JFileChooser(home);
//		homechooser.setDialogTitle("Choisissez un dossier  :");
//		homechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//		homechooser.showOpenDialog(null);
//
//		File folder = homechooser.getSelectedFile();
//		// TODO: gérer le cas où le folder n'existe pas (bien qu'improbable il faut le gérer)
//		this.folderPath = folder;
//		this.model.refresh();
//	}
//	public static void main(String[] args) throws Exception {
//		Control control = new Control("./tests/Control/config.xml");
//		Model model = new Model(control);
//		control.chooseFolder();
//		System.out.println(model.images.toString());
//	}

	// basic testing of opening/closing sessions (tagless for now)
	public static void main(String[] args) throws Exception {
		Model m = new Model();
		Control c = new Control(m, "sessions");
		
		Session s = new Session("user1");
		m.session = s;
		s.picFolders.add(new File("images"));
		s.picFolders.add(new File("foo"));
		c.closeSession();
		
		c.openSession("user1");
		System.out.println(m.session.picFolders);
	}
}
