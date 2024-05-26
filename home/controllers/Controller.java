package home.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.io.IOException;
import home.Researches;

public class Controller implements Initializable{
	 private Researches researches = new Researches();
	 
	 private List<String> searchList(String searchWords, List<String> listOfStrings) {

         List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

         return listOfStrings.stream().filter(input -> {
             return searchWordsArray.stream().allMatch(word ->
                     input.toLowerCase().contains(word.toLowerCase()));
         }).collect(Collectors.toList());
     }


	
	@FXML
	private Button btnSearch, btnSubmit, btnAI, btnAR, btnAgriculture, btnCrypto, btnCybersecurity, btnDataSci, btnIoT, btnRobotics, btnVR;

	@FXML
	private Pane pnResearches, pnlStatus, pnAI, pnAR, pnAgriculture, pnCrypto, pnCybersec, pnDatasci, pnIOT, pnRobotics, pnVR;
	    
	@FXML
	private Label randomNumbers, lblErrorMessage, lblStatus, label;
	    
	@FXML
	private TextField txtDOI, txtDate, txtID, txtName, txtProgram, txtTitle, txtYear, searchBar;

	
	@FXML
    private ListView<String> listView;
	
	@FXML
    void search(javafx.event.ActionEvent event) {
		if (event.getSource() == btnSearch) {
        	lblStatus.setText("All Researches");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY))); 
            pnResearches.toFront();
        } 
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),researches.getWords()));
    }
	
    @FXML
    	private ResourceBundle resources;

    @FXML
    	private URL location;
    
   
    @FXML
    void initialize() {
    }
    
    @FXML
    void buttonClicks(javafx.event.ActionEvent mouseEvent) throws IOException {
		if (mouseEvent.getSource() == btnSubmit) {
		String name = txtName.getText();
    	String doi = txtDOI.getText();
    	String program = txtProgram.getText();
    	String title = txtTitle.getText();
    	String date = txtDate.getText();
    	
    	
    	 int id=0, year=0;
         try {
             id = Integer.parseInt(txtID.getText());
             year = Integer.parseInt(txtYear.getText());
             
         } catch (NumberFormatException e) {
        	
        	 lblErrorMessage.setText("Invalid input. Please enter numeric values for ID and year.");
             return; 

             }         
         	lblErrorMessage.setText("");
      
         	if (doi.isEmpty() || !researches.getWords().stream().anyMatch(input -> input.contains(doi))) {
                lblErrorMessage.setText("No research found with the given DOI.");
                return;
            }
         	
         	 for (String research : researches.getWords()) {
                 if (research.contains(doi)) {
                     title = research.split("DOI: ")[0].trim();
                     break;
                 }
             }

    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/home/Lib.fxml"));
    	Parent root = loader.load();
    	
        Stage currentStage = (Stage) btnSubmit.getScene().getWindow();
        currentStage.close();
    	
    	Submit submit = loader.getController();
    	submit.displayName(date, name, id, program, title, doi, year);

    	
    	int randomNumber = Integer.parseInt(randomNumbers.getText().replace("Seat No: ", ""));
        submit.setRandomNumber(randomNumber);

    			
    	Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
		
	}
    }
    
    @FXML
    void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
    	if (mouseEvent.getSource() == btnAI) {
        	lblStatus.setText("Artificial Intelligence");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY))); 
            pnAI.toFront();
        } 
    	
        else if (mouseEvent.getSource() == btnAR) {
        	lblStatus.setText("Augmented Reality");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnAR.toFront();       
        } 
    	
        else if (mouseEvent.getSource() == btnAgriculture) {
        	lblStatus.setText("Agriculture");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnAgriculture.toFront();
        } 
    	
        else if (mouseEvent.getSource() == btnCrypto) {
        	lblStatus.setText("Cryptocurrency");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnCrypto.toFront();
        } 
    	
        else if (mouseEvent.getSource() == btnCybersecurity) {
        	lblStatus.setText("Cybersecurity");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnCybersec.toFront();
        } 
    	
        else if (mouseEvent.getSource() == btnDataSci) {
        	lblStatus.setText("Data Science");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnDatasci.toFront();
        } 
    	
        else if (mouseEvent.getSource() == btnIoT) {
        	lblStatus.setText("Internet of Things");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnIOT.toFront();
        } 
    	
        else if (mouseEvent.getSource() == btnRobotics) {
        	lblStatus.setText("Robotics");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnRobotics.toFront();
        } 
    	
        else if (mouseEvent.getSource() == btnVR) {
        	lblStatus.setText("Research Transaction");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0),CornerRadii.EMPTY, Insets.EMPTY)));
            pnVR.toFront();
        }
    	
    	
    }
    
    	private void generateRandomNumber() {
    		Random rand = new Random();
    		int randomNumber = rand.nextInt(15) + 1;
    		randomNumbers.setText("Seat No: " + randomNumber);
    }
    	
    	
        @Override
        public void initialize(URL location, ResourceBundle resources) {
        	 generateRandomNumber();
        	 listView.getItems().addAll(researches.getWords());
           
        }
        
        
    	
    
    }

