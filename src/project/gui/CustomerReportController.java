/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;

import Logic.CreateReportCO2;
import Logic.Flight;
import Logic.Leg;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import Logic.Traveler;
import java.util.Arrays;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author delph
 */
public class CustomerReportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtPassportNumber;
    @FXML
    private Button getReportbtn;
    @FXML
    private TableView <Traveler> personalInfoTable;
    @FXML
    private TableView  personalBookingTable; 
    @FXML 
    private Hyperlink hyperlink; 
    
    //personal info table 
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
    
    //personal booking table
    @FXML
    private TableColumn<Flight, String> flightIdColumn;

    @FXML
    private TableColumn<Leg, String> orginColumn;
        //Origin en destination van volledig traject dus en arr time is arr time van laatste vlucht
    @FXML
    private TableColumn<Leg, String> destinationColumn;
    
    @FXML
    private TableColumn<Flight, String> CO2Column;
    
    
    private AnchorPane choiceReportpane; 
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) 
    {
       //niet hier want eerst moet het pasportnummer ingegeven worden 
        // of email adres kan ook want dat is ook uniek 
    }    
    
     @FXML

     
    private void getReport(ActionEvent event) 
    {
        String passportnr = txtPassportNumber.getText();
        CreateReportCO2 obj = new CreateReportCO2();
        
        //eerste deel report = persoonsgegevens
        
        ObservableList<Traveler> traveler;
        traveler =  FXCollections.observableArrayList(obj.findTraveler(passportnr));
        
        personalInfoTable.setItems(traveler);

        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstname()));
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastname()));
        dateOfBirthColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateofbirth().toString()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        genderColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));
        nationalityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNationality()));

        
        //tweede deel report = vluchten plus co2

        String[][] resultFindCO2 = obj.findCO2(passportnr);
        //dit resultaat 'report' is een 2D array
        StackPane root = new StackPane();
        
        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(resultFindCO2));
        data.remove(0);//remove titles from data
        TableView<String[]> personalBookingTable = new TableView<>();
        for (int i = 0; i < resultFindCO2[0].length; i++) {
            TableColumn tc = new TableColumn(resultFindCO2[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            personalBookingTable.getColumns().add(tc);
        }
        personalBookingTable.setItems(data);
        root.getChildren().add(personalBookingTable);
    }

}
