import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Scanner;
import java.util.Set;

public class Model extends Observable {

	ArrayList<Pic> data;
	Hashtable<String, ArrayList<Pic>> tags;
	File fichier = new File("images.xml");

	Model() {
		this.data = new ArrayList<Pic>();
		this.tags = new Hashtable<String, ArrayList<Pic>>();

	}

	void setTag(ArrayList<Pic> pics) {
		this.tags = Tag.extractTag(this.data);
	}

	void setData(ArrayList<Pic> newfilter) {

		if (!newfilter.equals(this.data)) {
			this.setTag(newfilter);
			this.data = newfilter;
			this.setChanged();
			this.notifyObservers(newfilter);
		}
	}
	

	public void chargement(String dir) {
		
		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.data = new ArrayList<>();
		this.data = Pic.fromFiles(repImages);
	}
	
	

}
