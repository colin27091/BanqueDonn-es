import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Classe qui représente une image que le programme peut
 * afficher, modifier, etc.
 */
public class Pic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	File file;
	String extension;
	ImageIcon image;
	Date date;
	ArrayList<String> tags;
	

	public Pic(String name){
		this.name = name;
	}

	public Pic(String name, File file, String extension, ImageIcon image, Hashtable<String,Set<String>> tags ) {
		this.name = name;
		this.file = file;
		this.extension = extension;
		this.image = image;
		//this.dimension = new Dimension(image.getIconHeight(), image.getIconWidth());
		this.date = new Date(file.lastModified());
		
	}


	public Pic(String name, File file, String extension, ImageIcon image) {
		this.name = name;
		this.file = file;
		this.extension = extension;
		this.image = image;
		//this.dimension = new Dimension(image.getIconHeight(), image.getIconWidth());


	}

	public String toString() {
		return String.format("{name: '%s', path: '%s', extension: '%s'}", this.name, this.file.getAbsolutePath(), this.extension);
	}

	public boolean delete() {
		boolean ans = this.file.delete();
		return ans;
	}

	static String formats = "png|jpeg|jpg|bmp|gif|tiff";
	// ^ formats que le programme reconnaît
	// liste temporaire
	
	public File getFile() {
		return this.file;
	}
	
	public ImageIcon getImage() {
		return this.image;
	}

	
	public String getName() {
		return this.name;
	}

	public String getExtension() {
		return this.extension;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setExtention(String ext) {
		this.extension =ext;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void setImage(ImageIcon img) {
		this.image =img;
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
	
	public Image scaleImage(Image source, int width, int height) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
	
	public Image scaleImage(final Image source, final double factor) {
	    int width = (int) (source.getWidth(null) * factor);
	    int height = (int) (source.getHeight(null) * factor);
	    return scaleImage(source, width, height);
	}
	
	
	/*ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
	Image zoom = scaleImage(icon.getImage(), 0.5d);
	Icon iconScaled = new ImageIcon(zoom);
	final JLabel j = new JLabel(iconScaled);*/
	
	
	
	
	
	
	
	
	
	
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
						/*ArrayList<String> tag = new ArrayList<String>();
						if (new File(folder + "/.pictag").exists()) {
							//tag = Tools.searchTags(folder, file.getName());
						} else {
							Tools.createPictag(folder);
						}*/
						data.add(new Pic(name, file, extension, image));

					}
				}
			}
		}
		return data;

	}
}
