
public class ObjectManager {
	RocketShip ship;
	Projectile chip;
	
	
	ObjectManager(){
		ship = new RocketShip(250, 500, 50, 50);
		chip = new Projectile(250, 200,50,50);
		
	}
	
}
