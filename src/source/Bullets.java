package source;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullets extends GameObject {
	int barrelNum;
	boolean Alive = true;
	Rectangle colBox;
	boolean miss = true;

	public void setBarrelNum(int barrelNum) {
		this.barrelNum = barrelNum;
	}

	Bullets(int x, int y, int width, int height) {
		super(x, y, width, height);
		colBox = new Rectangle(x, y, width, height);
	}

	void update() {
		super.update();

		if (barrelNum == 1) {
			y = y - 1;
			x = x - 2;
		} else if (barrelNum == 2) {
			y = y - 2;
			x = x - 2;
		} else if (barrelNum == 3) {

			y = y - 2;
		} else if (barrelNum == 4) {
			y = y - 2;
			x = x + 2;
		} else if (barrelNum == 5) {
			y = y - 1;
			x = x + 2;
		}
		colBox.setBounds(x, y, width, height);
		if (y < -50) {
			Alive = false;
			miss  = false;
		}
	}

	void draw(Graphics g) {

		g.drawImage(GamePanel.bullets, x, y, width, height, null);

	}
}
