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

	static final int grassHeight = 200;

	public BufferedImage turrentBase;

	public BufferedImage turrentBarrel1;

	public BufferedImage turrentBarrel2;

	public BufferedImage turrentBarrel3;

	public BufferedImage turrentBarrel4;

	public BufferedImage turrentBarrel5;

	BufferedImage[] barrel = { turrentBarrel1, turrentBarrel2, turrentBarrel3, turrentBarrel4, turrentBarrel5 };

	GamePanel() {

		try {
			turrentBase = ImageIO.read(this.getClass().getResourceAsStream("TurrentBase.png"));
			turrentBarrel1 = ImageIO.read(this.getClass().getResourceAsStream("TurrentBarrel.png"));
			turrentBarrel2 = ImageIO.read(this.getClass().getResourceAsStream("TurrentBarrel.png"));
			turrentBarrel3 = ImageIO.read(this.getClass().getResourceAsStream("TurrentBarrel.png"));
			turrentBarrel4 = ImageIO.read(this.getClass().getResourceAsStream("TurrentBarrel.png"));
			turrentBarrel5 = ImageIO.read(this.getClass().getResourceAsStream("TurrentBarrel.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	int current = menu;

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

		}

		if (e.getKeyCode() == KeyEvent.VK_Q) {

		}

		if (e.getKeyCode() == KeyEvent.VK_W) {

		}

		if (e.getKeyCode() == KeyEvent.VK_E) {

		}

		if (e.getKeyCode() == KeyEvent.VK_D) {

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
