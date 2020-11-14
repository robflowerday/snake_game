package snake;

/**
 * sets the snake playing area height and width, and makes it accessible and modifiable
 * @author Robert Flowerday
 *
 */
public class BoardSize {
	
	// Attributes
	private int boardHeight = 610;	//210;	// height of the snake playing area
	private int boardWidth = 610;	//210;	// width of the snake playing area
	
	// Methods
	
	// Getters and Setters
	// Getters
	/**
	 * returns the snake playing area height
	 * @return int
	 */
	public int getBoardHeight() {
		return boardHeight;
	}
	
	public int getWindowHeight() {
		return boardHeight + 90;
	}
	
	/**
	 * return the snake playing area width
	 * @return int
	 */
	public int getBoardWidth() {
		return boardWidth;
	}
	
	public int getWindowWidth() {
		return boardWidth + 30;
	}
	
	// Setters
	/**
	 * set the snake playing area height
	 * @param boardHeightIn
	 */
	public void setBoardHeight(int boardHeightIn) {
		boardHeight = boardHeightIn;
	}
	
	/**
	 * sets the snake playing area width
	 * @param boardWidthIn
	 */
	public void setWindowWidth(int boardWidthIn) {
		boardWidth = boardWidthIn;
	}
}
