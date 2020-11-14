package snake;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SettingsControls {
	
	// Attributes
	FileClass fc = new FileClass();
	String currentUser = fc.getCurrentUser();
	Label playingAsLabel = new Label("Controls for " + currentUser);
	Asthetics a = new Asthetics();
	BoardSize bs = new BoardSize();
	
	private Color snakeColour = fc.getSnakeColour(currentUser);
	private Color fruitColour = fc.getFruitColour(currentUser);
	private String snakeSpeed = fc.getSpeed(currentUser);
	private String upControl = fc.getUpControl(currentUser);
	private String leftControl = fc.getLeftControl(currentUser);
	private String rightControl = fc.getRightControl(currentUser);
	private String downControl = fc.getDownControl(currentUser);
	
	ChoiceBox snakeColourChoiceBox = new ChoiceBox();
	Label snakeColourLabel = new Label("Snake Colour:");
	Rectangle snakeColourRectangle = new Rectangle();
	
	ChoiceBox fruitColourChoiceBox = new ChoiceBox();
	Label fruitColourLabel = new Label("Fruit Colour:");
	Rectangle fruitColourRectangle = new Rectangle();

	Label upButtonSetLabel = new Label("Set new up control character");
	TextField upTextField = new TextField();
	Label upControlLabel = new Label("Up control: " + upControl);
	
	Label leftButtonSetLabel = new Label("Set left control character");
	TextField leftTextField = new TextField();
	Label leftControlLabel = new Label("Left control: " + leftControl);

	Label rightButtonSetLabel = new Label("Set new right control character");
	TextField rightTextField = new TextField();
	Label rightControlLabel = new Label("Right control: " + rightControl);

	Label downButtonSetLabel = new Label("Set new down control character");
	TextField downTextField = new TextField();
	Label downControlLabel = new Label("Down control: " + downControl);

	Slider speedSlider = new Slider();
	Label speedLabel = new Label("Snake speed: " + Integer.parseInt(snakeSpeed));
	
	Button mainMenuButton = new Button("Main Menu");
	Button quitButton = new Button("Quit");
	
	
	HBox snakeColourHBox = new HBox(20);
	HBox fruitColourHBox = new HBox(20);
	HBox snakeSpeedHBox = new HBox(20);
	HBox upControlHBox = new HBox(20);
	HBox leftControlHBox = new HBox(20);
	HBox rightControlHBox = new HBox(20);
	HBox downControlHBox = new HBox(20);
	HBox mainMenuHBox = new HBox(20);
	HBox quitHBox = new HBox(20);
	
	private VBox root = new VBox(30);
	
	// Methods
	
	public void customiseControls() {
		a.c(snakeColourLabel);
		a.c(fruitColourLabel);
		a.c(speedLabel);
		a.c(playingAsLabel);
		a.c(downControlLabel);
		a.c(upControlLabel);
		a.c(leftControlLabel);
		a.c(rightControlLabel);
		a.c(mainMenuButton);
		a.c(quitButton);
		a.c(root);
		root.setMinHeight(bs.getWindowHeight());
		root.setMinWidth(bs.getWindowWidth());
		root.setPadding(new Insets(50, 0, 0, 50));
	}
	
	public void alignNodes() {
		playingAsLabel.setAlignment(Pos.CENTER_LEFT);
		snakeColourHBox.setAlignment(Pos.CENTER_LEFT);
		fruitColourHBox.setAlignment(Pos.CENTER_LEFT);
		snakeSpeedHBox.setAlignment(Pos.CENTER_LEFT);
		upControlHBox.setAlignment(Pos.CENTER_LEFT);
		leftControlHBox.setAlignment(Pos.CENTER_LEFT);
		rightControlHBox.setAlignment(Pos.CENTER_LEFT);
		downControlHBox.setAlignment(Pos.CENTER_LEFT);
		mainMenuHBox.setAlignment(Pos.CENTER_LEFT);
		quitHBox.setAlignment(Pos.CENTER_LEFT);
		
		root.setAlignment(Pos.TOP_CENTER);
	}
	
	public void calibrateVariablesAndLabels() {
		currentUser = fc.getCurrentUser();
		playingAsLabel = new Label("Controls for " + currentUser);
		
		snakeColour = fc.getSnakeColour(currentUser);
		fruitColour = fc.getFruitColour(currentUser);
		snakeSpeed = fc.getSpeed(currentUser);
		upControl = fc.getUpControl(currentUser);
		leftControl = fc.getLeftControl(currentUser);
		rightControl = fc.getRightControl(currentUser);
		downControl = fc.getDownControl(currentUser);
		
		upControlLabel.setText("Up control: " + upControl);
		leftControlLabel.setText("Left control: " + leftControl);
		rightControlLabel.setText("Right control: " + rightControl);
		downControlLabel.setText("Down control: " + downControl);
		speedLabel.setText("Snake speed: " + Integer.parseInt(snakeSpeed));
		
	}
	
	public void clearContainers() {
		snakeColourHBox.getChildren().clear();
		fruitColourHBox.getChildren().clear();
		snakeSpeedHBox.getChildren().clear();
		upControlHBox.getChildren().clear();
		leftControlHBox.getChildren().clear();
		rightControlHBox.getChildren().clear();
		downControlHBox.getChildren().clear();
		mainMenuHBox.getChildren().clear();
		quitHBox.getChildren().clear();
		root.getChildren().clear();
	}
	
	public Button getMainMenuButton() {
		return mainMenuButton;
	}
	
	public void setSliderControls() {
		speedSlider.setMin(1);
		speedSlider.setMax(10);
		speedSlider.setValue(Integer.parseInt(snakeSpeed));
		speedSlider.setShowTickLabels(true);
		speedSlider.setShowTickMarks(true);
		speedSlider.setMajorTickUnit(1);
		speedSlider.setMinorTickCount(0);
		speedSlider.setBlockIncrement(1);
		speedSlider.setSnapToTicks(true);
	}
	
	public void setRectangles() {
		snakeColourRectangle.setHeight(10);
		snakeColourRectangle.setWidth(10);
		snakeColourRectangle.setFill(snakeColour);
		fruitColourRectangle.setHeight(10);
		fruitColourRectangle.setWidth(10);
		fruitColourRectangle.setFill(fruitColour);
	}
	
	public void setChoiceBoxes() {
		String[] colours = {"blue", "gold", "black", "brown", "green", "pink", "red", "purple", "yellow"};
		for (String colour : colours) {
			snakeColourChoiceBox.getItems().add(colour);
			fruitColourChoiceBox.getItems().add(colour);
		}
	}
	
	public VBox getRoot() {
		
		clearContainers();
		calibrateVariablesAndLabels();
		
		customiseControls();
		alignNodes();
		
		setSliderControls();
		setRectangles();
		setChoiceBoxes();
		
		snakeColourHBox.getChildren().addAll(snakeColourChoiceBox, snakeColourLabel, snakeColourRectangle);
		fruitColourHBox.getChildren().addAll(fruitColourChoiceBox, fruitColourLabel, fruitColourRectangle);
		snakeSpeedHBox.getChildren().addAll(speedSlider, speedLabel);
		upControlHBox.getChildren().addAll(upTextField, upControlLabel);
		leftControlHBox.getChildren().addAll(leftTextField, leftControlLabel);
		rightControlHBox.getChildren().addAll(rightTextField, rightControlLabel);
		downControlHBox.getChildren().addAll(downTextField, downControlLabel);
		mainMenuHBox.getChildren().addAll(mainMenuButton);
		quitHBox.getChildren().addAll(quitButton);
		
		root.getChildren().addAll(playingAsLabel, snakeColourHBox, fruitColourHBox, snakeSpeedHBox, upControlHBox, leftControlHBox, rightControlHBox, downControlHBox, mainMenuHBox, quitHBox);
		
		settingsControlsLogic();
		
		return root;
	}
	
	public void settingsControlsLogic() {
		snakeColourChoiceBox.setOnAction(e -> {
			Color colour = Color.RED;
			if (snakeColourChoiceBox.getValue().equals("blue")) {
				colour = Color.BLUE;
			} else if (snakeColourChoiceBox.getValue().equals("gold")) {
				colour = Color.GOLD;
			} else if (snakeColourChoiceBox.getValue().equals("black")) {
				colour = Color.BLACK;
			} else if (snakeColourChoiceBox.getValue().equals("brown")) {
				colour = Color.BROWN;
			} else if (snakeColourChoiceBox.getValue().equals("green")) {
				colour = Color.GREEN;
			} else if (snakeColourChoiceBox.getValue().equals("pink")) {
				colour = Color.PINK;
			} else if (snakeColourChoiceBox.getValue().equals("red")) {
				colour = Color.RED;
			} else if (snakeColourChoiceBox.getValue().equals("purple")) {
				colour = Color.PURPLE;
			} else if (snakeColourChoiceBox.getValue().equals("yellow")) {
				colour = Color.YELLOW;
			}
			snakeColour = colour;
			snakeColourRectangle.setFill(colour);
			fc.rewriteUserSnakeColour(currentUser, colour);
		});
		
		fruitColourChoiceBox.setOnAction(e2 -> {
			Color colour = Color.RED;
			if (fruitColourChoiceBox.getValue().equals("blue")) {
				colour = Color.BLUE;
			} else if (fruitColourChoiceBox.getValue().equals("gold")) {
				colour = Color.GOLD;
			} else if (fruitColourChoiceBox.getValue().equals("black")) {
				colour = Color.BLACK;
			} else if (fruitColourChoiceBox.getValue().equals("brown")) {
				colour = Color.BROWN;
			} else if (fruitColourChoiceBox.getValue().equals("green")) {
				colour = Color.GREEN;
			} else if (fruitColourChoiceBox.getValue().equals("pink")) {
				colour = Color.PINK;
			} else if (fruitColourChoiceBox.getValue().equals("red")) {
				colour = Color.RED;
			} else if (fruitColourChoiceBox.getValue().equals("purple")) {
				colour = Color.PURPLE;
			} else if (fruitColourChoiceBox.getValue().equals("yellow")) {
				colour = Color.YELLOW;
			}
			fruitColour = colour;
			fruitColourRectangle.setFill(colour);
			fc.rewriteUserFruitColour(currentUser, colour);
		});
		
		speedSlider.setOnMouseDragged(e3 -> {
			snakeSpeed = "" + (int) speedSlider.getValue();
			speedLabel.setText("Snake speed: " + Integer.parseInt(snakeSpeed));
			fc.rewriteUserSpeed(currentUser, snakeSpeed);
		});
		
		speedSlider.setOnKeyReleased(e4 -> {
			snakeSpeed = "" + (int) speedSlider.getValue();
			speedLabel.setText("Snake speed: " + Integer.parseInt(snakeSpeed));
			fc.rewriteUserSpeed(currentUser, snakeSpeed);
		});
		
		speedSlider.setOnMouseClicked(e5 -> {
			snakeSpeed = "" + (int) speedSlider.getValue();;
			speedLabel.setText("Snake speed: " + Integer.parseInt(snakeSpeed));
			fc.rewriteUserSpeed(currentUser, snakeSpeed);
		});
		
		upTextField.setOnKeyTyped(e6 -> {
			if (upTextField.getText().length() != 1) {
				upTextField.setText("" + upTextField.getText().charAt(0));
			}
			
			upControl = upTextField.getText();
			fc.rewriteUserUpControl(currentUser, upControl);
			upControlLabel.setText("Up control: " + upControl);
		});
		
		downTextField.setOnKeyTyped(e7 -> {
			if (downTextField.getText().length() != 1) {
				downTextField.setText("" + downTextField.getText().charAt(0));
			}

			downControl = downTextField.getText();
			fc.rewriteUserDownControl(currentUser, downControl);
			downControlLabel.setText("Down control: " + downControl);
		});
		
		leftTextField.setOnKeyTyped(e8 -> {
			if (leftTextField.getText().length() != 1) {
				leftTextField.setText("" + leftTextField.getText().charAt(0));
			}
			
			leftControl = leftTextField.getText();
			fc.rewriteUserLeftControl(currentUser, leftControl);
			leftControlLabel.setText("Left control: " + leftControl);
		});
		
		rightTextField.setOnKeyTyped(e9 -> {
			if (rightTextField.getText().length() != 1) {
				rightTextField.setText("" + rightTextField.getText().charAt(0));
			}
			
			rightControl = rightTextField.getText();
			fc.rewriteUserRightControl(currentUser, rightControl);
			rightControlLabel.setText("Right control: " + rightControl);
		});
		
		quitButton.setOnAction(e -> {
			Platform.exit();
		});
	}
}
