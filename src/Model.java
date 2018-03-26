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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
