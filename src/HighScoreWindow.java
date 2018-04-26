import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class HighScoreWindow {

	public static void display(FileIO fileIO) {
		Stage window = new Stage();
				
		window.setTitle("High Score");
		window.setMinWidth(250);
		window.setMinHeight(250);
		
		Label text = new Label("The High Score is $" +fileIO.getHighScore()+"");
		
		Button closeButton = new Button("Close");
		
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		
		layout.getChildren().addAll(closeButton, text);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		//window.showAndWait();
		window.show();
	}
	
}
