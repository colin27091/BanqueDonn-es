import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class SessionData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SessionData() {
		this.picFolders = new ArrayList<String>();
	}
	
	public ArrayList<String> picFolders; // chemin où les images de l'utilisateur sont stockés
	private String name;
	//public ArrayList<PicData> pictures;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getPicFolders() {
		return picFolders;
	}

	public void setPicFolders(ArrayList<String> picFolders) {
		this.picFolders = picFolders;
	}

//	public ArrayList<PicData> getPictures() {
//		return pictures;
//	}
//
//	public void setPictures(ArrayList<PicData> pictures) {
//		this.pictures = pictures;
//	}

	// Lit le fichier de configuration donné en paramètre
	// produit une exception si le fichier est illisible ou inexistant
	static SessionData fromFile(File file) throws Exception {
		SessionData sdata;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		XMLDecoder decoder = null;
		
		fis = new FileInputStream(file);
		bis = new BufferedInputStream(fis);
		decoder = new XMLDecoder(bis);
		sdata = (SessionData)decoder.readObject();
		decoder.close();
		bis.close();
		fis.close();
		
		return sdata;
	}
	
	// Enregistre `this` dans un fichier de configuration
	void toFile(File file) throws Exception {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		XMLEncoder encoder = null;

		fos = new FileOutputStream(file);
		bos = new BufferedOutputStream(fos);
		encoder = new XMLEncoder(bos);
		
		encoder.writeObject(this);
		
		encoder.flush();
		encoder.close();
		bos.close();
		fos.close();
	}

	public Session toSession() {
		// TODO Auto-generated method stub
		Session r = new Session(this.name);
		for (int i=0; i < this.picFolders.size(); i++) {
			r.picFolders.add(new File(this.picFolders.get(i)));
		}
		return r;
	}

	public static SessionData fromSession(Session session) {
		SessionData r = new SessionData();
		for (int i=0; i < session.picFolders.size(); i++) {
			r.picFolders.add(session.picFolders.get(i).getAbsolutePath());
		}
		return r;
	}

}
