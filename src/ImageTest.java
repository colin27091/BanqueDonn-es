import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ImageTest {
	String imagePath = "images/";
	
	@Test
	public void testFromFolder() throws Exception {
		ArrayList<Image> imgs = Image.fromFolder(imagePath);
		assertTrue(imgs.size() != 0);
		System.out.println(imgs);
		System.out.println(imgs.size());
	}

}
