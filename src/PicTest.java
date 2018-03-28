import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PicTest {
	String imagePath = "images/";
	
	@Test
	public void testFromFolder() throws Exception {
		ArrayList<Pic> imgs = Pic.fromFolder(imagePath);
		assertTrue(imgs.size() != 0);
		System.out.println(imgs);
		System.out.println(imgs.size());
	}

}
