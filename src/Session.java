import java.io.File;
import java.util.ArrayList;
import java.util.Observable;


public class Session  { //extends Observable {
	String name;
	ArrayList<File> picFolders;
	ArrayList<Pic> pictures;
	//ArrayList<TagType> tagTypes;
	
	Session(String name) {
		this.name = name;
		this.picFolders = new ArrayList<File>();
		this.pictures = new ArrayList<Pic>();
	}
	
	void refresh() {
		int fsLen = this.picFolders.size();
		for (int i = 0; i < fsLen; i++) {
			File[] files = this.picFolders.get(i).listFiles();
			if (files == null) {
				continue;
				// TODO: gérer le cas où le rafraichissement échoue car
				// le dossier n'est pas/plus accessible
			}
			Pic.addFromFiles(this.pictures, files);
		}
		//this.notifyObservers();
	}
}
