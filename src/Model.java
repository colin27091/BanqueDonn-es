import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{ 
	ArrayList<Pic> images;
	Control control;
	
	Model(Control control) {
		this.control = control;
		this.control.model = this;
	}
	
	void refresh() {
		try {
			this.images = Pic.fromFolder(this.control.folderPath);
			this.notifyObservers();
		} catch (Exception e) {
			// TODO créer une fenêtre pour informer
			// l'utilisateur que refresh() a échoué
			// (et pour un certain nombre d'autres problèmes
			// du même genre)
			e.printStackTrace();
		}
	}
	
	// pour vérifier le lien modèle-controlleur
	// et l'utilisation d'un fichier de config externe
	public static void main2(String[] args) throws Exception {
		ExternalData ed = new ExternalData();
		ed.folderPath = "./images";
		String configFile = "./tests/Control/config.xml";
		ed.saveData(configFile);
		// return;
		Control control = new Control(configFile);
		Model model = new Model(control);
		model.refresh();
		System.out.println(model.images.size());
	}
	
	// pour vérifier que l'appli se ferme bien quand on clique sur
	// le bouton de fermeture, et que le fichier de conf est bien
	// enregistré
	public static void main(String[] args) throws Exception {
		ExternalData ed = new ExternalData();
		ed.folderPath = "./images";
		String configFile = "./tests/Control/config.xml";
		ed.saveData(configFile);
		// return;
		Control control = new Control(configFile);
		Application app = new Application();
		app.addWindowListener(control); // lien évènements de fermeture
	}
}
