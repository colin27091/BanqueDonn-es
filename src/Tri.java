import java.util.ArrayList;
import java.util.Hashtable;

public class Tri {
	
	
	/*Tri Date Croissante (plus recent au plus vieux)*/
	static ArrayList<Pic> dateC(ArrayList<Pic> oldfilter) {
		ArrayList<Pic> newfilter = new ArrayList<Pic>();
		while(oldfilter.size() != 1) {
			int max = 0; /*index du max */
			for(int i = 1; i<oldfilter.size(); i++) {
				if(oldfilter.get(i).date.compareTo(oldfilter.get(max).date) == 1) {
					max = i;
				}
			}
			newfilter.add(oldfilter.get(max));
			oldfilter.remove(max);
		}
		newfilter.add(oldfilter.get(0));

		return newfilter;
	}

	/*Tri Date Decroissante (plus vieux au plus recent)*/
	static ArrayList<Pic> dateD(ArrayList<Pic> oldfilter) {
		ArrayList<Pic> newfilter = new ArrayList<Pic>();
		while(oldfilter.size() != 1) {
			int min = 0; /*index du max */
			for(int i = 1; i<oldfilter.size(); i++) {
				if(oldfilter.get(i).date.compareTo(oldfilter.get(min).date) == -1) {
					min = i;
				}
			}
			newfilter.add(oldfilter.get(min));
			oldfilter.remove(min);
		}
		newfilter.add(oldfilter.get(0));

		return newfilter;
	}
	
	/*Tri Nom Croissant (ordre alphabetique) */
	static ArrayList<Pic> nomC(ArrayList<Pic> oldfilter) {
		ArrayList<Pic> newfilter = new ArrayList<Pic>();
		
		return newfilter;
	}
	
	/*Tri Nom Decroissant (inverse alphabetique)*/
	static ArrayList<Pic> nomD(ArrayList<Pic> oldfilter) {
		ArrayList<Pic> newfilter = new ArrayList<Pic>();
		return newfilter;
	}
	
	/*Tri Taille Croissante (plus petite a plus grande)*/
	static ArrayList<Pic> tailleC(ArrayList<Pic> oldfilter) {
		ArrayList<Pic> newfilter = new ArrayList<Pic>();
		return newfilter;
	}
	
	/*Tri Taille Decroissante (plus grande a plus petite)*/
	static ArrayList<Pic> tailleD(ArrayList<Pic> oldfilter) {
		ArrayList<Pic> newfilter = new ArrayList<Pic>();
		return newfilter;
	}
}
