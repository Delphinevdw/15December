/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author delph
 */
public class NewFXMain extends Application 
{
    
  
    @Override
    public void start(Stage stage) throws IOException 
    {
    /*FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
    Parent root = loader.load();*/
        
    Parent root = FXMLLoader.load(getClass().getResource("Booking.fxml")) ;   
        
    stage.setScene(new Scene(root));
    stage.show();
   }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
