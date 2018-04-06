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
	Tag compute() {
		ArrayList<Tag> positiveTags = (ArrayList<Tag>)this.positive.clone();
		ArrayList<Tag> negativeTags = (ArrayList<Tag>)this.negative.clone();
		Tag inter = Tag.smallest(positiveTags);
		positiveTags.remove(inter);
		while (!positiveTags.isEmpty()) {
			Tag other = Tag.smallest(positiveTags);
			inter.retainAll(other);
			positiveTags.remove(other);
		}
		while (!negativeTags.isEmpty()) {
			Tag other = Tag.biggest(negativeTags);
			inter.removeAll(other);
			negativeTags.remove(other);
		}
		return inter;
	}
}
