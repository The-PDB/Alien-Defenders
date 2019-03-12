package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	Font titlefont = new Font("Ariel", Font.PLAIN, 48);
	Font subfont = new Font("Ariel", Font.PLAIN, 24);
	Font rules = new Font("Ariel", Font.PLAIN, 24);

	Rectangle pColBox;
	
	final int menu = 0;

	final int game = 1;

	final int end = 2;

	int tickCount = 0;

	int turrentIndex = 0;

	int barrelNum = 1;

	int enemyNum = 1;

	int lastBarrel = 0;

	int fps = 1;// 60;

	boolean b3 = false;
	
	static final int playerColBox =  100;

	int lives = 0;
	
	int score = 0;
	
	int highscore = 0;

	Random r = new Random();

	ArrayList<Bullets> bList = new ArrayList<Bullets>();
	ArrayList<Enemy> eList = new ArrayList<Enemy>();

	static final int grassHeight = 200;

	private BufferedImage turrentBase;

	public static BufferedImage bullets;

	public static BufferedImage enemy;

	public static BufferedImage eBullet;

	int barrelH = 90;
	int barrelW = 126;

	private BufferedImage[] barrel = new BufferedImage[5];

	GamePanel() {

		try {
			turrentBase = ImageIO.read(this.getClass().getResourceAsStream("TurrentBase.png"));
			barrel[0] = ImageIO.read(this.getClass().getResourceAsStream("Barrel1.png"));
			barrel[1] = ImageIO.read(this.getClass().getResourceAsStream("Barrel2.png"));
			barrel[2] = ImageIO.read(this.getClass().getResourceAsStream("Barrel3.png"));
			barrel[3] = ImageIO.read(this.getClass().getResourceAsStream("Barrel4.png"));
			barrel[4] = ImageIO.read(this.getClass().getResourceAsStream("Barrel5.png"));
			bullets = ImageIO.read(this.getClass().getResourceAsStream("Bullet.png"));
			enemy = ImageIO.read(this.getClass().getResourceAsStream("enemy.png"));
			eBullet = ImageIO.read(this.getClass().getResourceAsStream("enemyBullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timer ticks = new Timer(1000 / fps, this);
		ticks.start();

	}

	int current = menu;

	@Override
	public void paintComponent(Graphics g) {

		if (current == menu) {
			drawMenu(g);

		}
		if (current == game) {
			updateGame();
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
		g.drawString("A - Shoot Left", 375, 400);
		g.drawString("Q - Shoot Upper Left", 375, 425);
		g.drawString("W - Shoot Up", 375, 450);
		g.drawString("E - Shoot Upper Right", 375, 475);
		g.drawString("D - Shoot Right", 375, 500);
		g.setFont(rules);
		g.setColor(Color.RED);
		g.drawString("Misses are displayed at the bottom. When you reach 3 misses you lose.", 100, 550);
		g.drawString("If you are hit by an alien's bullet you die.", 300, 575);
		
	}

	void updateGame() {
		if(lives >= 3) {
			current = end;
			}
		for (Bullets b : bList) {
			b.update();
			if(b.miss == false) {
				lives+=1;
				
			}
			for (Enemy e : eList) {
				if (b.colBox.intersects(e.colBox)) {
					e.Alive = false;
					b.Alive = false;
					score+=1;
				}
				
			}
		}
		for (Enemy e : eList) {
		if(e.eb.colBox.intersects(pColBox)) {
			lives+=1;
			e.eb.Alive = false;
			
		}
	}
		
		// PURGE

		for (int i = 0; i < eList.size(); i++) {
			if (!eList.get(i).Alive) {
				eList.remove(i);
			}
		}
		for (int i = 0; i < bList.size(); i++) {
			if (!bList.get(i).Alive) {
				bList.remove(i);
			}
		}

	}

	void drawGame(Graphics g) {

		g.setColor(new Color(0x66EEFF));
		g.fillRect(0, 0, AlienDefenders.width, AlienDefenders.height);
		
		

		for (Bullets b : bList) {
			b.draw(g);
		
		}
		for (Enemy e : eList) {
			e.draw(g);
			e.update();

		}

		if (barrelNum == 1) {
			g.drawImage(barrel[0], 380, 460, 126, 90, null);

		} else if (barrelNum == 2) {
			g.drawImage(barrel[1], 390, 455, 126, 90, null);

		} else if (barrelNum == 3) {
			g.drawImage(barrel[2], 435, 435, 126, 90, null);

		} else if (barrelNum == 4) {
			g.drawImage(barrel[3], 480, 450, 126, 90, null);

		} else if (barrelNum == 5) {
			g.drawImage(barrel[4], 485, 465, 126, 90, null);

		}

		g.drawImage(turrentBase, 440, 491, 119, 114, null);

		g.setColor(new Color(0x00FF00));
		g.fillRect(0, AlienDefenders.height - grassHeight, AlienDefenders.width, grassHeight);
		
		g.setFont(subfont);
		g.setColor(Color.BLACK);
		String lives2 = Integer.toString(lives);
		g.drawString("Misses: "+lives2, 500, 700);
		g.drawString("Score: "+score, 500, 675);
		
		//Player Collison Box
		int pColBoxX = 473;
		int pColBoxY = 500;
		pColBox = new Rectangle(pColBoxX, pColBoxY, playerColBox, playerColBox);
		g.setColor(Color.RED);
		

	}

	void drawEnd(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, AlienDefenders.width, AlienDefenders.height);
		g.setColor(Color.RED);
		g.setFont(titlefont);
		g.drawString("You Died", 400, 200);
		g.setFont(subfont);
		g.drawString("Score.......: " + score, 375, 300);
		if(score>=highscore) {
			highscore = score;
		}
		g.drawString("Highscore: " + highscore, 375, 325);
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
			if (lastBarrel != 1) {
				createBullet(1);
				lastBarrel = 1;
			}

		}

		else if (e.getKeyCode() == KeyEvent.VK_Q) {
			barrelNum = 2;
			if (lastBarrel != 2) {
				createBullet(2);
				lastBarrel = 2;
			}

		}

		else if (e.getKeyCode() == KeyEvent.VK_W) {
			barrelNum = 3;
			if (lastBarrel != 3) {
				createBullet(3);
				lastBarrel = 3;
			}

		}

		else if (e.getKeyCode() == KeyEvent.VK_E) {
			barrelNum = 4;
			if (lastBarrel != 4) {
				createBullet(4);
				lastBarrel = 4;
			}

		}

		else if (e.getKeyCode() == KeyEvent.VK_D) {
			barrelNum = 5;
			if (lastBarrel != 5) {
				createBullet(5);
				lastBarrel = 5;
			}

		}

	}

	private void createBullet(int barrelNum) {
		Bullets b = new Bullets(450, 480, 100, 100);

		b.setBarrelNum(barrelNum);
		bList.add(b);
	}

	private void createEnemy(int enemyNum) {
		if (enemyNum == 1) {
			Enemy e = new Enemy(0, 30, 150, 150);
			eList.add(e);
			e.setEnemyNum(1);
		} else if (enemyNum == 2) {
			Enemy e = new Enemy(0, 250, 150, 150);
			eList.add(e);
			e.setEnemyNum(2);
		} else if (enemyNum == 3) {
			Enemy e = new Enemy(425, 0, 150, 150);
			eList.add(e);
			e.setEnemyNum(3);
		} else if (enemyNum == 4) {
			Enemy e = new Enemy(850, 30, 150, 150);
			eList.add(e);
			e.setEnemyNum(4);
		} else if (enemyNum == 5) {
			Enemy e = new Enemy(850, 250, 150, 150);
			eList.add(e);
			e.setEnemyNum(5);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		lastBarrel = 0;
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (current == menu) {
				lives = 0;
				score = 0;
				bList = new ArrayList<Bullets>();
				eList = new ArrayList<Enemy>();
				current = game;
			

			} else if (current == end) {
				current = menu;

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// tickCount++;
		if (current == game) {
			int eNum = r.nextInt(5) + 1;
			if (eList.size() >= 5) {
				return;
			}
			while (true) {
				eNum = r.nextInt(5) + 1;
				boolean locationInUse = false;
				for (Enemy enemy : eList) {
					if (eNum == enemy.enemyNum) {
						locationInUse = true;
						break;
					}
				}
				if (!locationInUse) {
					createEnemy(eNum);
					break;
				}
			}

		}

	}

}
