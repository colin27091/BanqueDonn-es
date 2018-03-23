import java.io.File;
import java.util.ArrayList;

/*
 * Classe qui représente une image que le programme peut
 * afficher, modifier, etc.
 */
public class Pic {
	String name;
	String path;
	String extension;
	
	Pic(String name, String folder, String extension) {
		this.name = name;
		this.path = folder;
		this.extension = extension;
	}
	
	public String toString() {
		return String.format("{name: '%s', path: '%s', extension: '%s'}",
				this.name,
				this.path,
				this.extension);
	}
	
	static String formats = "png|jpeg|jpg|bmp|gif|tiff";
	// ^ formats que le programme reconnaît
	// liste temporaire
	

	// récupère une liste d'Image à partir d'un dossier contenant
	// des images
	static ArrayList<Pic> fromFolder(String path) throws Exception {
		File folder = new File(path);
		File[] files = folder.listFiles();
		if (files == null) {
			throw new Exception("Folder given does not exit");
		}
		
		ArrayList<Pic> images = new ArrayList<Pic>();
		for (File file : files) {
			if (!file.isDirectory()) {
				String name = file.getName();
				String[] bits = name.split("\\.");
				if (bits.length >= 2) {
					String extension = bits[bits.length - 1];
					if (extension.matches(Pic.formats)){
						images.add(new Pic(name, file.getAbsolutePath(), extension));
					}
				}
			}
		}
		return images;
	}
	

}
