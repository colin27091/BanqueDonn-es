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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Observable;


public class SaveDonnees{ 
	
	Model mdl;

	
	public SaveDonnees(Model mdl) {
		this.mdl = mdl;
	}
	
	
	@SuppressWarnings("unchecked")
	
	
public void chargement() {
		
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("images.dat"));
			this.mdl.data = (ArrayList<Pic>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException | ClassNotFoundException e2) {
			throw new RuntimeException("Lecture des données impossible ou données corrompues");
		}	
	}

	public void enregistrement() {
		
		try {
			FileOutputStream fos = new FileOutputStream("images.dat");
			ObjectOutputStream oos =  new ObjectOutputStream(fos);
			oos.writeObject(this.mdl.data);
			oos.close();
			fos.close();
		} catch (IOException e1) {
			throw new RuntimeException("Impossible d'écrire les donnÃ©es");
		}
	}
	
}
