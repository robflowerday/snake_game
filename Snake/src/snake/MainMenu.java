package snake;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainMenu {

	// Attributes
	Label currentUserLabel = new Label();
	Label newUserErrorLabel = new Label("");
	Label deleteUserErrorLabel = new Label("");
	
	Button playGameButton = new Button("Play Game");
	Button changeUserButton = new Button("Change User");
	Button deleteUserButton = new Button("Delete User");
	Button addNewUserButton = new Button("Add New User");
	Button userSettingsButton = new Button("Change Settings and Controls");
	Button leaderboardButton = new Button("Leaderboard");
	Button quitButton = new Button("Quit");
	
	ChoiceBox userChoiceBox = new ChoiceBox();
	ChoiceBox deleteUserChoiceBox = new ChoiceBox();
	
	TextField newUserTextField = new TextField();
	
	HBox newUserHBox = new HBox(20);
	HBox deleteUserHBox = new HBox(20);
	HBox currentUserHBox = new HBox(20);
	HBox leaderboardHBox = new HBox(20);
	HBox settingsHBox = new HBox(20);
	HBox quitHBox = new HBox(20);
	HBox playGameHBox = new HBox(20);
	HBox currentUserLabelHBox = new HBox(20);
	
	private VBox root = new VBox(30);
	
	Leaderboard leaderboardInstance = new Leaderboard();
	BoardSize bs = new BoardSize();
	Asthetics a = new Asthetics();

	
	FileClass fc = new FileClass();
	
	// Methods
	
	public void customiseControls() {
		a.c(playGameButton);
		a.c(changeUserButton);
		a.c(deleteUserButton);
		a.c(addNewUserButton);
		a.c(userSettingsButton);
		a.c(leaderboardButton);
		a.c(quitButton);
		a.c(root);
		root.setMinHeight(bs.getWindowHeight());
		root.setMinWidth(bs.getWindowWidth());
		root.setPadding(new Insets(50, 0, 0, 50));
		a.c(currentUserLabel);
	}
	
	public void alignNodes() {
		newUserHBox.setAlignment(Pos.CENTER_LEFT);
		deleteUserHBox.setAlignment(Pos.CENTER_LEFT);
		currentUserHBox.setAlignment(Pos.CENTER_LEFT);
		leaderboardHBox.setAlignment(Pos.CENTER_LEFT);
		settingsHBox.setAlignment(Pos.CENTER_LEFT);
		quitHBox.setAlignment(Pos.CENTER_LEFT);
		playGameHBox.setAlignment(Pos.CENTER_LEFT);
		currentUserLabelHBox.setAlignment(Pos.CENTER_LEFT);
		
		root.setAlignment(Pos.TOP_CENTER);
	}
	
	public Button getLeaderboardButton() {
		return leaderboardButton;
	}
	
	public Button getUserSettingsButton() {
		return userSettingsButton;
	}
	
	public Button getPlayGameButton() {
		return playGameButton;
	}
	
	public VBox getRoot() {
		
		clearControls();
		customiseControls();
		alignNodes();
		
		currentUserLabel.setText("Playing as " + fc.getCurrentUser() + " current High Score: " + fc.getCurrentUserHighScore());
	
		updateUserChoiceBoxes();
		
		newUserTextField.setMinWidth(50);
		
		newUserHBox.getChildren().addAll(addNewUserButton, newUserTextField, newUserErrorLabel);
		
		deleteUserHBox.getChildren().addAll(deleteUserButton, deleteUserChoiceBox, deleteUserErrorLabel);
		
		leaderboardHBox.getChildren().addAll(leaderboardButton);
		settingsHBox.getChildren().addAll(userSettingsButton);
		quitHBox.getChildren().addAll(quitButton);
		
		currentUserHBox.getChildren().addAll(changeUserButton, userChoiceBox);
		
		playGameHBox.getChildren().add(playGameButton);
		
		root.getChildren().addAll(currentUserLabel, currentUserHBox, newUserHBox, deleteUserHBox, playGameHBox, settingsHBox, leaderboardHBox, quitHBox);		
		
		return root;
	}
	
	public void clearControls() {
		newUserHBox.getChildren().clear();
		settingsHBox.getChildren().clear();
		leaderboardHBox.getChildren().clear();
		quitHBox.getChildren().clear();
		currentUserHBox.getChildren().clear();
		newUserErrorLabel.setText("");
		newUserHBox.getChildren().clear();
		deleteUserHBox.getChildren().clear();
		deleteUserErrorLabel.setText("");
		root.getChildren().clear();
		playGameHBox.getChildren().clear();
		currentUserLabelHBox.getChildren().clear();
	}
	
	public void updateUserChoiceBoxes() {
		userChoiceBox.getItems().clear();
		deleteUserChoiceBox.getItems().clear();
		for (String item : fc.getUserList()) {
			userChoiceBox.getItems().add(item);
			deleteUserChoiceBox.getItems().add(item);
		}		
	}
	
	public void setMainMenuLogic() {
		
		addNewUserButton.setOnAction(e -> {
			if (newUserTextField.getText().isBlank()) {
				newUserErrorLabel.setText("User name must include a character");
			} else if (userChoiceBox.getItems().contains(newUserTextField.getText())) {
				newUserErrorLabel.setText("User name already taken");
			} else {
				newUserErrorLabel.setText("New user Created");
				fc.addUserToUserListFile(newUserTextField.getText());
				UserClass user = new UserClass(newUserTextField.getText());
				fc.createUserFile(user);
				updateUserChoiceBoxes();
			}
		});
		
		deleteUserButton.setOnAction(e -> {
			
			if (!("" + deleteUserChoiceBox.getValue()).equals(fc.getCurrentUser())) {
				fc.deleteUserFromUserListFile("" + deleteUserChoiceBox.getValue());
				fc.openUserFile("" + deleteUserChoiceBox.getValue());
				fc.deleteFile();
				updateUserChoiceBoxes();
			} else {
				deleteUserErrorLabel.setText("cannot delete the current user");
			}
		});
		
		changeUserButton.setOnAction(e -> {
			fc.changeCurrentUser("" + userChoiceBox.getValue());
			currentUserLabel.setText("Playing as " + fc.getCurrentUser() + " current High Score: " + fc.getCurrentUserHighScore());
		});
		
		quitButton.setOnAction(e -> {
			Platform.exit();
		});
	}
	
	

}
