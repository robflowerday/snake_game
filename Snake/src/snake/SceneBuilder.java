package snake;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SceneBuilder {
	
	// Attributes
	MainMenu mainMenu = new MainMenu();
	Leaderboard leaderboard = new Leaderboard();
	SettingsControls settingsControls = new SettingsControls();
	LevelOne levelOne = new LevelOne();
	
	BoardSize bs = new BoardSize();
	private VBox root = new VBox();
	Scene scene = new Scene(root, bs.getWindowWidth(), bs.getWindowHeight());
	
	// Methods
	
	public Scene getScene() {
		return scene;
	}
	
	public void formatMainMenu() {
		root.getChildren().clear();
		root.getChildren().add(mainMenu.getRoot());
		mainMenu.setMainMenuLogic();
		
		mainMenu.getLeaderboardButton().setOnAction(e -> {
			formatLeaderboard();
		});
		
		mainMenu.getUserSettingsButton().setOnAction(e -> {
			formatSettingsControls();
		});
		
		mainMenu.getPlayGameButton().setOnAction(e -> {
			formatLevelOne();
		});
	}
	
	
	
	public void formatLeaderboard() {
		root.getChildren().clear();
		root.getChildren().add(leaderboard.getRoot());
		
		leaderboard.getMainMenuButton().setOnAction(e -> {
			formatMainMenu();
		});
	}
	
	public void formatSettingsControls() {
		root.getChildren().clear();
		root.getChildren().add(settingsControls.getRoot());
		
		settingsControls.getMainMenuButton().setOnAction(e -> {
			formatMainMenu();
		});
	}
	
	public void formatLevelOne() {
		root.getChildren().clear();
		levelOne.createBoard();
		root.getChildren().addAll(levelOne.getRoot());
		levelOne.scheduleTimer();
		
		scene.setOnKeyTyped(e -> {
			char directionIn = e.getCharacter().charAt(0);
			if (directionIn == levelOne.currentUser.getUpControl()) {
				levelOne.board.snakeBodyGUI.snakeBody.get(0).changeHeadDirection('u');
			} else if (directionIn == levelOne.currentUser.getLeftControl()) {
				levelOne.board.snakeBodyGUI.snakeBody.get(0).changeHeadDirection('l');
			} else if (directionIn == levelOne.currentUser.getRightControl()) {
				levelOne.board.snakeBodyGUI.snakeBody.get(0).changeHeadDirection('r');
			} else if (directionIn == levelOne.currentUser.getDownControl()) {
				levelOne.board.snakeBodyGUI.snakeBody.get(0).changeHeadDirection('d');
			}
			
		});
		
		levelOne.getMainMenuButton().setOnAction(e -> {
			formatMainMenu();
			if (!levelOne.getIsEnded()) {
				levelOne.timer.cancel();
			}
		});
		
	}
	
}
