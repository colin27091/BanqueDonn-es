import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

	void setTag(ArrayList<Pic> pics) {
		File pictag = new File(System.getProperty("user.home") + "/.pictag");
		if (!pictag.exists()) {
			try {
				pictag.createNewFile();
				try {

					FileReader fr = new FileReader(pictag);
					BufferedReader r = new BufferedReader(fr);
					String line = r.readLine();

				} catch (Exception e) {

				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {

			try {

				FileReader picta = new FileReader(pictag);
				BufferedReader r = new BufferedReader(picta);
				String line = r.readLine();

				for (Pic pic : pics) {
					pic.tags = new ArrayList<String>();
					while (line != null) {
						if (line.split(":")[0] == pic.name) {
							String All_tag = line.split(":")[1];
							String[] tags = All_tag.split(",");
							for (String tag : tags) {
								pic.tags.add(tag);
							}
						}

						line = r.readLine();
					}
					r.close();
				}
			} catch (Exception e) {
				System.out.println("Erreur");
				throw new Error(e);
			}

		}
		this.setData(pics);

	}

	void setData(ArrayList<Pic> newfilter) {

		if (!newfilter.equals(this.data)) {
			this.data = newfilter;
			this.setChanged();
			this.notifyObservers(newfilter);
		}
	}

}
