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

	public BufferedImage turrentBarrel;

	Color[] barrel = { Color.BLACK, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE };

	GamePanel() {
		try {
			turrentBarrel = ImageIO.read(this.getClass().getResourceAsStream("TurrentBase"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	int current = menu;

	public void paintComponent(Graphics g) {
		Graphics2D img2d = turrentBarrel.createGraphics();
		img2d.rotate(90);
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
		System.out.println("completed");
	}

	void drawGame(Graphics g) {
		g.setColor(new Color(0x66EEFF));
		g.fillRect(0, 0, AlienDefenders.width, AlienDefenders.height);
		g.setColor(Color.RED);
		g.fillOval(AlienDefenders.width / 2 - 50, AlienDefenders.height - grassHeight - 50, 100, 100);
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
