package snake;

import javafx.scene.paint.Color;

public class UserClass {
	
	// Attributes
	private String userName;
	private int highScore = 0;
	private Color snakeColour = Color.RED;
	private Color fruitColour = Color.BLUE;
	private int snakeSpeed = 3;
	private char upControl = 'w';
	private char leftControl = 'a';
	private char rightControl = 'd';
	private char downControl = 's';
	
	// Methods
	
	public UserClass(String userNameIn) {
		userName = userNameIn;
		
		highScore = 0;
		snakeColour = Color.RED;
		fruitColour = Color.BLUE;
		snakeSpeed = 3;
		upControl = 'w';
		leftControl = 'a';
		rightControl = 'd';
		downControl = 's';
	}
	
	public UserClass(String userNameIn, int highScoreIn, Color snakeColourIn, Color fruitColourIn, int snakeSpeedIn, char upControlIn, char leftControlIn, char downControlIn, char rightControlIn) {
		userName = userNameIn;
		
		highScore = highScoreIn;
		snakeColour = snakeColourIn;
		fruitColour = fruitColourIn;
		snakeSpeed = snakeSpeedIn;
		upControl = upControlIn;
		leftControl = leftControlIn;
		rightControl = rightControlIn;
		downControl = downControlIn;
	}
	
	// Getters and Setters
	// Getters
	public String getUserName() {
		return userName;
	}
	
	public int getHighScore() {
		return highScore;
	}
	
	public double getSnakeRed() {
		return snakeColour.getRed();
	}
	
	public double getSnakeBlue() {
		return snakeColour.getBlue();
	}
	
	public double getSnakeGreen() {
		return snakeColour.getGreen();
	}
	
	public Color getSnakeColour() {
		return snakeColour;
	}
	
	public double getFruitRed() {
		return fruitColour.getRed();
	}
	
	public double getFruitBlue() {
		return fruitColour.getBlue();
	}
	
	public double getFruitGreen() {
		return fruitColour.getGreen();
	}
	
	public Color getFruitColour() {
		return fruitColour;
	}
	
	public int getSnakeSpeed() {
		return snakeSpeed;
	}
	
	public char getUpControl() {
		return upControl;
	}
	
	public char getDownControl() {
		return downControl;
	}
	
	public char getLeftControl() {
		return leftControl;
	}
	
	public char getRightControl() {
		return rightControl;
	}
	
	// Setters
	public void setUserName(String userNameIn) {
		userName = userNameIn;
	}
	
	public void setHighScore(int highScoreIn) {
		highScore = highScoreIn;
	}
	
	public void setSnakeColour(Color snakeColourIn) {
		snakeColour = snakeColourIn;
	}
	
	public void setFruitColour(Color fruitColourIn) {
		fruitColour = fruitColourIn;
	}
	
	public void setSnakeSpeed(int snakeSpeedIn) {
		snakeSpeed = snakeSpeedIn;
	}
	
	public void setUpControl(char upControlIn) {
		upControl = upControlIn;
	}
	
	public void setDownControl(char downControlIn) {
		downControl = downControlIn;
	}
	
	public void setLeftControl(char leftControlIn) {
		leftControl = leftControlIn;
	}
	
	public void setRightControl(char rightControlIn) {
		rightControl = rightControlIn;
	}
}