import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Classe pour contenir les données à sauvegarder et à récupérer depuis
 * le fichier de configuration associé au programme.
 */
public class ExternalData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExternalData() {}
	
	public String folderPath; // chemin où les images de l'utilisateur sont stockés
	
	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	// Lit le fichier de configuration donné en paramètre
	// produit une exception si le fichier est illisible ou inexistant
	static ExternalData loadData(String file) throws Exception {
		ExternalData extdata;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		XMLDecoder decoder = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);
			extdata = (ExternalData)decoder.readObject();
		} finally {
			decoder.close();
			bis.close();
			fis.close();
		}
		return extdata;
	}
	
	// Enregistre this dans un fichier de configuration
	void saveData(String file) throws Exception {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		XMLEncoder encoder = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			encoder = new XMLEncoder(bos);
			
			encoder.writeObject(this);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			encoder.flush();
			encoder.close();
			bos.close();
			fos.close();
		}
	}

}
