import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TagType extends HashMap<String, Tag> {
	String name;
	//boolean unicity; // forbid a picture from having two tags of the same type
	
	TagType(String name) {
		super();
		this.name = name;
		//this.unicity = unicity;
	}
	
	// Retourne true si l'ajout est possible et donc réalisé,
	// càd si il n'y a pas déjà de tags de ce nom dans ce TagType.
	boolean addTag(Tag newTag, String name) {
		if (name == null) {
			return false;
		}
		if (this.containsKey(name)) {
			return false;
		}
		newTag.setName(name);
		this.put(name, newTag);
		return true;
	}
	
	ArrayList<Pic> group(Tag pics) {
		ArrayList<Pic> r = new ArrayList<Pic>();
		//Collections.sort ...
		Iterator<String> keysIter = this.keySet().iterator();
		while (keysIter.hasNext()) {
			Tag tag = this.get(keysIter.next());
			Tag intersection = pics.inter(tag);
			if (intersection.size() != 0) {
				
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		TagType ty = new TagType("Color");
		ty.addTag(new Tag(), "red");
	}
}
