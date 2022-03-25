package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		
		//button1 
		
		Button button1 = new Button("Click to Scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		
		//Layout 1 - 
		
		StackPane layout1 = new StackPane();
		layout1.getChildren().addAll(button1);
		scene1 = new Scene(layout1, 500, 300);
		
		//button 2
		Button button2 = new Button("This scene 2 go to Scene 1");
		button2.setOnAction(e -> window.setScene(scene1));
		
		
		//layout 2
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(button2);
		scene2 = new Scene(layout2, 500, 300);
		
		window.setScene(scene1);
		window.setTitle("Scene1");
		window.show();
	}
	//This works
	
}
