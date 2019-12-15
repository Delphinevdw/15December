/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;

import Logic.Booking;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author delph
 */
public class InternalReportsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView popularAirportsListView; 
    @FXML
    private TableView tripsBookedTable;
    @FXML
    private TextField txtMonth; 
    @FXML
    private Button checkbtn; 
    
    private AnchorPane dataPane; 
    
    //TripsBookedTable
    @FXML
    private TableColumn<Booking, String> priceColumn;

    @FXML
    private TableColumn<Booking, String> orginColumn;
        //Origin en destination van volledig traject dus en arr time is arr time van laatste vlucht
    @FXML
    private TableColumn<Booking, String> destinationColumn;
    
    @FXML
    private TableColumn<Booking, String> depDateTimeColumn;

    @FXML
    private TableColumn<Booking, String> arrDateTimeColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        // Top 5 airports moeten erop komen aan de hand van meest voorkomend in de bookingen
        //Lijst van alle bookingen erin plaatsen; dus ergens een contructor maken voor elementen met net de 5 gegevens die we nodig hebben
        //dat dan in array? en hier invullen in de tableview (set value) 
    }    
    
    /*
    MouseEvent ook terug bij checkbtn zetten 
    @FXML
    private void CheckRevenuePerMonth(MouseEvent Mouseevent) 
    {
        //omzet: som prijs alle boekingen
    }*/
}
