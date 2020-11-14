package snake;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LevelOne {
	
	// Attributes
	FileClass fc = new FileClass();
	BoardSize boardSize = new BoardSize();	
	Asthetics a = new Asthetics();
	
	String currentUserName = fc.getCurrentUser();
	UserClass currentUser = new UserClass(currentUserName, Integer.parseInt(fc.getUserHighScore(currentUserName)), fc.getSnakeColour(currentUserName), fc.getFruitColour(currentUserName), Integer.parseInt(fc.getSpeed(currentUserName)), fc.getUpControl(currentUserName).charAt(0), fc.getLeftControl(currentUserName).charAt(0), fc.getDownControl(currentUserName).charAt(0), fc.getRightControl(currentUserName).charAt(0));
	BoardSize bs = new BoardSize();
	
	VBox root = new VBox(30);	
	Board board;	
	Button mainMenuButton = new Button("MainMenu");	
	boolean fruitThere = false;
	int[] fruitPosition = new int[] {0, 0};
	Rectangle fruit;
	boolean isEnded = false;
	Timer timer;
	int score = 0;
	Label scoreLabel = new Label("score: " + score);
	HBox topHBox = new HBox(20, mainMenuButton, scoreLabel);
	
	
	// Methods	
	public boolean getIsEnded() {
		return isEnded;
	}
	
	public void clearContainers() {
		root.getChildren().clear();
	}
	
	public void createBoard() {
		board = new Board(currentUser.getSnakeColour());
	}
	
	public Button getMainMenuButton() {
		return mainMenuButton;
	}
	
	public VBox getRoot() {
		currentUserName = fc.getCurrentUser();
		currentUser = new UserClass(currentUserName, Integer.parseInt(fc.getUserHighScore(currentUserName)), fc.getSnakeColour(currentUserName), fc.getFruitColour(currentUserName), Integer.parseInt(fc.getSpeed(currentUserName)), fc.getUpControl(currentUserName).charAt(0), fc.getLeftControl(currentUserName).charAt(0), fc.getDownControl(currentUserName).charAt(0), fc.getRightControl(currentUserName).charAt(0));
		
		clearContainers();

		createBoard();
		a.c(mainMenuButton);
		a.c(scoreLabel);
		root.setMinHeight(bs.getWindowHeight());
		root.setMinWidth(bs.getWindowWidth());
		root.setPadding(new Insets(20, 0, 0, 0));
		a.c(root);
		root.setAlignment(Pos.TOP_CENTER);
		topHBox.setAlignment(Pos.TOP_CENTER);
		
		root.getChildren().addAll(topHBox, board.snakeBoard);
		return root;
	}
		

	
	public void scheduleTimer() {
		timer = new Timer();
		fruitThere = false;
		score = 0;
		isEnded = false;
		scoreLabel.setText("score: " + score);

		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			public void run() {
				if (board.snakeBodyGUI.snakeBody.get(0).getCellXPosition() >= 10 && 
					board.snakeBodyGUI.snakeBody.get(0).getCellXPosition() + board.snakeBodyGUI.snakeBody.get(0).getCellWidth() <= boardSize.getBoardWidth() - 10 &&
					board.snakeBodyGUI.snakeBody.get(0).getCellYPosition() >= 10 &&
					board.snakeBodyGUI.snakeBody.get(0).getCellYPosition() + board.snakeBodyGUI.snakeBody.get(0).getCellHeight() <= boardSize.getBoardHeight() - 10
				) {
					board.snakeBodyGUI.moveSnake();
					for (int i=1; i < board.snakeBodyGUI.snakeBody.size(); i++) {
						if (board.snakeBodyGUI.snakeBody.get(0).getCellXPosition() == board.snakeBodyGUI.snakeBody.get(i).getPreviousCellXPosition() &&
							board.snakeBodyGUI.snakeBody.get(0).getCellYPosition() == board.snakeBodyGUI.snakeBody.get(i).getPreviousCellYPosition()) {
							timer.cancel();
							isEnded = true;
						}
					}
					if (fruitThere == false) {
						fruitPosition = board.makeRandomPosition();
						fruit = board.makeFruit(fruitPosition[0], fruitPosition[1], currentUser.getFruitColour());
						Platform.runLater(() -> board.snakeBoard.getChildren().add(fruit));
						fruitThere = true;
					} else if (board.snakeBodyGUI.snakeBody.get(0).getCellXPosition() == fruitPosition[0] &&
							   board.snakeBodyGUI.snakeBody.get(0).getCellYPosition() == fruitPosition[1]) {
						Platform.runLater(() -> board.snakeBoard.getChildren().remove(fruit));
						fruitThere = false;
						board.snakeBodyGUI.addBodyCell();
						score++;
						Platform.runLater(() -> {
							board.snakeBoard.getChildren().add(board.snakeBodyGUI.snakeBody.get(board.snakeBodyGUI.snakeBody.size()-1).getCellRectangle());
							scoreLabel.setText("score: " + score);
							if (score > currentUser.getHighScore()) {
								fc.rewriteUserHighScore(currentUser.getUserName(), "" + score);
							}
						});
					}
					} else {
						timer.cancel();
						isEnded = true;
					}
			}
		};
		timer.schedule(task, 0, (currentUser.getSnakeSpeed()*(-10)) + 130);
		}
	
	
	

}
