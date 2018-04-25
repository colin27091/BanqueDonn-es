import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/*
 * Classe qui représente une image que le programme peut
 * afficher, modifier, etc.
 */
public class Pic {
	String name;
	File file;
	String extension;
	ImageIcon image;
	
	
	Pic(String name, File file, String extension, ImageIcon image) {
		this.name = name;
		this.file = file;
		this.extension = extension;
		this.image = image;
	}
	
	public String toString() {
		return String.format("{name: '%s', path: '%s', extension: '%s'}",
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
	
	String getName() {
		return this.name;
	}

	String getExtension() {
		return this.extension;
	}

	// récupère une liste d'Image à partir d'une liste de File[]
		static ArrayList<Pic> fromFiles(File[] files) {
			ArrayList<Pic> images = new ArrayList<Pic>();
			for (File file : files) {
				if (!file.isDirectory()) {
					String name = file.getName();
					ImageIcon image = new ImageIcon(file.toString());
					String[] bits = name.split("\\.");
					if (bits.length >= 2) {
						String extension = bits[bits.length - 1];
						if (extension.matches(Pic.formats)){
							images.add(new Pic(name, file, extension, image));
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
