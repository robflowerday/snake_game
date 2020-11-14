package snake;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Asthetics {
	
	// Attributes
	Color buttonBackgroundColour = Color.rgb(86, 159, 210);
	CornerRadii buttonBackgroundCornerRadii = new CornerRadii(30);
	Insets buttonBackgroundInsets = new Insets(0);
	BackgroundFill buttonBackgroundFill = new BackgroundFill(buttonBackgroundColour, buttonBackgroundCornerRadii, buttonBackgroundInsets);
	Background buttonBackground = new Background(buttonBackgroundFill);
	Color buttonTextColour = Color.WHITE;
	
	Color buttonBackgroundColorOnDrag = Color.rgb(191, 144, 0);
	BackgroundFill buttonBackgroundFillOnDrag = new BackgroundFill(buttonBackgroundColorOnDrag, buttonBackgroundCornerRadii, buttonBackgroundInsets);
	Background buttonBackgroundOnDrag = new Background(buttonBackgroundFillOnDrag);
	Font buttonFont= new Font(15);
	
	Color vBoxBackgroundColour = Color.rgb(227, 233, 240);
	CornerRadii vBoxBackgroundCornerRadii = new CornerRadii(0);
	Insets vBoxBackgroundInsets = new Insets(0);
	BackgroundFill vBoxBackgroundFill = new BackgroundFill(vBoxBackgroundColour, vBoxBackgroundCornerRadii, vBoxBackgroundInsets);
	Background vBoxBackground = new Background(vBoxBackgroundFill);
	
	Color labelColour = Color.BLACK;
	Font labelFont = new Font(20);

	// Methods
	public void c(Button buttonIn) {
		buttonIn.setBackground(buttonBackground);
		buttonIn.setTextFill(buttonTextColour);
		
		buttonIn.setFont(buttonFont);
		
		buttonIn.setOnMouseEntered(e -> buttonIn.setBackground(buttonBackgroundOnDrag));
		buttonIn.setOnMouseExited(e -> buttonIn.setBackground(buttonBackground));
	}
	
	public void c(VBox vBoxIn) {
		vBoxIn.setBackground(vBoxBackground);
	}
	
	public void c(Label labelIn) {
		labelIn.setTextFill(labelColour);
		labelIn.setFont(labelFont);
	}
}
