import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{ 
	ArrayList<Pic> images;
	public Session session;
	
	Model() {
	}
	
	void refresh() {
		this.session.refresh();
		this.notifyObservers();
	}
	
	// pour vérifier le lien modèle-controlleur
	// et l'utilisation d'un fichier de config externe
	public static void main2(String[] args) throws Exception {
		ExternalData ed = new ExternalData();
		ed.folderPath = "./images";
		String configFile = "./tests/Control/config.xml";
		ed.saveData(configFile);
		// return;
		Model model = new Model();
		Control control = new Control(model, configFile);
		model.refresh();
		System.out.println(model.images.size());
	}

	public void loadSession(Session newSession) {
		this.session = newSession;
		this.refresh();
	}
	
//	// pour vérifier que l'appli se ferme bien quand on clique sur
//	// le bouton de fermeture, et que le fichier de conf est bien
//	// enregistré
//	public static void main(String[] args) throws Exception {
//		ExternalData ed = new ExternalData();
//		ed.folderPath = "./images";
//		String configFile = "./tests/Control/config.xml";
//		ed.saveData(configFile);
//		// return;
//		Control control = new Control(configFile);
//		Application app = new Application();
//		app.addWindowListener(control); // lien évènements de fermeture
//	}
}
