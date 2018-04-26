import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) throws IOException{
		Vue app = new Vue();
		Model m = new Model();
		new Control(app, m);
		m.addObserver(app);
		
		
		
		File f = new File("images/.pictag");
		
		
		/*if(f.exists()) {
			System.out.println();
		}*/
		FileReader fr = new FileReader(f);
		
		//static ArrayList<String> searchtag()
		System.out.println(f.exists());
		BufferedReader br = new BufferedReader(fr);
		try {
		    String line = br.readLine();
		    while (line != null) {
		    	String[] split = line.split(":");
		    	System.out.println(split[0] == "image1");
		    	if(split[0] == "image1") {
		    		System.out.println("tag trouvé");
		    	}
		    	line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
	}

}
