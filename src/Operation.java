import java.util.ArrayList;

public class Operation {
	ArrayList<Bag> positive;
	ArrayList<Bag> negative;
	Bag universe;
	
	Operation(Bag universe) {
		this.universe = universe;
		this.positive = new ArrayList<Bag>();
		this.positive.add(universe);
		this.negative = new ArrayList<Bag>();
	}
	
	@SuppressWarnings("unchecked")
	Bag result() {
		ArrayList<Bag> positiveBags = (ArrayList<Bag>)this.positive.clone();
		ArrayList<Bag> negativeBags = (ArrayList<Bag>)this.negative.clone();
		Bag inter = Bag.smallest(positiveBags);
		positiveBags.remove(inter);
		while (!positiveBags.isEmpty()) {
			Bag other = Bag.smallest(positiveBags);
			inter.retainAll(other);
			positiveBags.remove(other);
		}
		while (!negativeBags.isEmpty()) {
			Bag other = Bag.biggest(negativeBags);
			inter.removeAll(other);
			negativeBags.remove(other);
		}
		return inter;
	}
}
