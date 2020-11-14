package snake;

import javafx.scene.paint.Color;

public class Cell extends BoardSize {
	
	// Attributes
	private int cellHeight = 10;	// height of a cell
	private int cellWidth = 10;		// width of a cell
	private int cellXPosition;		// x position of the cell in the snake playing area
	private int cellYPosition;		// y position of the cell in the snake playing area
	private Color cellColour;		// colour of cell
	
	// Methods
	
	// Constructors
	/**
	 * construct cell object with default height and width
	 * int height: 10
	 * int width: 10
	 */
	public Cell() {
		cellHeight = 10;
		cellWidth = 10;
	}
	
	/**
	 * construct cell object with default height and width
	 * int height: 10
	 * int width: 10
	 * Color cell clour = cellColourIn
	 * int cell x position = cellXPosition
	 * int cell y position = cellYosition
	 * @param cellColourIn
	 * @param cellXPositionIn
	 * @param cellYPositionIn
	 */
	public Cell(Color cellColourIn, int cellXPositionIn, int cellYPositionIn) {
		cellHeight = 10;
		cellWidth = 10;
		cellColour = cellColourIn;
		cellXPosition = cellXPositionIn;
		cellYPosition = cellYPositionIn;
	}
	
	// Getters and Setters
	// Getters
	/**
	 * return the height of a cell
	 * @return int
	 */
	public int getCellHeight() {
		return cellHeight;
	}
	
	/**
	 * return the width of a cell
	 * @return int
	 */
	public int getCellWidth() {
		return cellWidth;
	}
	
	/**
	 * return the x position of a cell in the snake playing area
	 * @return int
	 */
	public int getCellXPosition() {
		return cellXPosition;
	}
	
	/**
	 * return the y position of a cell in the snake playing area
	 * @return int
	 */
	public int getCellYPosition() {
		return cellYPosition;
	}
	
	/**
	 * return the colour of a cell
	 * @return
	 */
	public Color getCellColour() {
		return cellColour;
	}
	
	// Setters
	/**
	 * set the height of a cell
	 * @param cellHeightIn
	 */
	public void setCellHeight(int cellHeightIn) {
		cellHeight = cellHeightIn;
	}
	
	/**
	 * set the width of a cell
	 * @param cellWidthIn
	 */
	public void setCellWidth(int cellWidthIn) {
		cellWidth = cellWidthIn;
	}
	
	/**
	 * set the x position of a cell in the snake playing area
	 * @param cellXPositionIn
	 */
	public void setCellXPosition(int cellXPositionIn) {
		cellXPosition = cellXPositionIn;
	}
	
	/**
	 * set the y position of a cell in the snake playing area
	 * @param cellYPositionIn
	 */
	public void setCellYPosition(int cellYPositionIn) {
		cellYPosition = cellYPositionIn;
	}
	
	/**
	 * set the colour of a cell
	 * @param cellColourIn
	 */
	public void setCellColour(Color cellColourIn) {
		cellColour = cellColourIn;
	}
}