package snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RunApplication extends Application {
	
	// Attributes
	SceneBuilder sceneBuilder = new SceneBuilder();
	// Methods
	
	public void start(Stage stage) {
				
		sceneBuilder.formatMainMenu();
		stage.setScene(sceneBuilder.getScene());
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
