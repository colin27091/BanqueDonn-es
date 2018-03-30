import java.util.ArrayList;
import java.util.HashMap;

public class TagType extends HashMap<String, Tag> {
	String name;
	boolean unicity; // forbid a picture from having two tags of the same type
	
	TagType(String name, boolean unicity) {
		super();
		this.name = name;
		this.unicity = unicity;
	}
}
