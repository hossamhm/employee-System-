package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,578,331);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.getIcons().add(new Image(getClass().getResource("../img/employees.png").toString()));
			primaryStage.setTitle("Login EMS");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			System.out.println("Error..");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
