import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tag {
	
	
	ArrayList<Pic> pics = Pic.fromFiles(new File("images/"));
	
	public static void LectureTag() {
		
		Tag t = new Tag();
		
		
		
		
		try {
			
			File f = new File("C:\\Users\\Quentin\\Documents\\projetjava\\.pictag.txt");
			FileWriter nomimg = new FileWriter(f, false);
			BufferedWriter bf = new BufferedWriter(nomimg);
			PrintWriter pw = new PrintWriter(bf, false);
			for(int i=0; i<t.pics.size() ;i++) {
				String name = t.pics.get(i).name;
				pw.println( name + ":");
				
				}
			pw.close();
			
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
				for(int i2=0; i2<tags.length; i2++) {
					String tag = tags[i2];
					System.out.println(tags[i2]);

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
