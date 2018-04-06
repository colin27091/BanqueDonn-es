import java.io.File;
import java.util.ArrayList;

/*
 * Classe qui représente une image que le programme peut
 * afficher, modifier, etc.
 */
public class Pic {
	Integer id;
	String name;
	File file;
	String extension;
	
	Pic(Integer id, String name, File file, String extension) {
		this.id = id;
		this.name = name;
		this.file = file;
		this.extension = extension;
	}
	
	public String toString() {
		return String.format("{id: '%s', name: '%s', path: '%s', extension: '%s'}",
				this.id,
				this.name,
				this.file.getAbsolutePath(),
				this.extension);
	}
	
	// gotta check the values given to that function to forbid several characters
	public boolean rename(String newName) {
		boolean ans = this.file.renameTo(
				new File(this.file.getParentFile().getAbsolutePath() + "/" + newName));
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		return ans;
	}
	
	public boolean delete() {
		boolean ans = this.file.delete();
		return ans;
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
		Integer id = 0;
		for (File file : files) {
			if (!file.isDirectory()) {
				String name = file.getName();
				String[] bits = name.split("\\.");
				if (bits.length >= 2) {
					String extension = bits[bits.length - 1];
					if (extension.matches(Pic.formats)){
						id++;
						images.add(new Pic(id, name, file, extension));
					}
				}
			}
		}
		return images;
	}
	
	public Tag toNegativeTag() {
		Tag r = new Tag();
		r.add(this);
		r.negative = true;
		return r;
	}
}
