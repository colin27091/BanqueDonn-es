import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Tag extends HashSet<Pic> {
	String name;
	TagType type;
	
	boolean anonymous;
	boolean negative = false;
	
	Tag() {
		super();
		this.setName(null);
	}
	
	Tag(String name, TagType type) {
		super();
		this.setName(name);
		this.type = type;
	}
	
	void setName(String name) {
		this.name = name;
		this.anonymous = (name == null);
	}

	static Tag smallest(ArrayList<Tag> tags) {
		if (tags.size() == 0) return new Tag();
		Tag min = tags.get(0);
		int minsize = min.size();
		for (int i = 1; i < tags.size(); i++) {
			Tag here = tags.get(i);
			int heresize = here.size();
			if (heresize < minsize) {
				minsize = heresize;
				min = here;
			}
		}
		return Tag.copy(min);
	}
	
	static Tag biggest(ArrayList<Tag> tags) {
		if (tags.size() == 0) return new Tag();
		Tag max = tags.get(0);
		int maxsize = max.size();
		for (int i = 1; i < tags.size(); i++) {
			Tag here = tags.get(i);
			int heresize = here.size();
			if (heresize > maxsize) {
				maxsize = heresize;
				max = here;
			}
		}
		return Tag.copy(max);
	}

	private static Tag copy(Tag tag) {
		Tag r = new Tag();
		Iterator<Pic> it = tag.iterator();
		while (it.hasNext()) {
			r.add(it.next());
		}
		return r;
	}
}
