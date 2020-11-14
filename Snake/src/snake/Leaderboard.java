package snake;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Leaderboard {
	
	// Attributes
	Label titleLabel = new Label("Learderboard");
	Label leaderboardLabel = new Label();
	
	private VBox root = new VBox(30);
	
	Button mainMenuButton = new Button("Main Menu");
	Button quitButton = new Button("Quit");
	
	HBox mainMenuHBox = new HBox(20, mainMenuButton);
	HBox quitHBox = new HBox(20, quitButton);
	HBox labelHBox = new HBox(20, leaderboardLabel);
	HBox titleLabelHBox = new HBox(20, titleLabel);
	
	Asthetics a = new Asthetics();
	BoardSize bs = new BoardSize();
	FileClass fc = new FileClass();
	
	String[] positionArray = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th"};
			
	// Methods
	
	public void customiseControls() {
		a.c(mainMenuButton);
		a.c(quitButton);
		a.c(leaderboardLabel);
		a.c(titleLabel);
		a.c(root);
		root.setMinHeight(bs.getWindowHeight());
		root.setMinWidth(bs.getWindowWidth());
		root.setPadding(new Insets(50, 0, 0, 50));
	}
	
	public void alignNodes() {
		mainMenuHBox.setAlignment(Pos.CENTER_LEFT);
		quitHBox.setAlignment(Pos.CENTER_LEFT);
		labelHBox.setAlignment(Pos.CENTER_LEFT);
		titleLabelHBox.setAlignment(Pos.CENTER_LEFT);
		root.setAlignment(Pos.TOP_CENTER);
	}
	
	public Button getMainMenuButton() {
		return mainMenuButton;
	}
	
	public VBox getRoot() {
		
		customiseControls();
		alignNodes();

		root.getChildren().clear();
		
		// Use insertion sort (as the list is small, and will often be nearly sorted to sort the list from high to low
		ArrayList<String> userList = fc.getUserList();
		ArrayList<Integer> highScores = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			highScores.add(Integer.parseInt(fc.getUserHighScore(userList.get(i))));
		}
		
		for (int j = 1; j < highScores.size(); j++) {
			int key = highScores.get(j);
			String userKey = userList.get(j);
			int i = j - 1;
			while ((i > -1)&&(highScores.get(i) < key)) {
				highScores.set(i + 1, highScores.get(i));
				userList.set(i + 1, userList.get(i));
				i = i - 1;
			}
			highScores.set(i + 1, key);
			userList.set(i + 1, userKey);
		}
		
		String resultsString = "";
		if (userList.size() <= 10) {
			for (int i=0; i < userList.size(); i++) {
				resultsString = resultsString + positionArray[i] + "\t" + userList.get(i) + "\t\t" + highScores.get(i) + "\n";
			}
		} else {
			for (int i=0; i < 10; i++) {
				resultsString = resultsString + positionArray[i] + "\t" + userList.get(i) + "\t\t" + highScores.get(i) + "\n";
			}
		}
		
		// use the result in a label
		leaderboardLabel.setText(resultsString);
		
		root.getChildren().addAll(titleLabelHBox, labelHBox, mainMenuHBox, quitHBox);

		quitButton.setOnAction(e -> {
			Platform.exit();
		});
		
		return root;
	}
}
