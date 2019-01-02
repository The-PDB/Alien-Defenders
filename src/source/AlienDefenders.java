package source;

import javax.swing.JFrame;

public class AlienDefenders {
	public static final int width = 1000;
	public static final int height = 800;

	public static void main(String[] args) {
		AlienDefenders ad = new AlienDefenders();

	}

	AlienDefenders() {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel gp = new GamePanel();
		f.add(gp);
		f.addKeyListener(gp);
		f.pack();
		f.setSize(width, height);

	}
}
