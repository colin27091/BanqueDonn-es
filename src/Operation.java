import java.util.ArrayList;

public class Operation {
	ArrayList<Tag> positive;
	ArrayList<Tag> negative;
	Tag universe;
	
	Operation(Tag universe) {
		this.universe = universe;
		this.positive = new ArrayList<Tag>();
		this.positive.add(universe);
		this.negative = new ArrayList<Tag>();
	}
	
	@SuppressWarnings("unchecked")
	Tag result() {
		ArrayList<Tag> positiveBags = (ArrayList<Tag>)this.positive.clone();
		ArrayList<Tag> negativeBags = (ArrayList<Tag>)this.negative.clone();
		Tag inter = Tag.smallest(positiveBags);
		positiveBags.remove(inter);
		while (!positiveBags.isEmpty()) {
			Tag other = Tag.smallest(positiveBags);
			inter.retainAll(other);
			positiveBags.remove(other);
		}
		while (!negativeBags.isEmpty()) {
			Tag other = Tag.biggest(negativeBags);
			inter.removeAll(other);
			negativeBags.remove(other);
		}
		return inter;
	}
}
