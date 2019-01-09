package source;

import java.awt.Graphics;
import java.awt.Rectangle;

public class eBullets extends GameObject {
	int enemyNum;
	boolean Alive = true;
	Rectangle colBox;

	eBullets(int enemyNum, int x, int y, int width, int height) {
		super(x, y, width, height);
		colBox = new Rectangle(x, y, width, height);
	}

	public void setEnemyNum(int enemyNum) {
		this.enemyNum = enemyNum;
	}

	void update() {
		super.update();

		if (enemyNum == 1) {
			y = y + 2;
			x = x + 2;
		} else if (enemyNum == 2) {
			y = y + 1;
			x = x + 2;
		} else if (enemyNum == 3) {

			y = y + 2;
		} else if (enemyNum == 4) {
			y = y + 2;
			x = x - 2;
		} else if (enemyNum == 5) {
			y = y + 1;
			x = x - 2;
		}
		colBox.setBounds(x, y, width, height);
		
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.eBullet, x, y, width, height, null);
	}

}
