import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Hashtable;

import org.w3c.dom.Document;

/*
 * classe possiblement temporaire. Contiendra des fonctions indépendantes
 * ne nécessitant pas d'état interne.
 */
public class Tools {

	static void log(String s) {
		System.out.println(s);
	}
	
	
	
	static Hashtable<String, ArrayList<String>> extractTags(File folder){
		return null;
	}
	

	static ArrayList<String> searchTags(File folder, String nom) {
		ArrayList<String> tags = new ArrayList<String>();
		File pictag = new File(folder + "/.pictag");
		
		try {
			FileReader fr = new FileReader(pictag);
			BufferedReader br = new BufferedReader(fr);
			try {
				String line = br.readLine();
				while (line != null) {
					String[] split = line.split("/");
					if (split[0].compareTo(nom) == 0) {
						for (int i = 1; i < split.length; i++) {
							tags.add(split[i]);
						}
					}
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return tags;
	}

	static void createPictag(File folder) {
		if(folder.isDirectory()) {
			if(! new File(folder+"/.pictag").exists()) {
				try {
					new File(folder + File.separator + ".pictag").createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static void createXML(File file) {
		
		//Document doc = new Document();
		
		
	}
	
	static void readXML(File file) {
		
	}
	
   /* ActionListener aljComboBox1 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<Pic> tri= new ArrayList<Pic>();
			Pic p;
			String selec = (String) jComboBox1.getSelectedItem();
			switch(selec) {
			case "Nom":
				Tri.nomC(tri);
			}
			
		}*/
}
