/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;

import Database.DBException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import Logic.Traveler; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author delph
 */
public class CustomerManagementController implements Initializable {

    //alle travelers moeten weer gegeven worden en op een of andere manier: op een persoon klikken 
    //denk ik en dan edit of delete aanklikken?
    @FXML
    private TableView <Traveler> customerManagementTable; 
    
    @FXML
    private TableColumn<Traveler, String> passportNrColumn;
    @FXML
    private TableColumn<Traveler, String> firstNameColumn;
    
    @FXML
    private TableColumn<Traveler, String> lastNameColumn;

    @FXML
    private TableColumn<Traveler, String> dateOfBirthColumn;

    @FXML
    private TableColumn<Traveler, String> emailColumn;
    
    @FXML
    private TableColumn<Traveler, String> genderColumn;

    @FXML
    private TableColumn<Traveler, String> nationalityColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        // TODO
        //Agency is hier de klasse waar de methode getTraveler ofzo zou moeten instaan
        // onderstaand is overgenomen van iemand anders: moet de kolommen vullen
        
        agency = Agency.getInstance();
        try {
            travelers = FXCollections.observableArrayList(agency.getCustomers());
        } catch (DBException ex) {
            Logger.getLogger(CustomerManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        customerManagementTable.setItems(travelers);
        cnum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCnum()).asObject());
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstname()));
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastname()));
        dateOfBirthColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateofbirth().toString()));
        passportNrColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassportnr()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));
        nationalityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNationality()));
*/
    }    
    
}
