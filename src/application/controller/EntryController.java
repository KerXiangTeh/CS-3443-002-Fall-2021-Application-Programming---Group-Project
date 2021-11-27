package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EntryController {

    @FXML
    private Button back_btn;

    @FXML
    private Button submit_btn;
    
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
    void submit(ActionEvent event) {

    }

}
