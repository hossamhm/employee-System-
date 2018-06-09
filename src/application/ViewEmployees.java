package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewEmployees implements Initializable{


	
	@FXML 
	private TableView<Employee> table;
	@FXML 
	private TableColumn<Employee,Integer> id;
	@FXML 
	private TableColumn<Employee,String> empname;
	@FXML 
	private TableColumn<Employee,String> emppwd;
	@FXML 
	private TableColumn<Employee,Float> salary;
	@FXML 
	private TableColumn<Employee,String> department;
	@FXML 
	private TableColumn<Employee,String> address;

	
 public	ObservableList<Employee> data = FXCollections.observableArrayList();
	  
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		try {
			
			String sql = "SELECT * FROM `employee` WHERE 1";
			Connection con = DBInfo.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				 
				data.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getFloat(5), rs.getString(4), rs.getString(6)));
				 
			}

			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 	
		
		id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
		empname.setCellValueFactory(new PropertyValueFactory<Employee,String>("empname"));
		emppwd.setCellValueFactory(new PropertyValueFactory<Employee,String>("emppwd"));
		salary.setCellValueFactory(new PropertyValueFactory<Employee,Float>("salary"));
		department.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));
		address.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
		
				
		table.setItems(data);
 	
 	
	}
 

	
}
