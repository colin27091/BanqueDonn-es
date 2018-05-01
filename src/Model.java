import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;

public class Model extends Observable{ 
	
	
	ArrayList<Pic> data;
	ArrayList<Pic> filter;
	
	Model() {
		
		data = new ArrayList<Pic>();
		data = new ArrayList<Pic>();

		
	}

	void setData(ArrayList<Pic> newfilter) {

		if( ! newfilter.equals(this.data)) {
			this.filter = newfilter;
		}
		this.notifyObservers(this.filter);
	}
	
	
	
}
