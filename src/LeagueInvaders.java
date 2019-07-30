import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame window;

	GamePanel panal;

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	public static void main(String[] args) {
		LeagueInvaders ned = new LeagueInvaders();

		ned.setup();

	}

	LeagueInvaders() {
		window = new JFrame();
		panal = new GamePanel();
	}

	void setup() {
		window.setVisible(true);
		window.setSize(WIDTH, HEIGHT);
		window.add(panal);
		window.addKeyListener(panal);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}