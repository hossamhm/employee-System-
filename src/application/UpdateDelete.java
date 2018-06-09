package application;

import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateDelete {

	

	
	@FXML	
	TextField idEmployee;
	@FXML	
	private TextField empname;
	@FXML
	private TextField salary;
	@FXML
	private TextField age;
	@FXML
	private TextField department;
	@FXML
	private TextField address;
	@FXML
	private Label checkUpdatedDeleted;
	  
	public void getEmployeeById(ActionEvent e) throws IOException, ParseException{
		
		
		String sid=idEmployee.getText();  
	    int id=Integer.parseInt(sid);   
		
	    Employee emp=DBInfo.getEmployeeId(id); 
 
	    
	    empname.setText(emp.getEmpname());
	    salary.setText(String.valueOf(emp.getSalary()));
	    department.setText( emp.getDepartment());
	    address.setText( emp.getAddress());
		
	}
	
	
	
	public void updateEmployee(ActionEvent e) throws IOException, ParseException{
		
		
		String sid=idEmployee.getText();  
	    int id=Integer.parseInt(sid);  
	    
	    String textName        =     empname.getText();
	   	float textsalary        =     Float.parseFloat(salary.getText());
	    String textdepart       =     department.getText();
	    String textaddress      =     address.getText();
	    
	    Employee emp=new Employee();  
	    
        emp.setId(id);
		emp.setEmpname(textName);
		emp.setSalary(textsalary);
		emp.setDepartment(textdepart);
		emp.setAddress(textaddress);
	
	    int status=DBInfo.update(emp);  
        if(status>0){  
        	
        /*	
  		  Alert alert = new Alert(AlertType.INFORMATION);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("Information Dialog");
  		  alert.setContentText("Record updated successfully!");

  		  alert.showAndWait();
        	*/
        	
        	checkUpdatedDeleted.setText("Employee has been saved successfully!");
        	
        	// System.out.println(" Record saved successfully! ");
        }else{ 
        	
  		  /*
          Alert alert = new Alert(AlertType.ERROR);
  		  alert.setTitle("Data update");
  		  alert.setHeaderText("ERROR Dialog");
  		  alert.setContentText("Sorry! unable to update record");

  		  alert.showAndWait();
        	*/
        	
        	checkUpdatedDeleted.setText("Sorry! unable to update the Employee!");

        	
        //	System.out.println("Sorry! unable to update record");  
        }  
          
	
	
	
	
	
	
	}	
	
	
	
	
	
	
	public void deleteEmployee(ActionEvent e) throws IOException, ParseException{
		
		
		String sid=idEmployee.getText();  
	    int id=Integer.parseInt(sid);   
 
	     
	     int status=  DBInfo.delete(id) ;
	        if(status>0){  
	        	
	        /*	
	  		  Alert alert = new Alert(AlertType.INFORMATION);
	  		  alert.setTitle("Data delete");
	  		  alert.setHeaderText("Information Dialog");
	  		  alert.setContentText("Record deleted successfully!");

	  		  alert.showAndWait();
	        	*/
	        	
	        	checkUpdatedDeleted.setText("Employee has been deleted successfully!!");
	        	
	      //  	 System.out.println(" Record deleted successfully! ");
	        }else{ 
	        	
	  		  /*Alert alert = new Alert(AlertType.ERROR);
	  		  alert.setTitle("Data update");
	  		  alert.setHeaderText("ERROR Dialog");
	  		  alert.setContentText("Sorry! unable to delete record");

	  		  alert.showAndWait();
	        	*/
	        	
	        	checkUpdatedDeleted.setText("Sorry! unable to delete the Employee!");

	        	
	  //      	System.out.println("Sorry! unable to update record");  
	        }  
	          
		     
	     
	     
	     
	     
	     
	     
	     
	    
	  
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
