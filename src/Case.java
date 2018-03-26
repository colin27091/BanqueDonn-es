import java.awt.Graphics;

public class Case {
	
	int x,y,largeur,longueur;
	Pic img;
	
	Case(int x, int y, int largeur, int longueur){
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.longueur = longueur;
	}
	
	public void setImage(Pic img){
		this.img = img; 
	}
	
	public void paint(Graphics g)  {
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
