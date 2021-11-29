package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import application.model.Entry;
import application.model.dataIO;
import application.model.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField password_field;

    @FXML
    private TextField username_field;
    
    @FXML
    private Label error_text;

    @FXML
    private Button login_btn;
    
    @FXML
    private AnchorPane mainPane;
    
    private ArrayList<user> userList;
    
    final ObservableList<Entry> entries = FXCollections.observableArrayList();
    
    public void initialize() {
    	userList = dataIO.loadUsers("users.csv");
    	Collections.sort(userList);
    	
    	//creating an array of Entries with dummy data 
    	//entries.add(new Entry())
    }
    
    /*private ObservableList<Entry> getEntries() {
		
		ObservableList<Entry> entries = FXCollections.observableArrayList();
		entries.add(new Entry("Hotdogs", LocalDate.of(2021, Month.SEPTEMBER, 1), "2800", "970"));
		entries.add(new Entry("Durian", LocalDate.of(2021, Month.SEPTEMBER, 2), "1800", "1333"));
		entries.add(new Entry("Apple", LocalDate.of(2021, Month.SEPTEMBER, 3), "400", "421"));
		
		return entries;
	}*/
    
    @FXML
    void login(ActionEvent event) throws IOException {
    	String username = username_field.getText();
    	String password = password_field.getText();
    	
    	int index = Collections.binarySearch(userList, new user(username));
    	if (index >= 0 && userList.get(index).validate(username, password)) {
    		dataIO.writeUser(userList.get(index));
    		switchToHomeScreen(event, userList.get(index));
    	}
    	else {
    		error_text.setText("Invalid Login Credentials");
    	}
    }
    
    public void switchToHomeScreen(ActionEvent event, user u) throws IOException {
    	URL url = new File("src/application/view/Home.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);	//pane we are GOING TO show
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();	//pane we are ON
    	window.setScene(scene);
    	window.show();
    }

}
