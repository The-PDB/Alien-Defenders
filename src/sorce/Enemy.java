package sorce;

import java.awt.Graphics;

public class Enemy extends GameObject {
	int enemyNum;

	Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (enemyNum == 1) {
			eBullets eb = new eBullets(enemyNum, 70, 310, 10, 10);
			eb.setEnemyNum(1);
			eb.update();
		}
		if (enemyNum == 2) {
			eBullets eb = new eBullets(enemyNum, 70, 90, 10, 10);
			eb.setEnemyNum(2);
			eb.update();
		}
		if (enemyNum == 3) {
			eBullets eb = new eBullets(enemyNum, 495, 60, 10, 10);
			eb.setEnemyNum(3);
			eb.update();
		}
		if (enemyNum == 4) {
			eBullets eb = new eBullets(enemyNum, 920, 90, 10, 10);
			eb.setEnemyNum(4);
			eb.update();
		}
		if (enemyNum == 5) {
			eBullets eb = new eBullets(enemyNum, 920, 310, 10, 10);
			eb.setEnemyNum(5);
			eb.update();
		}
		
	}

	public void setEnemyNum(int enemyNum) {
		this.enemyNum = enemyNum;
	}

	void update() {
		super.update();

	}

	void draw(Graphics g) {
		
		g.drawImage(GamePanel.enemy, x, y, width, height, null);
	}

}
