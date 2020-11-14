package snake;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class SnakeBody {
	
	// Attributes
	ArrayList<SnakeCell> snakeBody = new ArrayList<>();
	
	// Methods
	
	// Utility Methods
	/**
	 * adds a snake head cell to the snake body array list
	 */
	public void addHeadCell(Color snakeColourIn) {
		snakeBody.add(new SnakeCell(snakeColourIn));
	}
	
	/**
	 * adds a snake body cell to the snake body array list
	 */
	public void addBodyCell() {
		snakeBody.add(new SnakeCell(snakeBody.get(snakeBody.size() - 1)));
	}
	
	/**
	 * sets the new directions and positions of each snake cell after one movement
	 */
	public void moveSnake() {
		snakeBody.get(1).moveSnakeHeadCell();
		if (snakeBody.size() > 1) {
			for (int i=1; i < snakeBody.size(); i++) {
				snakeBody.get(i).moveSnakeBodyCell(snakeBody.get(i-1));
			}
		}
	}
}
