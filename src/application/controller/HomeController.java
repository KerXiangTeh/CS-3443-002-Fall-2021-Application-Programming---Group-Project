package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;

import application.model.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button new_entry_btn;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private Button weekly_btn;

    @FXML
    private TableColumn<Entry, String> tableCalories;

    @FXML
    private CategoryAxis time;

    @FXML
    private NumberAxis calories;

    @FXML
    private Button logout_btn2;

    @FXML
    private TableView<Entry> table;

    @FXML
    private TableColumn<Entry, LocalDate> tableDate;
    
    @FXML
    private AnchorPane mainPane;

    @FXML
    void logout(ActionEvent event) throws IOException{

    	URL url = new File("src/application/view/Login.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);	//pane we are GOING TO show
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();	//pane we are ON
    	
    	window.setScene(scene);
    	window.show();
}

    @FXML
    void newEntry(ActionEvent event) throws IOException {

    	URL url = new File("src/application/view/Entry.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);	//pane we are GOING TO show
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();	//pane we are ON
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void weekly(ActionEvent event) throws IOException {

    	URL url = new File("src/application/view/Weekly.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);	//pane we are GOING TO show
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();	//pane we are ON
    	window.setScene(scene);
    	window.show();
    }
    
    public void initialize() {
    	XYChart.Series series = new XYChart.Series<>();
    	series.setName("Calories");
    	
    	series.getData().add(new XYChart.Data("9/1",2800));
    	series.getData().add(new XYChart.Data("9/2",1800));
    	series.getData().add(new XYChart.Data("9/3",400));
    	series.getData().add(new XYChart.Data("9/4",3000));
    	
    	XYChart.Series series2 = new XYChart.Series<>();
    	series2.setName("Goal");
    	
    	series2.getData().add(new XYChart.Data("9/1",2000));
    	series2.getData().add(new XYChart.Data("9/2",2000));
    	series2.getData().add(new XYChart.Data("9/3",2000));
    	series2.getData().add(new XYChart.Data("9/4",2000));
    	
    	lineChart.getData().addAll(series, series2);
    	
    	//setup the columns in the table
    	tableDate.setCellValueFactory(new PropertyValueFactory<Entry, LocalDate>("enteredDate"));
    	tableCalories.setCellValueFactory(new PropertyValueFactory<Entry, String>("calories"));
    
    	//load data
    	table.setItems(getEntries());
    }

	private ObservableList<Entry> getEntries() {
		
		ObservableList<Entry> entries = FXCollections.observableArrayList();
		entries.add(new Entry("Hotdogs", LocalDate.of(2021, Month.SEPTEMBER, 1), "2800"));
		entries.add(new Entry("Durian", LocalDate.of(2021, Month.SEPTEMBER, 2), "1800"));
		entries.add(new Entry("Apple", LocalDate.of(2021, Month.SEPTEMBER, 3), "400"));
		entries.add(new Entry("Pizza", LocalDate.of(2021, Month.SEPTEMBER, 4), "3000"));
		
		return entries;
	}

}
