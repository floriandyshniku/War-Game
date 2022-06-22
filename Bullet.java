package projectV2;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Bullet {
	/**          Rocket Player               **/
	private int x, y, velocityX, velocityY;
	private Image image, enemyImageBullet;
	private  boolean visiable;
	public static final int UNIT_SIZE = 60;
	private char bulletDirection = 'R';
	private boolean movingRight, movingLeft, movingDown, movingUp;
	/**************************************************/
	public Bullet(int x, int y) {
		String imagePath = "C:\\Users\\AG\\Desktop\\bullet.png";
		String imagePathEnemy = "C:\\Users\\AG\\Desktop\\enemyBullet.png";
		image = new ImageIcon(imagePath).getImage();
		enemyImageBullet = new ImageIcon(imagePathEnemy).getImage();
		visiable = true;
		this.x = x;
		this.y = y;
	}

	public void move() {
		if (x > 600|| y > 600 || x < 0 || y < 0) {
			visiable = false;
			movingRight = false;
		} 
		velocityX = UNIT_SIZE;
		velocityY = 0;
		x = x + velocityX;
		y = y + velocityY;
	}
	
	public void moveLeft() {
		if (x > 600|| y > 600 || x < 0 || y < 0) {
			visiable = false;
			movingRight = false;
		} 
		velocityX = -UNIT_SIZE;
		velocityY = 0;
		x = x + velocityX;
		y = y + velocityY;
	}
	
	public void moveUp() {
		if (x > 600|| y > 600 || x < 0 || y < 0) {
			visiable = false;
			movingRight = false;
		} 
		velocityX = 0;
		velocityY = -UNIT_SIZE;
		x = x + velocityX;
		y = y + velocityY;
	}
	
	public void moveDown() {
		if (x > 600|| y > 600 || x < 0 || y < 0) {
			visiable = false;
			movingRight = false;
		} 
		velocityX = 0;
		velocityY = UNIT_SIZE;
		x = x + velocityX;
		y = y + velocityY;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}
	
	public Image getImageEnemyBullet() {
		return enemyImageBullet;
	}

	public static int getUnitSize() {
		return UNIT_SIZE;
	}

	public char getBulletDirection() {
		return bulletDirection;
	}

	public  boolean  isMovingRight() {
		return movingRight;
	}
	public  boolean  isMovingLeft() {
		return movingLeft;
	}
	public  boolean  isMovingDown() {
		return movingDown;
	}
	public  boolean  isMovingUp() {
		return movingUp;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}
	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}
	
	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}
	public boolean isVisiable() {
		return visiable;
	}
	public void setVisiable(boolean visiable) {
		this.visiable = visiable;
	}
}
