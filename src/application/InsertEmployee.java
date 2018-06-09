package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InsertEmployee {

	

	@FXML
	private TextField empname;
	@FXML
	private TextField password;
	@FXML
	private TextField salary;
	@FXML
	private TextField department;
	@FXML
	private TextField address;
	@FXML
	private Label checkAdded; 
	
	public void insertData(ActionEvent e) throws IOException{
		
	String empName= empname.getText();
	String txtpassword= password.getText();
	String textSalary= salary.getText();
	String textDepatment= department.getText();
	String textAddress= address.getText();
	
	float fSalary = Float.parseFloat(textSalary);

	Employee emp = new Employee();  
	
	emp.setEmpname(empName);
	emp.setPassword(txtpassword);
	emp.setSalary(fSalary);
	emp.setDepartment(textDepatment);
	emp.setAddress(textAddress);
		
	int status=  DBInfo.save(emp);
	  	 
	  if(status>0){  
		  	   
		/*  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("Information Dialog");
		  alert.setContentText("Record saved successfully!");

		  alert.showAndWait();
		  */
		  
		  checkAdded.setText("Employee has been saved successfully!");
		  
     //     System.out.println(" Record saved successfully! ");  
		  
           
      }else{  
    	  
    	  
		/*  Alert alert = new Alert(AlertType.ERROR);
		  alert.setTitle("Data Insert");
		  alert.setHeaderText("ERROR Dialog");
		  alert.setContentText("Sorry! unable to save record");

		  alert.showAndWait();
    	  */
    	  
    	  checkAdded.setText("Sorry! unable to save the Employee !");
    	  
    	//  System.out.println("Sorry! unable to save record");  
      }  
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
