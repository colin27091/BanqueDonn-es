import java.util.ArrayList;
import java.util.HashSet;

public class Bag extends HashSet<Pic> {
	boolean negative = false;
	Bag() {
		super();
	}

	static Bag smallest(ArrayList<Bag> bags) {
		if (bags.size() == 0) return new Bag();
		Bag min = bags.get(0);
		int minsize = min.size();
		for (int i = 1; i < bags.size(); i++) {
			Bag here = bags.get(i);
			int heresize = here.size();
			if (heresize < minsize) {
				minsize = heresize;
				min = here;
			}
		}
		return min;
	}
	
	static Bag biggest(ArrayList<Bag> bags) {
		if (bags.size() == 0) return new Bag();
		Bag max = bags.get(0);
		int maxsize = max.size();
		for (int i = 1; i < bags.size(); i++) {
			Bag here = bags.get(i);
			int heresize = here.size();
			if (heresize > maxsize) {
				maxsize = heresize;
				max = here;
			}
		}
		return max;
	}
}
