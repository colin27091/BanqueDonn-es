import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Control implements WindowListener {
	String folderPath;
	String configFile;
	Model model;
	
	Control(String configFile) throws Exception {
		this.configFile = configFile;
		this.loadExternalData();
	}
	
	void saveExternalData() throws Exception {
		ExternalData ed = new ExternalData();
		ed.folderPath = this.folderPath;
		ed.saveData(this.configFile);
	}
	
	void loadExternalData() throws Exception {
		ExternalData ed = ExternalData.loadData(this.configFile);
		this.folderPath = ed.folderPath;
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try {
			this.saveExternalData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
