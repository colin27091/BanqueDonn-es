import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		Application app = new Application();
		Model m = new Model();
		new Control(app, m);
		m.addObserver(app);
		
	}

}
