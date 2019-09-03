import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RocketShip extends GameObject {
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
		    loadImage ("rocket.png");
		}
		// TODO Auto-generated constructor stub
		speed = 30;

	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	    Projectile getProjectile() {
	        return new Projectile(x+width/2, y, 10, 10);
	
	    
	}
	public void up() {
		x += speed;
	}

	public void down() {
		x += speed;
	}

	public void left() {
		x += speed;
	}

	public void right() {
		x += speed;
	}

	void draw(Graphics g) {
		super.draw(g);
	
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

}
