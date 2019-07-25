import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip ship;
	//Projectile  chip;
	ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
	
	ArrayList<Alian> Alians= new ArrayList<Alian>();
	
	Random ran = new Random();
	
	
	
	
	
	
	
	
	
	
	ObjectManager(RocketShip rick){
		ship = rick;
	
		
		
	}
	void addProjectile(Projectile  chip){
		projectiles.add(chip)		;
	}
	void addAlian() {
		Alians.add(new Alian(ran.nextInt(LeagueInvaders.WIDTH),0,50,50));
		
	}
	
	void update() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Projectile
}
