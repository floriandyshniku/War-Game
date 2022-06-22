package projectV2;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Rocket {
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;
	public static final int UNIT_SIZE = 60;
	private static int x, y;
	private int velocityX, velocityY;
	private static char direction = 'R';
	private Image rocketLeft, rocketRight, rocketUp, rocketDown;
	private static ArrayList<Bullet>bullets;
	private static boolean canMoveRight;
	private static boolean canMoveUp;
	private static boolean canMoveDown;
	private static boolean canMoveLeft;

	public Rocket() {
		String imagePathRight = "C:\\Users\\AG\\Desktop\\rocketRight.png";
		String imagePathLeft = "C:\\Users\\AG\\Desktop\\rocketLeft.png";
		String imagePathUp = "C:\\Users\\AG\\Desktop\\rocketUp.png";
		String imagePathDown = "C:\\Users\\AG\\Desktop\\rocketDown.png";
		x = 300;
		y = 300 ;
		rocketRight = new ImageIcon(imagePathRight).getImage();
		rocketDown = new ImageIcon(imagePathDown).getImage();
		rocketLeft = new ImageIcon(imagePathLeft).getImage();
		rocketUp = new ImageIcon(imagePathUp).getImage();
		bullets = new ArrayList<Bullet> ();
		canMoveDown = true;
		canMoveLeft = true;
		canMoveUp =  true;
		canMoveRight = true;
	}
	
	public void shoot() {
		Bullet bullet = new Bullet(x, y);
		bullets.add(bullet);
		if (direction == 'R') {
			bullet.setMovingRight(true);
		}
		if (direction == 'L') {
			bullet.setMovingLeft(true);
		}
		if (direction == 'U') {
			bullet.setMovingUp(true);
		}
		if (direction == 'D') {
			bullet.setMovingDown(true);
		}
	}

	public static ArrayList<Bullet>  getBullets(){
		return bullets;
	} 
	
	public void move() {
		if (x < 0) {
			velocityX = 0;
			x = 0;
		}
		if (x > SCREEN_WIDTH - 5) {
			velocityX = 0; 
			x = SCREEN_WIDTH - UNIT_SIZE;
		}
		if (y < 0) {
			velocityY = 0;
			y = 0;
		}
		if (y > SCREEN_HEIGHT -5 ) {
			velocityY = 0;
			y = SCREEN_HEIGHT - UNIT_SIZE;
		}
		if (canMoveRight == false) {
			velocityX = 0;
		}
		if (canMoveLeft == false) {
			velocityX = 0;
		}
		if (canMoveDown == false) {
			velocityY = 0;
		}
		if (canMoveUp == false) {
			velocityY = 0;
		}
			x = x + velocityX;
			y = y + velocityY;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static char getDirection() {
		return direction;
	}

	public Image getRocketLeft() {
		return rocketLeft;
	}

	public Image getRocketRight() {
		return rocketRight;
	}

	public Image getRocketUp() {
		return rocketUp;
	}

	public Image getRocketDown() {
		return rocketDown;
	}

	public void release() {
		velocityX = 0;
		velocityY = 0;	
	}

	public void rocketDirection(int buttonPressed) {
			if (buttonPressed == KeyEvent.VK_RIGHT) {
				direction = 'R';
				velocityX = UNIT_SIZE;
			}
			if (buttonPressed == KeyEvent.VK_LEFT) {
				direction = 'L';
				velocityX = -UNIT_SIZE;
			}
			if (buttonPressed == KeyEvent.VK_DOWN) {
				direction = 'D';
				velocityY = UNIT_SIZE;
			}
			if (buttonPressed == KeyEvent.VK_UP) {
				direction = 'U';
				velocityY = -UNIT_SIZE;
			}
	}
	
	public static void setCanMoveDown(boolean canMoveDown) {
		Rocket.canMoveDown = canMoveDown;
	}
	
	public static void setCanMoveLeft(boolean canMoveLeft) {
		Rocket.canMoveLeft = canMoveLeft;
	}
	
	public static void setCanMoveRight(boolean canMoveRight) {
		Rocket.canMoveRight = canMoveRight;
	}
	
	public static void setCanMoveUp(boolean canMoveUp) {
		Rocket.canMoveUp = canMoveUp;
	}
}
