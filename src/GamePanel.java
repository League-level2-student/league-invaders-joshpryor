import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener , KeyListener{
	//GamePanel nick = new GamePanel();
	
	
    final int MENU = 0;
    final int GAME = 1;
	final int END = 2;

	Timer frameDraw ;
	
	
	
	
	
	
	
	int enimisKilld = 0;
	RocketShip ship = new RocketShip(250, 700, 50, 50);
	int currentState = MENU;
	
    void updateMenuState(){}
    
    void updateGameState(){}
    
    void updateEndState(){}

    GamePanel(){
    	tileFont = new Font("Arial", Font.PLAIN, 48);
    	ohHi = new Font ("Arial", Font.PLAIN, 10);
    	purpur = new Font("Arial", Font.PLAIN, 28);
    	//frameDraw = new Timer(1000/60, this);
    	frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
    }
    Font ohHi;
    Font tileFont;
	Font purpur;
	@Override
	public void paintComponent(Graphics g){
		//update state
		if(currentState == MENU){drawMenuState(g);}
		else if(currentState == GAME){drawGameState(g);}
		else if(currentState == END){drawEndState(g);}
		//update state
	}
	
	 void drawMenuState(Graphics g) { 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 
		 g.setFont(tileFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 20,125);
		 g.setFont(purpur);
		 g.drawString("press ENTER to start", 100, 300);
		 g.drawString("press SPACE for instructions", 50, 500);
		 g.setFont(ohHi);
		 g.drawString(" oh hi =) ", 100 , 700);
		 }
	 
	 void drawGameState(Graphics g) { 
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	
		 ship.draw(g);
		 
		 
		 
		 
	 }
	 
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setColor(Color.YELLOW);
		 g.setFont(tileFont);
		 g.drawString("Game Over", 100, 100);
		 g.setFont(purpur);
		 g.drawString("you killed " + enimisKilld + " enemies", 120, 342);
		 g.drawString("press ENTER to restart", 100, 540);
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		//update state
	    if(currentState == MENU){updateMenuState(); }else if(currentState == GAME){updateGameState();}else if(currentState == END){updateEndState();}
	    //update state
	    System.out.println();
	    repaint();
	    
	    
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    if (ship.y >= 0) {
		    	ship.y = ship.y - ship.speed;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    if (ship.x >= 0) {
		    	ship.x = ship.x - ship.speed;
		    }
		    
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    if (ship.x <= 450) {
		    ship.x = ship.x + ship.speed;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    if (ship.y <= 750) {
		    ship.y = ship.y + ship.speed;
		    }
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	
	
	
}
