package snake;

import javafx.scene.paint.Color;

public class SnakeCell extends Cell {
	
	// Attributes
	private char currentCellDirection;		// current direction of snake cell direction 
	private char previousCellDirection;		// the direction of the snake in previous frame
	private int previousCellXPosition;	// the x position of the cell in the previous frame
	private int previousCellYPosition;	// the y position of the cell in the previous frame
	private int nextCellXPosition;	// the x position of the cell in the next frame
	private int nextCellYPosition;	// the y position of the cell in the next frame
	
	
	// Methods
	// Constructors
	/**
	 * creates a red head snake cell and positions it at the centre of the board
	 * 
	 * Attributes
	 * int height: 10
	 * int width: 10
	 * Color colour: red
	 * int x position: centre
	 * int y position: centre
	 */
	public SnakeCell(Color snakeColourIn) {
		setCellHeight(10);
		setCellWidth(10);
		setCellColour(snakeColourIn);
		setCellXPosition(this.getBoardWidth()/2 - getCellWidth()/2);
		setCellYPosition(this.getBoardHeight()/2 - getCellHeight()/2);
	}
	
	/**
	 * creates a snake body cell the same colour and in the previous position of, with the previous direction of a given snake cell
	 * int height: 10
	 * int width: 10
	 * Color colour: snakeIn.previousCellColour
	 * int x postion: snakeIn.previousCellXPosition
	 * int y postion: snakeIn.previousCellYPosition
	 * char direction: snakeIn.previousCellDirection
	 * @param snakeCellIn
	 */
	public SnakeCell(SnakeCell snakeCellIn) {
		setCellHeight(10);
		setCellWidth(10);
		setCellColour(snakeCellIn.getCellColour());
		setCellXPosition(snakeCellIn.getPreviousCellXPosition());
		setCellYPosition(snakeCellIn.getPreviousCellYPosition());
		setCurrentCellDirection(snakeCellIn.getPreviousCellDirection());
	}
	
	// Getters and Setters
	// Getters
	/**
	 * return the current direction of a cell
	 * @return char
	 */
	public char getCurrentCellDirection() {
		return currentCellDirection;
	}
	
	/**
	 * return the previous direction of a cell
	 * @return char
	 */
	public char getPreviousCellDirection() {
		return previousCellDirection;
	}
	
	/**
	 * return the precious x position of a cell
	 * @return int
	 */
	public int getPreviousCellXPosition() {
		return previousCellXPosition;
	}
	
	/**
	 * return the previous y position of a cell
	 * @return int
	 */
	public int getPreviousCellYPosition() {
		return previousCellYPosition;
	}
	
	// Setters
	/**
	 * set the current cell direction
	 * @param currentCellDirection
	 */
	public void setCurrentCellDirection(char currentCellDirectionIn) {
		currentCellDirection = currentCellDirectionIn;
	}
	
	/**
	 * set the previous cell direction
	 * @param previousCellDirection
	 */
	public void setPreviousCellDirection(char previousCellDirectionIn) {
		previousCellDirection = previousCellDirectionIn;
	}
	
	/**
	 * set the previous cell x position
	 * @param previousCellXPositionIn
	 */
	public void setPreviousCellXPosition(int previousCellXPositionIn) {
		previousCellXPosition = previousCellXPositionIn;
	}
	
	/**
	 * set the previous cell y position
	 * @param previousCellYPositionIn
	 */
	public void setPreviousCellYPosition(int previousCellYPositionIn) {
		previousCellYPosition = previousCellYPositionIn;
	}
	/**
	 * moves the head of the snake in its current direction by an amount equal to its size in that direction
	 * @param snakeHeadCellIn
	 */
	public void moveSnakeHeadCell() {
		setPreviousCellDirection(getCurrentCellDirection());
		setPreviousCellXPosition(getCellXPosition());
		setPreviousCellYPosition(getCellYPosition());
		
		switch (currentCellDirection) {
		
		case 'l':
			setCellXPosition(getCellXPosition() - getCellWidth());
			break;
		case 'r':
			setCellXPosition(getCellXPosition() + getCellWidth());
			break;
		case 'u':
			setCellYPosition(getCellYPosition() - getCellHeight());
			break;
		case 'd':
			setCellYPosition(getCellYPosition() + getCellHeight());
			break;
		}
	}
	
	/**
	 * changes the direction and the position of a snake body cell to the position and direction of the snake cell given in the argument
	 * @param snakeBodyCellIn
	 * @param previousSnakeCellIn
	 */
	public void moveSnakeBodyCell(SnakeCell previousSnakeCellIn) {
		setPreviousCellDirection(getCurrentCellDirection());
		setPreviousCellXPosition(getCellXPosition());
		setPreviousCellYPosition(getCellYPosition());
		
		setCurrentCellDirection(previousSnakeCellIn.getPreviousCellDirection());
		setCellXPosition(previousSnakeCellIn.getPreviousCellXPosition());
		setCellYPosition(previousSnakeCellIn.getPreviousCellYPosition());
	}
	
	/**
	 * changes the current direction of the head of the snake
	 * @param snakeHeadCellIn
	 * @param newDirection
	 */
	public void changeHeadDirection(char newDirection) {
		setPreviousCellDirection(getCurrentCellDirection());
		setCurrentCellDirection(newDirection);
	}
}
