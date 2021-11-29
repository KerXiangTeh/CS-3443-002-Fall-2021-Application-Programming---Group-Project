package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.Entry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EntryController {

    @FXML
    private TextField food_field;

    @FXML
    private TextField calories_field;
    
    @FXML
    private TextField consumed_field;

    @FXML
    private DatePicker date_picker;

    @FXML
    private Button back_btn;

    @FXML
    private Button submit_btn;

    @FXML
    private Button calculate_btn;
    
    @FXML
    private AnchorPane mainPane;

    @FXML
    void homeScreen(ActionEvent event) throws IOException {

    	URL url = new File("src/application/view/Home.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);	//pane we are GOING TO show
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();	//pane we are ON
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void submit(ActionEvent event) throws IOException {

    	//grabbing info from the fields 
    	Entry entry = new Entry(food_field.getText(), date_picker.getValue(), calories_field.getText(), 
    			consumed_field.getText());
    	
    	//loading the home screen with new data 
    	URL url = new File("src/application/view/Home.fxml").toURI().toURL();
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(url);
		Parent roleViewParent = loader.load();
		HomeController controller = loader.getController();
		
		Scene scene = new Scene(roleViewParent);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
    
        controller.appendEntry(entry);
        
        window.setScene(scene);							//loading the next scene if username & PW matches 
		window.show();
    }

    @FXML
    void consumed_field(ActionEvent event) {

    }

    @FXML
    void calculate(ActionEvent event) {

    }

}
