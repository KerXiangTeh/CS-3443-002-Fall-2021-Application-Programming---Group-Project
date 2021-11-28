package application.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class Entry {

	private SimpleStringProperty item;
	private LocalDate enteredDate;
	private SimpleStringProperty calories;
	private SimpleStringProperty consumed;
	
	public Entry(String item, LocalDate enteredDate, String calories, String consumed) {
		this.item = new SimpleStringProperty(item);
		this.enteredDate = enteredDate;
		this.calories = new SimpleStringProperty(calories);
		this.consumed = new SimpleStringProperty(consumed);
	}

	public String getItem() {
		return item.get();
	}

	public void setItem(String item) {
		this.item = new SimpleStringProperty(item);
	}

	public SimpleStringProperty getConsumed() {
		return consumed;
	}

	public void setConsumed(String consumed) {
		this.consumed = new SimpleStringProperty(consumed);
	}

	public LocalDate getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(LocalDate enteredDate) {
		this.enteredDate = enteredDate;
	}

	public String getCalories() {
		return calories.get();
	}

	public void setCalories(String calories) {
		this.calories = new SimpleStringProperty(calories);
	}
	
	
}
