import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

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
	Dimension taille;
	Date date;
	ArrayList<String> tags;

	Pic(String name, File file, String extension, ImageIcon image, ArrayList<String> tags) {
		this.name = name;
		this.file = file;
		this.extension = extension;
		this.image = image;
		this.tags = tags;
		this.taille = new Dimension(image.getIconHeight(), image.getIconWidth());
		this.date = new Date(file.lastModified());

	}

	Pic(String name, File file, String extension, ImageIcon image) {
		this.name = name;
		this.file = file;
		this.extension = extension;
		this.image = image;
		this.taille = new Dimension(image.getIconHeight(), image.getIconWidth());
		this.date = new Date(file.lastModified());

	}

	public String toString() {
		return String.format("{name: '%s', path: '%s', extension: '%s'}", this.name, this.file.getAbsolutePath(),
				this.extension);
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

	static Pic fromFile(File file) {
		if (!file.isDirectory()) {
			String name = file.getName();
			ImageIcon image = new ImageIcon(file.toString());
			String[] bits = name.split("\\.");
			if (bits.length >= 2) {
				String extension = bits[bits.length - 1];
				if (extension.matches(Pic.formats)) {
					return new Pic(name, file, extension, image);
				}
			}
		}
		return null;
	}
	//recupere un boolean disant si oui ou non le file peut devenir un Pic
	static boolean canBePic(File file) {
		if (!file.isDirectory()) {
			String name = file.getName();
			String[] all = name.split("\\.");
			if (all.length >= 2) {
				String extension = all[all.length - 1];
				if (extension.matches(Pic.formats)) {
					return true;
				}
			}
		}
		return false;
	}
	
	

	// récupère une liste d'Image à partir d'une liste de File[]
	static ArrayList<Pic> fromFiles(File folder) {

		File[] files = folder.listFiles();
		ArrayList<Pic> data = new ArrayList<Pic>();
		for (File file : files) {
			if (!file.isDirectory()) {
				String name = file.getName();
				ImageIcon image = new ImageIcon(file.toString());
				String[] bits = name.split("\\.");
				if (bits.length >= 2) {
					String extension = bits[bits.length - 1];
					if (extension.matches(Pic.formats)) {
						ArrayList<String> tag = new ArrayList<String>();
						if (new File(folder + "/.pictag").exists()) {
							tag = Tools.searchTags(folder, file.getName());
						} else {
							Tools.createPictag(folder);
						}
						data.add(new Pic(name, file, extension, image, tag));
					}
				}
			}
		}
		return data;
	}
}
