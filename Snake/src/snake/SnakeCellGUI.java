package snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeCellGUI extends SnakeCell {
	
	// Attributes
	Rectangle cellRectangle;
	
	// Methods
	
	// Constructors
	public SnakeCellGUI(Color snakeColourIn) {
		super(snakeColourIn);
		setCellHeight(10);
		setCellWidth(10);
		setCellXPosition(getBoardWidth()/2 - getCellWidth()/2);
		setCellYPosition(getBoardHeight()/2 - getCellHeight()/2);
		cellRectangle = new Rectangle(getCellXPosition(), getCellYPosition(), getCellWidth(), getCellHeight());
		cellRectangle.setFill(getCellColour());
	}

	public SnakeCellGUI(SnakeCell snakeCellIn) {
		super(snakeCellIn);
		setCellHeight(10);
		setCellWidth(10);
		setCellColour(snakeCellIn.getCellColour());
		setCellXPosition(snakeCellIn.getPreviousCellXPosition());
		setCellYPosition(snakeCellIn.getPreviousCellYPosition());
		setCurrentCellDirection(snakeCellIn.getPreviousCellDirection());
		cellRectangle = new Rectangle(getCellXPosition(), getCellYPosition(), getCellWidth(), getCellHeight());
		cellRectangle.setFill(getCellColour());
	}
	
	// Getters and Setters
	// Getters
	/**
	 * returns the rectangle object of the cell
	 * @return Rectangle
	 */
	public Rectangle getCellRectangle() {
		return cellRectangle;
	}
	
	public void reCalibrateCellRectangle() {
		cellRectangle.setX(getCellXPosition());
		cellRectangle.setY(getCellYPosition());
		cellRectangle.setHeight(getCellHeight());
		cellRectangle.setWidth(getCellWidth());
	}
}
