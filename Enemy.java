package projectV2;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy {
	private int xEnemy, yEnemy, enemyVelocityX, enemyVelocityY;
	private char enemyDirection;
	private Image enemyRight, enemyDown, enemyLeft, enemyUp;
	public static final int UNIT_SIZE = 60;
	byte randomDirection = 0;
	private  ArrayList<Bullet>enemyBullets = new ArrayList<Bullet>();
	private  ArrayList<Bullet>secondsEnemyBullets = new ArrayList<Bullet>();
	private  ArrayList<Bullet>thirdEnemyBullets = new ArrayList<Bullet>();
	private  ArrayList<Bullet>fourthEnemyBullets = new ArrayList<Bullet>();
	private static ArrayList<Enemy>enemys = new ArrayList<Enemy>();
	private static ArrayList<Enemy>secondsEnemys = new ArrayList<Enemy>();
	private static ArrayList<Enemy>thirdEnemys = new ArrayList<Enemy>();
	private static ArrayList<Enemy>fourthEnemys = new ArrayList<Enemy>();
	private boolean enemyIsShooting;
	
	public Enemy() {
	}

	public Enemy(int x, int y) {
		String imagePathRight = "C:\\Users\\AG\\Desktop\\EnmeyRight.png";
		String imagePathLeft = "C:\\Users\\AG\\Desktop\\EnmeyLeft.png";
		String imagePathUp = "C:\\Users\\AG\\Desktop\\EnmeyUp.png";
		String imagePathDown = "C:\\Users\\AG\\Desktop\\EnmeyDown.png";
		enemyRight = new ImageIcon(imagePathRight).getImage();
		enemyDown = new ImageIcon(imagePathDown).getImage();
		enemyLeft = new ImageIcon(imagePathLeft).getImage();
		enemyUp = new ImageIcon(imagePathUp).getImage();
		enemyDirection = 'R';
		enemyBullets = new ArrayList<>();
		secondsEnemyBullets = new ArrayList<>();
		thirdEnemyBullets = new ArrayList<>();
		fourthEnemyBullets = new ArrayList<>();
		this.xEnemy = x;
		this.yEnemy = y;
	}
	
	public void addFirstEnemy() {
		Enemy enemy ; 
		enemy =  new Enemy(540, 540);
		if (GamePanel.isFirstEnemyIsKilled() == true) {
			if (Rocket.getX() == 540 && Rocket.getY() == 540) {
				 enemy = new Enemy(0, 240);
			}else {
				enemy = new Enemy(540, 540);
			}
			GamePanel.setFirstEnemyIsKilled(false); 
		}
		enemys.add(enemy);
		
	}
	public void addSecondEnemy() {
		Enemy enemy = new Enemy(540, 0);
		if (GamePanel.isSecondEnemyIsKilled() == true) {
			if (Rocket.getX() == 540 && Rocket.getY() == 0) {
				 enemy = new Enemy(540, 240);
			}else {
				enemy = new Enemy(540, 0);
			}
			GamePanel.setSecondEnemyIsKilled(false); 
		}
		secondsEnemys.add(enemy);
	}
	public void addThirdEnemy() {
		Enemy enemy = new Enemy(60, 540);
		if (GamePanel.isThirdEnemyIsKilled() == true) {
			if (Rocket.getX() == 0 && Rocket.getY() == 540) {
				 enemy = new Enemy(540, 240);
			}else {
				enemy = new Enemy(480, 420);
			}
			GamePanel.setThirdEnemyIsKilled(false); 
		}
		thirdEnemys.add(enemy);
	}
	public void addFourthEnemy() {
		Enemy enemy = new Enemy(60, 60);
		if (GamePanel.isFourthEnemyIsKilled() == true) {
			if (Rocket.getX() == 0 && Rocket.getY() == 0) {
				 enemy = new Enemy(300, 540);
			}else {
				enemy = new Enemy(0, 0);
			}
			GamePanel.setFourthEnemyIsKilled(false); 
		}
		fourthEnemys.add(enemy);
	}
	
	public void shoot(ArrayList<Bullet> enemyBullets, char enemyDirection) {
		Bullet bullet = new Bullet(xEnemy, yEnemy);
		enemyBullets.add(bullet);
		if (enemyDirection == 'R') {
			bullet.setMovingRight(true);
		}
		if (enemyDirection == 'L') {
			bullet.setMovingLeft(true);
		}
		if (enemyDirection == 'U') {
			bullet.setMovingUp(true);
		}
		if (enemyDirection == 'D') {
			bullet.setMovingDown(true);
		}
	}
	
	public void move(boolean enemyIsShooting) {
		if (xEnemy > 540 ) {
			enemyVelocityX = 0;
			xEnemy = 600 - UNIT_SIZE;
		}
		if (xEnemy < 0 ) {
			enemyVelocityX = 0;
			xEnemy =  0;
		}
		if (yEnemy < 0) {
			enemyVelocityY = 0;
			yEnemy = 0;
		}
		if (yEnemy > 540) {
			enemyVelocityY = 0;
			yEnemy = 540;
		}
		if (enemyIsShooting == true) {
			enemyVelocityX = 0;
			enemyVelocityY = 0;
		}
		if (Rocket.getX() == xEnemy + 60 &&
			Rocket.getY() == yEnemy && 
			getEnemyDirection() == 'R') { 
			enemyVelocityX = 0;
		}
		if (Rocket.getX() == xEnemy - 60 &&
			Rocket.getY() == yEnemy && 
			getEnemyDirection() == 'L') {
			enemyVelocityX = 0;
		}
		if (Rocket.getY() == yEnemy + 60 &&
				Rocket.getX() == xEnemy && 
				getEnemyDirection() == 'D') {
			enemyVelocityY = 0;
		}
		if (Rocket.getY() == yEnemy - 60 &&
				Rocket.getX() == xEnemy && 
				getEnemyDirection() == 'U') {
			enemyVelocityY = 0;
		}
	
		xEnemy = xEnemy + enemyVelocityX;
		yEnemy = yEnemy + enemyVelocityY;
		
	}


	public int getxEnemy() {
		return xEnemy;
	}

	public int getyEnemy() {
		return yEnemy;
	}

	public Image getEnemyRight() {
		return enemyRight;
	}

	public Image getEnemyDown() {
		return enemyDown;
	}

	public Image getEnemyLeft() {
		return enemyLeft;
	}

	public Image getEnemyUp() {
		return enemyUp;
	}

	public char getEnemyDirection() {
		return enemyDirection;
	}

	public void enemyDirection() {
		randomDirection = (byte) Math.round((Math.random() * 3) + 1);
		if (randomDirection == 1 && xEnemy >= 540) {
			if (Math.round((Math.random() * 2) + 1) == 1) {
				randomDirection = 2;
			}
			if (Math.round((Math.random() * 2) + 1) == 2) {
				randomDirection = 3;
			}
			if (Math.round((Math.random() * 2) + 1) == 3) {
				randomDirection = 4;
			}
		}
		if (randomDirection == 2 && xEnemy <= 0) {
			if (Math.round((Math.random() * 2) + 1) == 1) {
				randomDirection = 1;
			}
			if (Math.round((Math.random() * 2) + 1) == 2) {
				randomDirection = 3;
			}
			if (Math.round((Math.random() * 2) + 1) == 3) {
				randomDirection = 4;
			}
		}
		if (randomDirection == 3 && yEnemy <= 0) {
			if (Math.round((Math.random() * 2) + 1) == 1) {
				randomDirection = 1;
			}
			if (Math.round((Math.random() * 2) + 1) == 2) {
				randomDirection = 2;
			}
			if (Math.round((Math.random() * 2) + 1) == 3) {
				randomDirection = 4;
			}
		}
		if (randomDirection == 4 && yEnemy >= 540) {
			if (Math.round((Math.random() * 2) + 1) == 1) {
				randomDirection = 1;
			}
			if (Math.round((Math.random() * 2) + 1) == 2) {
				randomDirection = 2;
			}
			if (Math.round((Math.random() * 2) + 1) == 3) {
				randomDirection = 3;
			}
		}
		if (randomDirection == 1) {
			enemyDirection = 'R';
			enemyVelocityX = UNIT_SIZE;
			enemyVelocityY = 0;
		}
		if (randomDirection == 2) {
			enemyDirection = 'L';
			enemyVelocityX = -UNIT_SIZE;
			enemyVelocityY = 0;
		}
		if (randomDirection == 3) {
			enemyDirection = 'U';
			enemyVelocityX = 0;
			enemyVelocityY = -UNIT_SIZE;
		}
		if (randomDirection == 4) {
			enemyDirection = 'D';
			enemyVelocityX = 0;
			enemyVelocityY = UNIT_SIZE;
		}
	}


	public void setEnemyDirection(char enemyDirection) {
		this.enemyDirection = enemyDirection;
	}
	

	public  ArrayList<Bullet> getEnemyBullets() {
		return enemyBullets;
	}
	
	public  ArrayList<Bullet> getSecondsEnemyBullets() {
		return secondsEnemyBullets;
	}
	public  ArrayList<Bullet> getThirdEnemyBullets() {
		return thirdEnemyBullets;
	}
	public  ArrayList<Bullet> getFourthEnemyBullets() {
		return fourthEnemyBullets;
	}

	public boolean isEnemyIsShooting() {
		return enemyIsShooting;
	}

	public void setEnemyIsShooting(boolean enemyIsShooting) {
		this.enemyIsShooting = enemyIsShooting;
	}

	public static ArrayList<Enemy> getEnemys() {
		return enemys;
	}
	public static ArrayList<Enemy> getSecondEnemys() {
		return secondsEnemys;
	}
	public static ArrayList<Enemy> getThirdEnemys() {
		return thirdEnemys;
	}
	public static ArrayList<Enemy> getFourthEnemys() {
		return fourthEnemys;
	}
	
}
