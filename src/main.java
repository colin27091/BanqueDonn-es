
public class main {

	public static void main(String[] args) {
		System.out.println("projet java");
		String configFile = "config.xml";
		Control control = new Control(configFile);
		Model model = new Model(control);
	}

}
