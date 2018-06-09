package application;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class login {

	@FXML
	Label dbConlb;
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	Label check;
	

public void statusDB(ActionEvent e) throws IOException, SQLException{
	
 if(! DBInfo.getConnection().isClosed()){
	 dbConlb.setText("Connected...");
 }else{
	 dbConlb.setText("Not connected");
 }
		 
}
	
public void enterCP(ActionEvent e) throws IOException, SQLException{
	
	
	 List<Employee> list=DBInfo.getEmployee();  // from mysql
	 
	 Map<String, String> map = new HashMap<String, String>();
	 
	 for(Employee emp: list){
	 
		 map.put(emp.getEmpname(), emp.getPassword());
	 }
	 
	
if (username.getText().equals("admin")   ) {
	
	 
	String val2 =map.get(username.getText());
	
	if(val2.equals(password.getText()) ){

		
		check.setText("Success");
				 
		DBInfo.getConnection();
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ControlPanel.fxml"));
		
		Scene scene = new Scene(root,700,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();
	 
		
	}else{
		check.setText("Failed try again");
	}
	
	
	
	
}else{
	check.setText("Failed try again");
}
			 
		 
		
	}


}
