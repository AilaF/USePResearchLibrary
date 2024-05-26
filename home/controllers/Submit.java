package home.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Submit {

	@FXML
	Label label, randomNo;
	
	@FXML
    private Button btnOK;
	
	
	@FXML
    void buttonOK(javafx.event.ActionEvent mouseEvent) {
		if (mouseEvent.getSource() == btnOK) {
			loadStage("/home/Home.fxml");
    }
	}
		
		 private void loadStage(String fxml) {
	            try {
	                Parent root = FXMLLoader.load(getClass().getResource(fxml));
	                
	                Stage currentStage = (Stage) btnOK.getScene().getWindow();
	                currentStage.close();
	                
	                Stage stage = new Stage();
	                stage.setScene(new Scene(root));
	                stage.initModality(Modality.APPLICATION_MODAL);
	                stage.show();
	                
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	
	
		 public void displayName(String date, String name, int id, String program, String title, String doi, int year) {
			    label.setText("\nDate: " + date
			                    + "\n\n\n\nTitle: " + title + "\nDOI: " + doi 
			    				+ "\n\n\n\nName: " + name + "\n" + "ID: " + id
			                    + "\nProgram: " + program);
			}
		 


		 
		 public void setRandomNumber(int randomNumber) {
		        randomNo.setText("Seat No: " + randomNumber);
		    }
	
}