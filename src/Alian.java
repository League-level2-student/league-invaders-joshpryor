import java.awt.Color;
import java.awt.Graphics;

public class Alian extends GameObject {

	int speed = 1;
	
	Alian(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update(){
		y+=speed ;
		
	}
	
	void draw( Graphics g ) {
	    g.setColor(Color.YELLOW);
	    g.fillRect(x, y, width, height);
		
	    
	}
	

}
