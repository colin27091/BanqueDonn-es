import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Scanner;

public class Model extends Observable {

	ArrayList<Pic> data;

	Model() {
		data = new ArrayList<Pic>();

	}

	void setTag() {
		try {
			
			File f = new File(System.getProperty("user.home")+"/.pictag");
			FileReader pictag = new FileReader(f);
			BufferedReader r = new BufferedReader(pictag);
			String line = r.readLine();
			Scanner scan = new Scanner(r);

			while (line != null) {
				System.out.println(scan);
				String[] imageTag = line.split(":");
				String img = imageTag[0];
				String Alltag = imageTag[1];
				System.out.println(img);
				String[] tags = Alltag.split(",");
				for (int i2 = 0; i2 < tags.length; i2++) {
					String tag = tags[i2];
					System.out.println(tags[i2]);

				}

				line = r.readLine();
			}
			r.close();
		} catch (Exception e) {
			System.out.println("Erreur");
			throw new Error(e);
		}
	}

	void setData(ArrayList<Pic> newfilter) {

		if (!newfilter.equals(this.data)) {
			this.data = newfilter;
			this.setChanged();
			this.notifyObservers(newfilter);
		}
	}

}
