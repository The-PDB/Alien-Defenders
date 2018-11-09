package sorce;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	Font titlefont = new Font("Ariel", Font.PLAIN, 48);
	Font subfont = new Font("Ariel", Font.PLAIN, 24);

	final int menu = 0;

	final int game = 1;

	final int end = 2;

	int turrentIndex = 0;

	int barrelNum = 1;

	static final int grassHeight = 200;

	public BufferedImage turrentBase;
	
	public BufferedImage bullets;

	int barrelH = 90;
	int barrelW = 126;

	BufferedImage[] barrel = new BufferedImage[5];

	GamePanel() {

		try {
			turrentBase = ImageIO.read(this.getClass().getResourceAsStream("TurrentBase.png"));
			barrel[0] = ImageIO.read(this.getClass().getResourceAsStream("Barrel1.png"));
			barrel[1] = ImageIO.read(this.getClass().getResourceAsStream("Barrel2.png"));
			barrel[2] = ImageIO.read(this.getClass().getResourceAsStream("Barrel3.png"));
			barrel[3] = ImageIO.read(this.getClass().getResourceAsStream("Barrel4.png"));
			barrel[4] = ImageIO.read(this.getClass().getResourceAsStream("Barrel5.png"));
			bullets = ImageIO.read(this.getClass().getResourceAsStream("Bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	int current = menu;

	@Override
	public void paintComponent(Graphics g) {

		if (current == menu) {
			drawMenu(g);

		}
		if (current == game) {
			drawGame(g);

		}
		if (current == end) {
			drawEnd(g);
		}
		repaint();
	}

	void drawMenu(Graphics g) {
		g.setColor(new Color(0x66EEFF));
		g.fillRect(0, 0, AlienDefenders.width, AlienDefenders.height);
		g.setColor(Color.BLACK);
		g.setFont(titlefont);
		g.drawString("Alien Defenders", 300, 200);
		g.setFont(subfont);
		g.drawString("Press Enter To Start", 375, 300);
	}

	void drawGame(Graphics g) {

		Graphics2D img2d = (Graphics2D) g;

		g.setColor(new Color(0x66EEFF));
		g.fillRect(0, 0, AlienDefenders.width, AlienDefenders.height);
		
		Bullets b = new Bullets(450, 480, 100, 100);
		
		if (barrelNum == 1) {
			g.drawImage(barrel[0], 380, 460, 126, 90, null);
			b.draw(g);
		} else if (barrelNum == 2) {
			g.drawImage(barrel[1], 390, 455, 126, 90, null);
			b.draw(g);
		} else if (barrelNum == 3) {
			g.drawImage(barrel[2], 435, 435, 126, 90, null);
			b.draw(g);
		} else if (barrelNum == 4) {
			g.drawImage(barrel[3], 480, 450, 126, 90, null);
			b.draw(g);
		} else if (barrelNum == 5) {
			g.drawImage(barrel[4], 485, 465, 126, 90, null);
			b.draw(g);
		}
		
		g.drawImage(turrentBase, 440, 491, 119, 114, null);
		
		

		g.setColor(new Color(0x00FF00));
		g.fillRect(0, AlienDefenders.height - grassHeight, AlienDefenders.width, grassHeight);

	}

	void drawEnd(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, AlienDefenders.width, AlienDefenders.height);
		g.setColor(Color.RED);
		g.setFont(titlefont);
		g.drawString("You Died", 300, 200);
		g.setFont(subfont);
		g.drawString("Score: ", 375, 300);
		g.drawString("Highscore: ", 375, 350);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_A) {
			barrelNum = 1;
		}

		else if (e.getKeyCode() == KeyEvent.VK_Q) {
			barrelNum = 2;
		}

		else if (e.getKeyCode() == KeyEvent.VK_W) {
			barrelNum = 3;
		}

		else if (e.getKeyCode() == KeyEvent.VK_E) {
			barrelNum = 4;
		}

		else if (e.getKeyCode() == KeyEvent.VK_D) {
			barrelNum = 5;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (current == menu) {
				current = game;

			} else if (current == game) {
				current = end;

			}
		}
	}

}
