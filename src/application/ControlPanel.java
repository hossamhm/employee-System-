package application;

 

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControlPanel {
	
	
	public void viewEmployee(ActionEvent e) throws IOException  {
	 
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ViewEmployees.fxml"));
		
		Scene scene = new Scene(root,1100,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();
			 
			
		}
	
	public void insertEmployee(ActionEvent e) throws IOException  {
		 
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("InsertEmployees.fxml"));
		
		Scene scene = new Scene(root,629,366);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}
	
	public void updateDeleteEmployee(ActionEvent e) throws IOException  {
		 
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
		
		Scene scene = new Scene(root,676,455);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();
			 
			
		}

}
