/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;


import Database.DBException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import Logic.Booking;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author delph
 */
public class PassengerInfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtFirstName; 
    @FXML
    private TextField txtLastName; 
    @FXML
    private TextField txtDateOfBirth; 
    @FXML
    private CheckBox CBMale; 
    @FXML
    private CheckBox CBFemale; 
    @FXML
    private CheckBox CBX; 
    @FXML
    private TextField txtPassportNumber; 
    @FXML
    private TextField txtNationality; 
    @FXML
    private Button Submitbtn; 
    @FXML
    private Button Next; //deze moet n(aantal personen)-1 keer ingedrukt worden 
    // weglaten indien we 1 booking per 1 persoon doen
    @FXML
    private AnchorPane dataPane;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
    @FXML 
    public void genderMaleHandler() {
        if( CBMale.isSelected()){
            CBFemale.setSelected(false);
            CBX.setSelected(false);
        }
    }
    
    @FXML 
    public void genderFemaleHandler() {
        if( CBFemale.isSelected()){
            CBMale.setSelected(false);
            CBX.setSelected(false);
        }
    }
    
    @FXML 
    public void genderXHandler() {
        if( CBX.isSelected()){
            CBFemale.setSelected(false);
            CBMale.setSelected(false);
        }
    }
    
    @FXML
    public void addTraveller(ActionEvent event)
    {
      
        {
            String firstname = txtFirstName.getText();
            String lastname = txtLastName.getText();
            String dateofbirth = txtDateOfBirth.getText();
            String gender;
            boolean male = CBMale.isSelected();
            boolean female = CBFemale.isSelected();
            boolean x = CBX.isSelected();
            
            if (male = true)
                {
                    gender = "m";  
                }
            if(female = true)
                {
                    gender = "v";
                }
            else
                gender = "x";
            

            String passportnr = txtPassportNumber.getText();
            String nationality = txtNationality.getText();
            
            
            this.loadPassengerInfopane(event);
        }
        

        {
            // exceptions zijn verplicht door de les, hier mss als bvb een int ipv String ingegeven wordt een exception geven op het scherm
            // dat het foute formaat ingegeven is.
        }
    }
    
    @FXML
    private void loadMainbookerpane(ActionEvent event) 
    {
      try 
      {          
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/project/gui/Mainbooker.fxml"));
        dataPane.getChildren().setAll(pane);           
      } 
      catch (IOException ex) 
      {
        Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    @FXML
    private void loadPassengerInfopane(ActionEvent event) 
    {
      try 
      {          
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("PassengerInfo.fxml"));
        dataPane.getChildren().setAll(pane);           
      } 
      catch (IOException ex) 
      {
        Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
