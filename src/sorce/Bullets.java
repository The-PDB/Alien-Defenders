package sorce;

import java.awt.Graphics;


public class Bullets extends GameObject {
	int barrelNum;
	
	public void setBarrelNum(int barrelNum) {
		this.barrelNum = barrelNum;
	}

	Bullets(int x, int y, int width, int height) {
		
		super(x, y, width, height);
	}

void update() {
	super.update();
	
	if(barrelNum == 1) {
		y = y - 1;
		x = x - 2;
	}
	else if(barrelNum == 2) {
		y = y - 1;
		x = x - 1;
	}
	else if(barrelNum == 3) {
		
		y = y - 1;
	}
	else if(barrelNum == 4) {
		y = y - 1;
		x = x + 1;
	}
	else if(barrelNum == 5) {
		y = y - 1;
		x = x + 2;
	}
	
}





void draw(Graphics g) {
	g.drawImage(gp.bullets, x, y, width, height, null);
	
}
}
