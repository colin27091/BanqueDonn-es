import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import application.tag;

public class Tag {
	
	public static void LectureTag() {
		try {
			File f = new File("C:\\Users\\Quentin\\Documents\\projetjava\\.pictag.txt");
			FileReader pictag = new FileReader(f);
			BufferedReader r = new BufferedReader(pictag);
			String line = r.readLine();
			Scanner scan = new Scanner(r);
			
			while ( line != null) {
				System.out.println(scan);
				String[] imageTag = line.split(":");
				String img = imageTag[0];
				String Alltag = imageTag[1];
				System.out.println(img);
				String[] tags = Alltag.split(",");
				for(int i=0; i<tags.length; i++) {
					String tag = tags[i];
					System.out.println(tags[i]);

				}

				line = r.readLine();
			}
			r.close();
		}catch (Exception e) {
			System.out.println("Erreur");
			throw new Error(e);
		}

	}

	public static void main(String[] args) {
		Tag.LectureTag();

	}

}
