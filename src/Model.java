import java.beans.PersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Scanner;
import java.util.Set;

import javax.swing.ImageIcon;

public class Model extends Observable implements Serializable {

	public ArrayList<Pic> data;
	File fichier;
	Hashtable<String, ArrayList<Pic>> tags;

	Model() {
		data = new ArrayList<Pic>();
		fichier = new File("images.dat");
		fichier = new File("images.xml");
	}

	void addTag(String tag, ArrayList<Pic> pics) {

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

		

			
			
			
		

	this.notifyObservers(this.data);
}

}
