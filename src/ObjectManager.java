import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	RocketShip ship;
	// Projectile chip;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	ArrayList<Alian> alians = new ArrayList<Alian>();

	Random ran = new Random();

	ObjectManager(RocketShip rick) {
		ship = rick;

	}

	void addProjectile(Projectile chip) {
		projectiles.add(chip);
	}

	void addAlian() {
		alians.add(new Alian(ran.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	void update() {
		for (int i = 0; i < alians.size(); i++) {
			Alian allen = alians.get(i);
allen.update();
			if (allen.y >= LeagueInvaders.HEIGHT) {
				allen.isActive = false;

			}
				
		}
		
		
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile proSkillz = projectiles.get(i);
			proSkillz.update();
			if (proSkillz.y <= 0) {
				proSkillz.isActive = false;
			}

		}
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile proSkillz = projectiles.get(i);
			proSkillz     .draw(g);
			if (proSkillz.y <= 0) {
				proSkillz.isActive = false;
	
			}

		}
		for (int i = 0; i < alians.size(); i++) {
			Alian allen = alians.get(i);
			allen.draw(g);
			if (allen.y >= LeagueInvaders.HEIGHT) {
				allen.isActive = false;
				
			}

		}
	}
	
	void purgeObjects() {
		for (int i = 0; i < alians.size(); i++) {
			Alian allen = alians.get(i);

			if (allen.y >= LeagueInvaders.HEIGHT) {
				allen.isActive = false;
				
			}
			if (allen.isActive == false) {
				alians.remove(i);
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
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlian();
	}}
