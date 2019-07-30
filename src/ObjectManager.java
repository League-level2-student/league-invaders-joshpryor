import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip ship;
	// Projectile chip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	ArrayList<Alian> Alians = new ArrayList<Alian>();

	Random ran = new Random();

	ObjectManager(RocketShip rick) {
		ship = rick;

	}

	void addProjectile(Projectile chip) {
		projectiles.add(chip);
	}

	void addAlian() {
		Alians.add(new Alian(ran.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	void update() {
		for (int i = 0; i < Alians.size(); i++) {
			Alian allen = Alians.get(i);

			if (allen.y >= LeagueInvaders.HEIGHT) {
				allen.isActive = false;

			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile proSkillz = projectiles.get(i);
			if (proSkillz.y <= 0) {
				proSkillz.isActive = false;
			}

		}
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile proSkillz = projectiles.get(i);
			ship.draw(g);
			if (proSkillz.y <= 0) {
				proSkillz.isActive = false;
	
			}

		}
		for (int i = 0; i < Alians.size(); i++) {
			Alian allen = Alians.get(i);
			allen.draw(g);
			if (allen.y >= LeagueInvaders.HEIGHT) {
				allen.isActive = false;
				
			}

		}
	}
	
	void purgeObjects() {
		for (int i = 0; i < Alians.size(); i++) {
			Alian allen = Alians.get(i);

			if (allen.y >= LeagueInvaders.HEIGHT) {
				allen.isActive = false;
				
			}
			if (allen.isActive == false) {
				Alians.remove(i);
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			Projectile proSkillz = projectiles.get(i);
			if (proSkillz.y <= 0) {
				proSkillz.isActive = false;
			}
			if (proSkillz.isActive == false) {
				projectiles.remove(i);
			}
			
			
	}
	// Projectile
}}
