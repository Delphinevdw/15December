/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import Logic.Booking;
import Logic.Flight;
import java.sql.Time;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author delph
 */
public class FlightRequirementsController implements Initializable 
{

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtFrom;
    @FXML
    private TextField txtTo; 
    private TextField txtnumberOfTravelers;
    @FXML
    private Button searchBookingbtn; 
    private CheckBox CBDuration; 
    private CheckBox CBPrice; 
    private CheckBox CBCO2; 
    private CheckBox CBTransfers; 
    
    private Booking model;
    
    @FXML
    private AnchorPane flightPane;
    @FXML
    private TextField txtAdults;
    @FXML
    private DatePicker departure;
    @FXML
    private DatePicker leavingdate;
    
    // Niet tableView<Flight>, want de paden moeten gegeven worden
    // path= BRU-AMS-LAX : een string die aangemaakt moet worden  in klasse flightpath
    @FXML
    private TableView flightView;
    @FXML
    private TableView returnFlightView; 
    
    @FXML
    private AnchorPane dataPane;
    
    //flightView
    private TableColumn<Flight, String> pathColumn;
    @FXML
    private TableColumn<Flight, LocalDateTime> arrDateTimeColumn;
    @FXML
    private TableColumn<Flight, LocalDateTime> depDateTimeColumn;
    @FXML
    private TableColumn<Flight,Integer > transfersColumn;
    @FXML
    private TableColumn<Flight, Integer> CO2Column;
    @FXML
    private TableColumn<Flight, Double> priceColumn;
    @FXML
    private TableColumn<Flight, Time> durationColumn;
    
    //returnFlightView
    private TableColumn<Flight, String> returnPathColumn;
    @FXML
    private TableColumn<Flight, LocalDateTime> returnArrDateTimeColumn;
    @FXML
    private TableColumn<Flight, LocalDateTime> returnDepDateTimeColumn;
    @FXML
    private TableColumn<Flight,Integer > returnTransfersColumn;
    @FXML
    private TableColumn<Flight, Integer> returnCO2Column;
    @FXML
    private TableColumn<Flight, Double> returnPriceColumn;
    @FXML
    private TableColumn<Flight, Time> returnDurationColumn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
    //gebeurt als op de knop search booking geklikt wordt
   
    
    // is wss fout de volgende 4 voids
    private void navigationHandler(String page) {
        try {
            AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource(page + ".fxml"));
            dataPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void OptionSingleFlightHandler(MouseEvent mouseEvent) {
            navigationHandler("OptionSingleFlight");
    }
    @FXML 
    public void mainConcernCO2Handler() {
        if( CBCO2.isSelected()){
            CBDuration.setSelected(false);
            CBPrice.setSelected(false);
            CBTransfers.setSelected(false);
        }
    }
    
    @FXML 
    public void mainConcernDurationHandler() {
        if( CBDuration.isSelected()){
            CBCO2.setSelected(false);
            CBPrice.setSelected(false);
            CBTransfers.setSelected(false);
        }
    }
    
    @FXML 
    public void mainConcernPriceHandler() {
        if( CBPrice.isSelected()){
            CBDuration.setSelected(false);
            CBCO2.setSelected(false);
            CBTransfers.setSelected(false);
        }
    }
    
    @FXML 
    public void mainConcernTransfersHandler() {
        if( CBTransfers.isSelected()){
            CBDuration.setSelected(false);
            CBPrice.setSelected(false);
            CBCO2.setSelected(false);
        }
    }
    
    @FXML
    private void SearchBooking(ActionEvent event)
        
        {
            String origin = txtFrom.getText();
            String destination = txtTo.getText();
            int numberOfTravelers = Integer.parseInt(txtnumberOfTravelers.getText());
           
            boolean duration = CBDuration.isSelected();
            boolean price = CBPrice.isSelected();
            boolean CO2 = CBCO2.isSelected();
            boolean transfers = CBTransfers.isSelected();
            LocalDate arrivalTime = (LocalDate)departure.getValue();
            //Moet omgezet worden naar een localDateTime door tijd; 00:00:01 eraan te hangen?
            
            /* aan de hand van deze info moet er dus nu gezocht worden naar een rij in de array uit de 
            databaselayer, uit de tabel specific flight naar die voldoen aan de voorwaarden
            
            we geven de vluchten 3 dagen rond de vertrekdatum en 3 dagen rond de 'terugkeer datum'
            gevonden rijen moeten dan in de volgende pane weergegeven worden */
            
            
        }
    
}
