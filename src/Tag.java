import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Tag {

	static Hashtable<String, ArrayList<Pic>> extractTag(ArrayList<Pic> data) {
		Hashtable<String, ArrayList<Pic>> tags = new Hashtable<String, ArrayList<Pic>>();
		return tags;

		/*for (Pic pic : data) {
			for (String tag : pic.tags) {
				if (!tags.containsKey(tag)) {
					tags.put(tag, new ArrayList<Pic>());
				}
				ArrayList<Pic> pics = tags.get(tag);
				pics.add(pic);
				tags.put(tag, pics);
			}

		}

		return tags;*/

	}

}
