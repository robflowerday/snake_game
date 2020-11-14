package snake;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {
	
	// Attributes
	Group snakeBoard;
	SnakeBodyGUI snakeBodyGUI;
	BoardSize boardSize = new BoardSize();
	Rectangle topLine = new Rectangle(0, 0, boardSize.getBoardWidth(), 10);
	Rectangle baseLine = new Rectangle(0, boardSize.getBoardHeight() - 10, boardSize.getBoardWidth(), 10);
	Rectangle leftLine = new Rectangle(0, 0, 10, boardSize.getBoardHeight());
	Rectangle rightLine = new Rectangle(boardSize.getBoardWidth() - 10, 0, 10, boardSize.getBoardHeight());
	
	
	// Methods
	// Constructors
	public Board(Color snakeColourIn) {
		snakeBoard = new Group();
		snakeBoard.getChildren().addAll(topLine, baseLine, leftLine, rightLine);
		snakeBodyGUI = new SnakeBodyGUI(snakeColourIn);
		snakeBoard.getChildren().add(snakeBodyGUI.snakeBody.get(0).getCellRectangle());
	}
		
	public Rectangle makeFruit(int cellXPositionIn, int cellYPositionIn, Color fruitColourIn) {
		Cell fruit = new Cell(fruitColourIn, cellXPositionIn, cellYPositionIn);
		Rectangle fruitGUI = new Rectangle(fruit.getCellXPosition(), fruit.getCellYPosition(), fruit.getCellWidth(), fruit.getCellHeight());
		fruitGUI.setFill(fruit.getCellColour());
		return fruitGUI;
	}
	
	public int[] makeRandomPosition() {
		
		boolean clash = false;
		
		int randomXPosition = 0;
		int randomYPosition = 0;
		do {
			clash = false;
			while (randomXPosition < leftLine.getX() + leftLine.getWidth() || randomXPosition > rightLine.getX()) {
				randomXPosition = (((int) (Math.random() * boardSize.getBoardWidth()))/10)*10 - 10;
			}
			while (randomYPosition < topLine.getY() + topLine.getHeight() || randomYPosition > baseLine.getY()) {
				randomYPosition = (((int) (Math.random() * boardSize.getBoardHeight()))/10)*10 - 10;
			}
			for (int i=1; i < snakeBodyGUI.snakeBody.size(); i++) {
				if (randomXPosition == snakeBodyGUI.snakeBody.get(i).getCellXPosition() &&
					randomYPosition == snakeBodyGUI.snakeBody.get(i).getCellYPosition()	) {
					clash = true;
				}
			}
		} while (clash == true);
		return new int[] {randomXPosition, randomYPosition};
	}
	

	
}