import java.io.File;
import java.util.ArrayList;

/*
 * Classe qui représente une image que le programme peut
 * afficher, modifier, etc.
 */
public class Image {
	String name;
	String folder;
	String extension;
	
	Image(String name, String folder, String extension) {
		this.name = name;
		this.folder = folder;
		this.extension = extension;
	}
	
	public String toString() {
		return String.format("{name: '%s', folder: '%s', extension: '%s'}",
				this.name,
				this.folder,
				this.extension);
	}
	
	static String formats = "png|jpeg|jpg|bmp|gif|tiff";
	// ^ formats que le programme reconnaît
	// liste temporaire
	

	static ArrayList<Image> fromFolder(String path) throws Exception {
		File folder = new File(path);
		File[] files = folder.listFiles();
		if (files == null) {
			throw new Exception("Folder given does not exit");
		}
		
		ArrayList<Image> images = new ArrayList<Image>();
		for (File file : files) {
			if (!file.isDirectory()) {
				String name = file.getName();
				String[] bits = name.split("\\.");
				if (bits.length >= 2) {
					String extension = bits[bits.length - 1];
					if (extension.matches(Image.formats)){
						images.add(new Image(name, path, extension));
					}
				}
			}
		}
		return images;
	}
	

}
