import java.util.ArrayList;
import java.util.HashSet;

public class Tag extends HashSet<Pic> {
	String name;
	TagType type;
	
	boolean anonymous;
	boolean negative = false;
	
	Tag() {
		super();
		this.anonymous = true;
	}
	
	Tag(String name, TagType type) {
		super();
		this.anonymous = false;
		this.name = name;
		this.type = type;
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
		// TODO Auto-generated method stub
		return null;
	}
}
