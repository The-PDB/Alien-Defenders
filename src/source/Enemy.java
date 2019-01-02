package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Date;

public class Enemy extends GameObject {
	int enemyNum;
	Rectangle colBox;
	eBullets eb;
	Date startTime;
	Boolean drawShip = true;
	Date currentTime;
	Boolean drawBullet = false;
	static final int colBoxSize = 100;

	Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	public void setEnemyNum(int enemyNum) {
		this.enemyNum = enemyNum;
		if (enemyNum == 1) {
			eb = new eBullets(enemyNum, 70, 90, 10, 10);
			eb.setEnemyNum(1);
			eb.update();
		}
		if (enemyNum == 2) {
			eb = new eBullets(enemyNum, 70, 310, 10, 10);
			eb.setEnemyNum(2);
			eb.update();
		}
		if (enemyNum == 3) {
			eb = new eBullets(enemyNum, 495, 60, 10, 10);
			eb.setEnemyNum(3);
			eb.update();
		}
		if (enemyNum == 4) {
			eb = new eBullets(enemyNum, 920, 90, 10, 10);
			eb.setEnemyNum(4);
			eb.update();
		}
		if (enemyNum == 5) {
			eb = new eBullets(enemyNum, 920, 310, 10, 10);
			eb.setEnemyNum(5);
			eb.update();
		}
		startTime = new Date();
		int colBoxX = (x + width)/2 - (colBoxSize/2);
		int colBoxY = (y + height)/2 - (colBoxSize/2);
		colBox = new Rectangle(colBoxX, colBoxY, colBoxSize/2, colBoxSize/2);
	}

	void update() {
		super.update();
		currentTime = new Date();
		if (drawShip && currentTime.getTime() - startTime.getTime() > 1000) {
			drawBullet = true;

			if (drawShip && currentTime.getTime() - startTime.getTime() > 2000) {
				drawShip = false;
				Alive = false;
			}
		}
		if (drawBullet) {
			eb.update();
			if (eb.y < 0 || eb.y > AlienDefenders.height) {
				Alive = false;
			}
		}

	}

	void draw(Graphics g) {
		if (drawShip) {
			g.drawImage(GamePanel.enemy, x, y, width, height, null);
			g.setColor(Color.BLACK);
			g.drawRect(colBox.x, colBox.y, colBox.width, colBox.height);
		}

		if (drawBullet) {
			eb.draw(g);
		}
	}

}
