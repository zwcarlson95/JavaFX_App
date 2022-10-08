package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Option1 extends Application{
	@Override
    public void start(Stage stage) {
 
	 	stage.setTitle("Option #1 ");
	 	
	 	TilePane r = new TilePane();
        Menu menu  = new Menu("Menu");
        	       
        CustomMenuItem getDateMenu     = new CustomMenuItem(new Button("Show Date"));
        CustomMenuItem exportDateMenu  = new CustomMenuItem(new Button("Export Date"));
        CustomMenuItem changeColorMenu = new CustomMenuItem(new Button("Change Color"));
        CustomMenuItem closeUIMenu     = new CustomMenuItem(new Button("Close UI"));
        
        menu.getItems().add(getDateMenu);
        menu.getItems().add(exportDateMenu);
        menu.getItems().add(changeColorMenu);
        menu.getItems().add(closeUIMenu);
        
        MenuBar menuBar = new MenuBar();
        VBox vbox       = new VBox(menuBar);
    	Scene scene     = new Scene(vbox, 400, 200);
    	
        menuBar.getMenus().add(menu);	    	        	    	        
    	stage.setScene(scene);
    	stage.show();
        
    	
        getDateMenu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ZonedDateTime today = ZonedDateTime.now();
                Alert alert     = new Alert(AlertType.INFORMATION);
                alert.setTitle("Date Printer");
                alert.setHeaderText(null);
                alert.setContentText("Today's Date is: " + today);
                alert.showAndWait();
            }
        });
        
        exportDateMenu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ZonedDateTime today = ZonedDateTime.now();
                
                try {            	
                	PrintWriter f = new PrintWriter(new FileOutputStream("/Users/ZachCarlson/Documents/log.txt"));           		
            		f.println(today);            			
            		f.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        changeColorMenu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int color = ThreadLocalRandom.current().nextInt(100, 256);
                
                vbox.setBackground(new Background(new BackgroundFill(Color.rgb(0, color, 0), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        
        closeUIMenu.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
         
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        

        
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }

}
