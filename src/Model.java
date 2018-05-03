import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;

public class Model extends Observable{ 
	
	
	ArrayList<Pic> data;
	Hashtable<String, ArrayList<Pic>> tags;
	
	
	Model() {
		data = new ArrayList<Pic>();
		
	}

	void setData(ArrayList<Pic> newfilter) {

		if( ! newfilter.equals(this.data)) {
			this.data = newfilter;
			this.setChanged();
			this.notifyObservers(newfilter);
		}
	}
	
	
	
}
