package sorce;

import java.awt.Graphics;

public class Enemy extends GameObject {

	Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void update() {
		super.update();
		
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.enemy, x, y, width, height, null);
	}

}
