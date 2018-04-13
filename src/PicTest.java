import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

public class PicTest {
	String imagePath = "images/";
	
	@Test
	public void testFromFolder() throws Exception {
		File folder = new File(imagePath);
		ArrayList<Pic> imgs = Pic.fromFiles(folder.listFiles());
		assertTrue(imgs.size() != 0);
		System.out.println(imgs);
		System.out.println(imgs.size());
	}

}
