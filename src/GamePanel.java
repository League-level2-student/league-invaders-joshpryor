import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.sql.Time;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	// GamePanel nick = new GamePanel();

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	Timer alienSpawn;

	Timer frameDraw;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	RocketShip ship = new RocketShip(250, 700, 50, 50);
	int currentState = MENU;
	ObjectManager Manager = new ObjectManager(ship);

	void updateMenuState() {
	}

	void updateGameState() {
		Manager.update();
		if (!ship.isActive) {
			currentState = END;
		}
	}
		
	void updateEndState() {
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

	GamePanel() {
		tileFont = new Font("Arial", Font.PLAIN, 48);
		ohHi = new Font("Arial", Font.PLAIN, 10);
		purpur = new Font("Arial", Font.PLAIN, 28);
		// frameDraw = new Timer(1000/60, this);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage("space.png");
		}
	}

	void startGame() {
	    alienSpawn = new Timer(1000 , Manager);
	    alienSpawn.start();
		
	}
	
	void endGame() {
		alienSpawn.stop();
		
	}
	
	

	Font ohHi;
	Font tileFont;
	Font purpur;

	@Override
	public void paintComponent(Graphics g) {
		// update state
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
		// update state
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setFont(tileFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 125);
		g.setFont(purpur);
		g.drawString("press ENTER to start", 100, 300);
		g.setFont(ohHi);
		g.drawString(" oh hi =) ", 100, 700);
	}

	void drawGameState(Graphics g) {
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		Manager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(tileFont);
		g.drawString("Game Over", 100, 100);
		g.setFont(purpur);
		g.drawString("you killed " + Manager.getScore() + " enemies", 120, 342);
		g.drawString("press ENTER to restart", 100, 540);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// update state
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// update state
	
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				
				 ship = new RocketShip(250, 700, 50, 50);
				 Manager = new ObjectManager(ship);
				
				currentState = MENU;
			}
			
			else {
				currentState++;
			}
			
			if (currentState == END) {
				endGame();
			}
			if (currentState == GAME) {
				startGame();
			
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Manager.addProjectile(ship.getProjectile());
		}
		
		
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			if (Manager.ship.y >= 0) {
				Manager.ship.y = Manager.ship.y - Manager.ship.speed;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			if (Manager.ship.x >= 0) {
				Manager.ship.x = Manager.ship.x - Manager.ship.speed;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			if (Manager.ship.x <= 450) {
				Manager.ship.x = Manager.ship.x + Manager.ship.speed;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			if (Manager.ship.y <= 750) {
				Manager.ship.y = Manager.ship.y + Manager.ship.speed;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
