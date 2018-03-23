import java.awt.Graphics;

public class Case {
	
	int x,y,largeur,longueur;
	Image img;
	
	Grille(int x, int y, int largeur, int longueur){
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.longueur = longueur;
	}
	
	public void setImage(Image img){
		this.img = img; 
	}
	
	public void paint(Graphics g)  {
		g.drawImage(img, arg1, arg2, arg3);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
