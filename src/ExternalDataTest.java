import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExternalDataTest {

	String testpath1 = "tests/ExternalData/test1.xml";
	ExternalData ed;
	
	@Before
	public void init() {
		ed = new ExternalData();
		ed.folderPath = "/foo/bar/bleh";
	}
	
	@Test
	public void testExternalData() {
	}

	@Test
	public void testSaveAndLoadData() throws Exception {
		ed.saveData(testpath1);
		ExternalData ed2 = ExternalData.loadData(testpath1);
		assertEquals(ed2.folderPath, ed.folderPath);
	}
}
