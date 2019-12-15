/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;

import Logic.Flight;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author delph
 */
public class SummaryFlightController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtTicketNumber;
    @FXML
    private Button generateOverviewbtn;
    @FXML
    private TableView overviewTable;
    @FXML
    private AnchorPane dataPane;
    @FXML
    private ListView totalPriceListView;
    //overviewTable
    
    @FXML
    private TableColumn<Flight, String> fromColumn;
    @FXML
    private TableColumn<Flight, String> toColumn;
    @FXML
    private TableColumn<Flight, LocalDateTime> depDateTimeColumn;
    @FXML
    private TableColumn<Flight, LocalDateTime> arrDateTimeColumn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Nu het vullen van de tabel niet hier want eerst moet nog het ticketnummer meegegeven worden 
    }    
    
    /*
    MouseEvent ook nog bij de knop zelf zetten (maar dan werkt gui efjes niet
    private void GenerateOverview(MouseEvent Mouseevent) 
    {
        //omzet: som prijs alle boekingen
    }*/
}
