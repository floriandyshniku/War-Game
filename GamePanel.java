package projectV2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;
	public static final int UNIT_SIZE = 60;
	ActionListener actionListener;
	Rocket rocket;
	Timer timer;
	Timer timerRotationEnemy;
	private Enemy enemy, secondEnemy, thirdEnemy, fourthEnemy;
	private int buttonPressed;
	ArrayList<Enemy> enemys = new ArrayList<>();
	ArrayList<Enemy> secondsEnemys = new ArrayList<>();
	ArrayList<Enemy> thirdEnemys = new ArrayList<>();
	ArrayList<Enemy> fourthEnemys = new ArrayList<>();
	private static boolean firstEnemyIsKilled;
	private static boolean secondEnemyIsKilled;
	private static boolean thirdEnemyIsKilled;
	private static boolean fourthEnemyIsKilled;
	private static int rocketBulletX;
	private static int rocketBulletY;
	private static int numberOfKills = 0;
	private static int numberOfBlood = 0;

	public GamePanel() {
		this.setBackground(Color.white);
		this.setFocusable(true);
		rocket = new Rocket();
		enemy = new Enemy();
		secondEnemy = new Enemy();
		thirdEnemy = new Enemy();
		fourthEnemy = new Enemy();
		addKeyListener(new MyKeyAdapter());
		enemys = Enemy.getEnemys();
		secondsEnemys = Enemy.getSecondEnemys();
		thirdEnemys = Enemy.getThirdEnemys();
		fourthEnemys = Enemy.getFourthEnemys();
		startGame();
		randomDirection();
		randomMove();
		enemy.addFirstEnemy();
		secondEnemy.addSecondEnemy();
		thirdEnemy.addThirdEnemy();
		fourthEnemy.addFourthEnemy();
		displayFirstEnemy();
		displaySecondEnemy();
		displayThirdEnemy();
		displayFourthEnemy();
	}
	private void startGame() {
		timer = new Timer(250, null);
		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Bullet> bullets = Rocket.getBullets();
				ArrayList<Bullet> enemyBullets = enemy.getEnemyBullets();
				ArrayList<Bullet> secondEnemyBullets = secondEnemy.getSecondsEnemyBullets();
				ArrayList<Bullet> thirdEnemyBullets = thirdEnemy.getThirdEnemyBullets();
				ArrayList<Bullet> fourthEnemyBullets = fourthEnemy.getFourthEnemyBullets();

				for (int i = 0; i < bullets.size(); i++) {
					Bullet bullet = bullets.get(i);
					if (bullet.isMovingRight()) {
						bullet.move();
					}
					if (bullet.isMovingLeft()) {
						bullet.moveLeft();
					}
					if (bullet.isMovingUp()) {
						bullet.moveUp();
					}
					if (bullet.isMovingDown()) {
						bullet.moveDown();
					}
					if (bullet.isVisiable() == false ||
					   (bullet.getX() == enemy.getxEnemy() &&
						bullet.getY() == enemy.getyEnemy()) ||
					   (bullet.getX() == secondEnemy.getxEnemy() && 
					   bullet.getY() == secondEnemy.getyEnemy()) ||
					   (bullet.getX() == thirdEnemy.getxEnemy() && 
					   bullet.getY() == thirdEnemy.getyEnemy()) ||
					   (bullet.getX() == fourthEnemy.getxEnemy() && 
					   bullet.getY() == fourthEnemy.getyEnemy())) {
						bullets.remove(i);
					}
					rocketBulletX = bullet.getX();
					rocketBulletY = bullet.getY();
				}
				for (int i = 0; i < enemyBullets.size(); i++) {
					Bullet bullet = enemyBullets.get(i);
					if (bullet.isMovingRight()) {
						bullet.move();
					}
					if (bullet.isMovingLeft()) {
						bullet.moveLeft();
					}
					if (bullet.isMovingUp()) {
						bullet.moveUp();
					}
					if (bullet.isMovingDown()) {
						bullet.moveDown();
					}
					if (bullet.getX() == Rocket.getX() &&
						bullet.getY() == Rocket.getY()) {
						numberOfBlood++;
						bullet.setVisiable(false);
					}
					if (bullet.isVisiable() == false || firstEnemyIsKilled == true) {
						enemyBullets.remove(i);
					}
				}
				for (int i = 0; i < secondEnemyBullets.size(); i++) {
					Bullet bullet = secondEnemyBullets.get(i);
					if (bullet.isMovingRight()) {
						bullet.move();
					}
					if (bullet.isMovingLeft()) {
						bullet.moveLeft();
					}
					if (bullet.isMovingUp()) {
						bullet.moveUp();
					}
					if (bullet.isMovingDown()) {
						bullet.moveDown();
					}
					if (bullet.getX() == Rocket.getX() &&
							bullet.getY() == Rocket.getY()) {
							numberOfBlood++;
							bullet.setVisiable(false);
						}
					if (bullet.isVisiable() == false || secondEnemyIsKilled == true) {
						secondEnemyBullets.remove(i);
					}
				}
				for (int i = 0; i < thirdEnemyBullets.size(); i++) {
					Bullet bullet = thirdEnemyBullets.get(i);
					if (bullet.isMovingRight()) {
						bullet.move();
					}
					if (bullet.isMovingLeft()) {
						bullet.moveLeft();
					}
					if (bullet.isMovingUp()) {
						bullet.moveUp();
					}
					if (bullet.isMovingDown()) {
						bullet.moveDown();
					}
					if (bullet.getX() == Rocket.getX() &&
							bullet.getY() == Rocket.getY()) {
						numberOfBlood++;
						bullet.setVisiable(false);
					}
					if (bullet.isVisiable() == false || thirdEnemyIsKilled == true) {
						thirdEnemyBullets.remove(i);
					}
				}
				for (int i = 0; i < fourthEnemyBullets.size(); i++) {
					Bullet bullet = fourthEnemyBullets.get(i);
					if (bullet.isMovingRight()) {
						bullet.move();
					}
					if (bullet.isMovingLeft()) {
						bullet.moveLeft();
					}
					if (bullet.isMovingUp()) {
						bullet.moveUp();
					}
					if (bullet.isMovingDown()) {
						bullet.moveDown();
					}
					if (bullet.getX() == Rocket.getX() &&
							bullet.getY() == Rocket.getY()) {
						numberOfBlood++;
						bullet.setVisiable(false);
					}
					if (bullet.isVisiable() == false || fourthEnemyIsKilled == true) {
						fourthEnemyBullets.remove(i);
					}
				}
				byte randomShoot = (byte) Math.round(Math.random() * 10 + 1);
				if (randomShoot == 1 || randomShoot == 8) {
					if (firstEnemyIsKilled == false) {
						enemy.shoot(enemyBullets, enemy.getEnemyDirection());	
					}
					enemy.setEnemyIsShooting(true);
				} else {
					enemy.setEnemyIsShooting(false);
				}
				//// --------------second-------------///
				byte randomShootEnemyTwo = (byte) Math.round(Math.random() * 10 + 1);
				if (randomShootEnemyTwo == 1 || randomShootEnemyTwo == 8) {
					if (secondEnemyIsKilled == false) {
						secondEnemy.shoot(secondEnemyBullets, secondEnemy.getEnemyDirection());		
					}
					secondEnemy.setEnemyIsShooting(true);
				} else {
					secondEnemy.setEnemyIsShooting(false);
				}
				//// -------------third-----------------///
				byte randomShootEnemyThird = (byte) Math.round(Math.random() * 10 + 1);
				if (randomShootEnemyThird == 1 || randomShootEnemyThird == 8) {
					if (thirdEnemyIsKilled == false) {
						thirdEnemy.shoot(secondEnemyBullets, thirdEnemy.getEnemyDirection());		
					}
					thirdEnemy.setEnemyIsShooting(true);
				} else {
					thirdEnemy.setEnemyIsShooting(false);
				}
				//// -------------fourth-----------------///
				byte randomShootEnemyFourth = (byte) Math.round(Math.random() * 10 + 1);
				if (randomShootEnemyFourth == 1 || randomShootEnemyFourth == 8) {
					if (fourthEnemyIsKilled == false) {
						fourthEnemy.shoot(secondEnemyBullets, fourthEnemy.getEnemyDirection());	
					}
					fourthEnemy.setEnemyIsShooting(true);
				} else {
					fourthEnemy.setEnemyIsShooting(false);
				}
				rocket.move();
				repaint();
			}
		});
		timer.start();
	}
	
	private void drawMessage(Graphics g) {
		 Font font = new Font("Serif", Font.PLAIN, 96);
	      g.setFont(font);
	      g.drawString("You Win", 150, 200);
	}
	private void drawSecondMessage(Graphics g) {
		Font font = new Font("Serif", Font.PLAIN, 96);
		g.setFont(font);
		g.drawString("You Lose", 150, 200);
	}

	private void drawEnemy(Graphics g) {
		for (int i = 0; i < enemys.size(); i++) {
			enemy = enemys.get(i);
			if (enemy.getEnemyDirection() == 'R') {
				g.drawImage(enemy.getEnemyRight(), enemy.getxEnemy() + 1, enemy.getyEnemy() + 1, null);
			}
			if (enemy.getEnemyDirection() == 'L') {
				g.drawImage(enemy.getEnemyLeft(), enemy.getxEnemy() + 1, enemy.getyEnemy() + 1, null);
			}
			if (enemy.getEnemyDirection() == 'D') {
				g.drawImage(enemy.getEnemyDown(), enemy.getxEnemy() + 1, enemy.getyEnemy() + 1, null);
			}
			if (enemy.getEnemyDirection() == 'U') {
				g.drawImage(enemy.getEnemyUp(), enemy.getxEnemy() + 1, enemy.getyEnemy() + 1, null);
			}
			if (enemy.getxEnemy() == rocketBulletX && enemy.getyEnemy() == rocketBulletY) {
				enemys.remove(i);
				firstEnemyIsKilled = true;
				if (firstEnemyIsKilled == true) {
					numberOfKills++;
				}
			}
		}
		for (int i = 0; i < secondsEnemys.size(); i++) {
			secondEnemy = secondsEnemys.get(i);
			if (secondEnemy.getEnemyDirection() == 'R') {
				g.drawImage(secondEnemy.getEnemyRight(), secondEnemy.getxEnemy() + 1, secondEnemy.getyEnemy() + 1,
						null);
			}
			if (secondEnemy.getEnemyDirection() == 'L') {
				g.drawImage(secondEnemy.getEnemyLeft(), secondEnemy.getxEnemy() + 1, secondEnemy.getyEnemy() + 1, null);
			}
			if (secondEnemy.getEnemyDirection() == 'D') {
				g.drawImage(secondEnemy.getEnemyDown(), secondEnemy.getxEnemy() + 1, secondEnemy.getyEnemy() + 1, null);
			}
			if (secondEnemy.getEnemyDirection() == 'U') {
				g.drawImage(secondEnemy.getEnemyUp(), secondEnemy.getxEnemy() + 1, secondEnemy.getyEnemy() + 1, null);
			}
			if (secondEnemy.getxEnemy() == rocketBulletX && secondEnemy.getyEnemy() == rocketBulletY) {
				secondsEnemys.remove(i);
				secondEnemyIsKilled = true;
				if (secondEnemyIsKilled == true) {
					numberOfKills++;
				}
			}
		}
		for (int i = 0; i < thirdEnemys.size(); i++) {
			thirdEnemy = thirdEnemys.get(i);
			if (thirdEnemy.getEnemyDirection() == 'R') {
				g.drawImage(thirdEnemy.getEnemyRight(), thirdEnemy.getxEnemy() + 1, thirdEnemy.getyEnemy() + 1, null);
			}
			if (thirdEnemy.getEnemyDirection() == 'L') {
				g.drawImage(thirdEnemy.getEnemyLeft(), thirdEnemy.getxEnemy() + 1, thirdEnemy.getyEnemy() + 1, null);
			}
			if (thirdEnemy.getEnemyDirection() == 'D') {
				g.drawImage(thirdEnemy.getEnemyDown(), thirdEnemy.getxEnemy() + 1, thirdEnemy.getyEnemy() + 1, null);
			}
			if (thirdEnemy.getEnemyDirection() == 'U') {
				g.drawImage(thirdEnemy.getEnemyUp(), thirdEnemy.getxEnemy() + 1, thirdEnemy.getyEnemy() + 1, null);
			}
			if (thirdEnemy.getxEnemy() == rocketBulletX && thirdEnemy.getyEnemy() == rocketBulletY) {
				thirdEnemys.remove(i);
				thirdEnemyIsKilled = true;
				if (thirdEnemyIsKilled == true) {
					numberOfKills++;
				}
			}
		}
		for (int i = 0; i < fourthEnemys.size(); i++) {
			fourthEnemy = fourthEnemys.get(i);
			if (fourthEnemy.getEnemyDirection() == 'R') {
				g.drawImage(fourthEnemy.getEnemyRight(), fourthEnemy.getxEnemy() + 1, fourthEnemy.getyEnemy() + 1,null);
			}
			if (fourthEnemy.getEnemyDirection() == 'L') {
				g.drawImage(fourthEnemy.getEnemyLeft(), fourthEnemy.getxEnemy() + 1, fourthEnemy.getyEnemy() + 1, null);
			}
			if (fourthEnemy.getEnemyDirection() == 'D') {
				g.drawImage(fourthEnemy.getEnemyDown(), fourthEnemy.getxEnemy() + 1, fourthEnemy.getyEnemy() + 1, null);
			}
			if (fourthEnemy.getEnemyDirection() == 'U') {
				g.drawImage(fourthEnemy.getEnemyUp(), fourthEnemy.getxEnemy() + 1, fourthEnemy.getyEnemy() + 1, null);
			}
			if (fourthEnemy.getxEnemy() == rocketBulletX && fourthEnemy.getyEnemy() == rocketBulletY) {
				fourthEnemys.remove(i);
				fourthEnemyIsKilled = true;
				if (fourthEnemyIsKilled == true) {
					numberOfKills++;
				}
			}
		}
	}

	private void drawBullet(Graphics g) {
		ArrayList<Bullet> bullets = Rocket.getBullets();
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if (bullet.isMovingRight() == true) {
				g.drawImage(bullet.getImage(), bullet.getX() + 5, bullet.getY() + 5, null);
			}
			if (bullet.isMovingLeft() == true) {
				g.drawImage(bullet.getImage(), bullet.getX() + 5, bullet.getY() + 5, null);
			}
			if (bullet.isMovingDown() == true) {
				g.drawImage(bullet.getImage(), bullet.getX() + 5, bullet.getY() + 5, null);
			}
			if (bullet.isMovingUp() == true) {
				g.drawImage(bullet.getImage(), bullet.getX() + 5, bullet.getY() + 5, null);
			}
		}
		/** ------------Enemy------------------- */
		ArrayList<Bullet> enemyBullets = enemy.getEnemyBullets();
		if (firstEnemyIsKilled == false) {
		
			for (int i = 0; i < enemyBullets.size(); i++) {
				Bullet bullet = enemyBullets.get(i);
				if (bullet.isMovingRight() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingLeft() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingDown() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingUp() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
			}
		}
		ArrayList<Bullet> secondsEnemyBullets = secondEnemy.getSecondsEnemyBullets();
		if (secondEnemyIsKilled == false) {
			for (int i = 0; i < secondsEnemyBullets.size(); i++) {
				Bullet bullet = secondsEnemyBullets.get(i);
				if (bullet.isMovingRight() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingLeft() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingDown() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingUp() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
			}
		}
		ArrayList<Bullet> thirdEnemyBullets = thirdEnemy.getThirdEnemyBullets();
		if (thirdEnemyIsKilled == false) {
			for (int i = 0; i < thirdEnemyBullets.size(); i++) {
				Bullet bullet = thirdEnemyBullets.get(i);
				if (bullet.isMovingRight() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingLeft() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingDown() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingUp() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
			}
		}
		ArrayList<Bullet> fourthEnemyBullets = fourthEnemy.getFourthEnemyBullets();
		if (fourthEnemyIsKilled == false) {
			for (int i = 0; i < fourthEnemyBullets.size(); i++) {
				Bullet bullet = fourthEnemyBullets.get(i);
				if (bullet.isMovingRight() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingLeft() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingDown() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
				if (bullet.isMovingUp() == true) {
					g.drawImage(bullet.getImageEnemyBullet(), bullet.getX() + 5, bullet.getY() + 5, null);
				}
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		drawLine(g);
		if (numberOfKills < 7 && numberOfBlood <= 4) {
			draw(g);
			drawBullet(graphics2d);
			drawEnemy(g);	
		}
		if(numberOfKills == 7) { 
			drawMessage(g);	
		}
		if (numberOfBlood > 4 ) {
			drawSecondMessage(g);
		}
		
	}
	
	
	private void drawLine(Graphics g) {
		for (int i = 0; i <= SCREEN_WIDTH / UNIT_SIZE; i++) {
			g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_WIDTH);
			g.drawLine(0, i * UNIT_SIZE, SCREEN_HEIGHT, i * UNIT_SIZE);
		}
	}
	private void draw(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		if (Rocket.getDirection() == 'R') {
			graphics2d.drawImage(rocket.getRocketRight(), Rocket.getX() + 1, Rocket.getY() + 1, null);
		}
		if (Rocket.getDirection() == 'L') {
			graphics2d.drawImage(rocket.getRocketLeft(), Rocket.getX() + 1, Rocket.getY() + 1, null);
		}
		if (Rocket.getDirection() == 'D') {
			graphics2d.drawImage(rocket.getRocketDown(), Rocket.getX() + 1, Rocket.getY() + 1, null);
		}
		if (Rocket.getDirection() == 'U') {
			graphics2d.drawImage(rocket.getRocketUp(), Rocket.getX() + 1, Rocket.getY() + 1, null);
		}
	}

	public void randomDirection() {
		timerRotationEnemy = new Timer((int) Math.round(Math.random() * 2000 + 1500), null);
		timerRotationEnemy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enemy.enemyDirection();
				secondEnemy.enemyDirection();
				thirdEnemy.enemyDirection();
				fourthEnemy.enemyDirection();
				repaint(1);
			}
		});
		timerRotationEnemy.start();
	}

	public void randomMove() {
		Timer timerMoveEnemy = new Timer(700, null);
		timerMoveEnemy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enemy.move(enemy.isEnemyIsShooting());
				secondEnemy.move(secondEnemy.isEnemyIsShooting());
				thirdEnemy.move(thirdEnemy.isEnemyIsShooting());
				fourthEnemy.move(fourthEnemy.isEnemyIsShooting());
				repaint(1);
			}
		});
		timerMoveEnemy.start();
	}
	public void displayFirstEnemy() {
		Timer timer = new Timer((int) Math.round(Math.random()*10000 + 3000), new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (firstEnemyIsKilled == true) {
					enemy.addFirstEnemy();
					firstEnemyIsKilled = false;
				}
			}
		});
		timer.start();
	}
	public void displaySecondEnemy() {
		Timer timer = new Timer((int) Math.round(Math.random()*10000 + 3000), new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (secondEnemyIsKilled == true) {
					secondEnemy.addSecondEnemy();
					secondEnemyIsKilled = false;
				}
			}
		});
		timer.start();
	}
	public void displayThirdEnemy() {
		Timer timer = new Timer((int) Math.round(Math.random()*10000 + 3000), new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (thirdEnemyIsKilled == true) {
					thirdEnemy.addThirdEnemy();
					thirdEnemyIsKilled = false;
				}
			}
		});
		timer.start();
	}
	public void displayFourthEnemy() {
		Timer timer = new Timer((int) Math.round(Math.random()*10000 + 3000), new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fourthEnemyIsKilled == true) {
					fourthEnemy.addFourthEnemy();
					fourthEnemyIsKilled = false;
				}
			}
		});
		timer.start();
	}

	private class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			buttonPressed = e.getKeyCode();
			rocket.rocketDirection(buttonPressed);
			if (buttonPressed == KeyEvent.VK_SPACE) {
				rocket.shoot();

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			rocket.release();
		}

	}

	public static boolean isFirstEnemyIsKilled() {
		return firstEnemyIsKilled;
	}

	public static void setFirstEnemyIsKilled(boolean firstEnemyIsKilled) {
		GamePanel.firstEnemyIsKilled = firstEnemyIsKilled;
	}

	public static boolean isSecondEnemyIsKilled() {
		return secondEnemyIsKilled;
	}

	public static void setSecondEnemyIsKilled(boolean secondEnemyIsKilled) {
		GamePanel.secondEnemyIsKilled = secondEnemyIsKilled;
	}

	public static boolean isThirdEnemyIsKilled() {
		return thirdEnemyIsKilled;
	}

	public static void setThirdEnemyIsKilled(boolean thirdEnemyIsKilled) {
		GamePanel.thirdEnemyIsKilled = thirdEnemyIsKilled;
	}

	public static boolean isFourthEnemyIsKilled() {
		return fourthEnemyIsKilled;
	}

	public static void setFourthEnemyIsKilled(boolean fourthEnemyIsKilled) {
		GamePanel.fourthEnemyIsKilled = fourthEnemyIsKilled;
	}
	
	public static int getNumberOfKills() {
		return numberOfKills;
	}

}
