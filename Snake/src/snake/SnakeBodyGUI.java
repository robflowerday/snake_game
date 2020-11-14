package snake;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class SnakeBodyGUI extends SnakeBody {
	
	// Attributes
	ArrayList<SnakeCellGUI> snakeBody = new ArrayList<>();
	
	// Methods
	public SnakeBodyGUI(Color snakeColourIn) {
		addHeadCell(snakeColourIn);
	}

	/**
	 * overrides method of SnakeBody class
	 * adds a snake head cell to the snake body array list
	 */
	@Override
	public void addHeadCell(Color snakeColourIn) {
		snakeBody.add(new SnakeCellGUI(snakeColourIn));
	}
	
	/**
	 * overrides method of SnakeBody class
	 * adds a snake body cell to the snake body array list
	 */
	@Override
	public void addBodyCell() {
		snakeBody.add(new SnakeCellGUI(snakeBody.get(snakeBody.size() - 1)));
	}
	
	/**
	 * overrides method of SnakeBody class
	 * sets the new directions and positions of each snake cell after one movement
	 */
	@Override
	public void moveSnake() {
		snakeBody.get(0).moveSnakeHeadCell();
		snakeBody.get(0).reCalibrateCellRectangle();
		if (snakeBody.size() > 1) {
			for (int i=1; i < snakeBody.size(); i++) {
				snakeBody.get(i).moveSnakeBodyCell(snakeBody.get(i-1));
				snakeBody.get(i).reCalibrateCellRectangle();
			}
		}
	}
}
