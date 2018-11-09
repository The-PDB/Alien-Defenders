package sorce;

import java.awt.Graphics;

public class Bullets extends GameObject {


	Bullets(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

void update() {
	super.update();
	
	if(gp.barrelNum == 1) {
		
	}
	else if(gp.barrelNum == 2) {
			
	}
	else if(gp.barrelNum == 3) {
		y-= 20;
	}
	else if(gp.barrelNum == 4) {
				
	}
	else if(gp.barrelNum == 5) {
					
	}
	
}

void draw(Graphics g) {
	g.drawImage(gp.bullets, x, y, width, height, null);
}
}
