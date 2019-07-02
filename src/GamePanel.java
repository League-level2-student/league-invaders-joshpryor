import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	//GamePanel nick = new GamePanel();
	
	
    final int MENU = 0;
    final int GAME = 1;
	final int END = 2;


	int currentState = MENU;
	
    void updateMenuState(){}void updateGameState(){}void updateEndState(){}

    GamePanel(){
    	tileFont = new Font("Arial", Font.PLAIN, 48);
    	
    	purpur = new Font("Arial", Font.PLAIN, 28);
    	
    }
    
    Font tileFont;
	Font purpur;
	@Override
	public void paintComponent(Graphics g){
		
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}
		else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	 void drawMenuState(Graphics g) { 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 
		 g.setFont(tileFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 20,125);
		 g.setFont(purpur);
		 g.drawString("press ENTER to start", 140, 300);
		 g.drawString("press SPACE for instructions", 100, 500);
		 }
	 
	 void drawGameState(Graphics g) { 
		 
	 }
	 
	 void drawEndState(Graphics g)  { 
		 
	 }
	 
	
	
	
}
