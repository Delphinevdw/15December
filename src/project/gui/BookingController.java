/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;

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
import javafx.scene.layout.Pane;
import Logic.Booking;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author delph
 */
public class BookingController  {

   
    @FXML
    private Button flightbtn;
    @FXML
    private Button summarybtn;
    @FXML
    private Button passengerInfobtn; 
    @FXML
    private Button customerManagementbtn; 
    @FXML
    private Button customerReportbtn; 
    @FXML
    private Button internalReportbtn; 
    
    @FXML
    private AnchorPane navigationPane;
    @FXML
    private AnchorPane dataPane; 


    public void initialize(URL url, ResourceBundle rb) 
    {
        //booking = Booking.getInstance();
    }    
    
    /*Vanaf deze pane zijn er meerdere schermen die via knoppen op die andere panes aan elkaar gekoppeld worden, terugkeren
    in het systeem is onmogelijk, een booking moet in een keer gebeuren */
    
  
    private void navigationHandler(String page){
        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource(page  + ".fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void flightHandler(MouseEvent mouseEvent) {
        navigationHandler("FlightRequirements");
    }
    
    public void passengerHandler(MouseEvent mouseEvent) {
        navigationHandler("PassengerInfo");
    }
    
    @FXML
    public void summaryHandler(MouseEvent mouseEvent) {
        navigationHandler("SummaryFlight");
    }
    
    public void customerManagementHandler(MouseEvent mouseEvent) {
        navigationHandler("CustomerManagement");
    }
    
    @FXML
    public void customerReportHandler(MouseEvent mouseEvent) {
        navigationHandler("CustomerReport");
    }
   
    @FXML
    public void internalReportHandler(MouseEvent mouseEvent){
        navigationHandler("InternalReport");
    } 
    
    }
    
    
    
    
    
    
    
    
    
   

        
    
    
    
    
    
    
    
    
    
    
    


       
   

