import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;

public class Model extends Observable{ 
	
	
	Hashtable<Integer, Pic> data;
	Hashtable<Integer, Pic> filter;
	
	Model() {
		
		data = new Hashtable<Integer, Pic>();
		data = new Hashtable<Integer, Pic>();

		
	}
	
	void setData(Hashtable<Integer, Pic> newfilter) {
		if( ! newfilter.equals(this.data)) {
			this.filter = newfilter;
		}
		this.notifyObservers(this.filter);
	}
	
	
	
}
