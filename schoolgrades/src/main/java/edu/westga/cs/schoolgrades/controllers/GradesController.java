package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculationStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

/**
 * This is the GradesController class
 *
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class GradesController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField finalGradeTextField;

	@FXML
	private ListView<SimpleGrade> quizzesListView;

	@FXML
	private TextField quizSubtotalTextField;

	@FXML
	private ListView<SimpleGrade> homeworkListView;

	@FXML
	private TextField homeworkSubtotalTextField;

	@FXML
	private ListView<SimpleGrade> examsListView;

	@FXML
	private TextField examSubtotalTextField;

	@FXML
	private Button recalculateButton;
	private ObservableList<SimpleGrade> quizGrades;
	private ObservableList<SimpleGrade> homeworkGrades;
	private ObservableList<SimpleGrade> examGrades;
	private DoubleProperty quizSubtotalProperty;
	private DoubleProperty homeworkSubtotalProperty;
	private DoubleProperty examSubtotalProperty;
	private DoubleProperty finalGradeProperty;

	@FXML
	void initialize() {
		assert (this.finalGradeTextField != null) : "fx:id=\"finalGradeTextField\" was not injected: check your FXML file 'GradesGui.fxml'.";
		assert (this.recalculateButton != null) : "fx:id=\"recalculateButton\" was not injected: check your FXML file 'GradesGui.fxml'.";
		assert (this.quizzesListView != null) : "fx:id=\"quizzesListView\" was not injected: check your FXML file 'GradesGui.fxml'.";
		assert (this.quizSubtotalTextField != null) : "fx:id=\"quizSubtotalTextField\" was not injected: check your FXML file 'GradesGui.fxml'.";
		assert (this.homeworkListView != null) : "fx:id=\"homeworkListView\" was not injected: check your FXML file 'GradesGui.fxml'.";
		assert (this.homeworkSubtotalTextField != null) : "fx:id=\"homeworkSubtotalTextField\" was not injected: check your FXML file 'GradesGui.fxml'.";
		assert (this.examsListView != null) : "fx:id=\"examsListView\" was not injected: check your FXML file 'GradesGui.fxml'.";
		assert (this.examSubtotalTextField != null) : "fx:id=\"examSubtotalTextField\" was not injected: check your FXML file 'GradesGui.fxml'.";

		setupGui();
	}

	private void setupGui() {
		setupState();
		setupQuizListView();
		setupHomeworkListView();
		setupExamListView();
		setupQuizSubtotalTextField();
		setupHomeworkSubtotalTextField();
		setupExamSubtotalTextField();
		setupFinalGradeTextField();

		populateWithTestGrades();
	}

	private void recalculateAll() {
		calculatFinalGradeSubtotal();
	}

	private Grade calculatFinalGradeSubtotal() {
		Grade quizSubtotal = new WeightedGrade(calculateQuizSubtotal(), 0.2D);
		Grade homeworkSubtotal = new WeightedGrade(calculateHomeworkSubtotal(), 0.3D);
		Grade examSubtotal = new WeightedGrade(calculateExamSubtotal(), 0.5D);
		CompositeGrade compositeGrade = new CompositeGrade(new SumOfGradesStrategy());
		compositeGrade.add(quizSubtotal);
		compositeGrade.add(homeworkSubtotal);
		compositeGrade.add(examSubtotal);
		this.finalGradeProperty.set(compositeGrade.getValue());
		return compositeGrade;
	}

	private Grade calculateExamSubtotal() {
		GradeCalculationStrategy strategy = new AverageOfGradesStrategy();
		CompositeGrade compositeGrade = new CompositeGrade(strategy);
		compositeGrade.addAll(this.examGrades);
		this.examSubtotalProperty.set(compositeGrade.getValue());
		return compositeGrade;
	}

	private Grade calculateHomeworkSubtotal() {
		GradeCalculationStrategy strategy = new DropLowestStrategy(new AverageOfGradesStrategy());
		CompositeGrade compositeGrade = new CompositeGrade(strategy);
		compositeGrade.addAll(this.homeworkGrades);
		this.homeworkSubtotalProperty.set(compositeGrade.getValue());
		return compositeGrade;
	}

	private Grade calculateQuizSubtotal() {
		GradeCalculationStrategy strategy = new SumOfGradesStrategy();
		CompositeGrade compositeGrade = new CompositeGrade(strategy);
		compositeGrade.addAll(this.quizGrades);
		this.quizSubtotalProperty.set(compositeGrade.getValue());
		return compositeGrade;
	}

	private void setupFinalGradeTextField() {
		this.finalGradeTextField.textProperty().bindBidirectional(this.finalGradeProperty, new NumberStringConverter());
	}

	private void setupExamSubtotalTextField() {
		this.examSubtotalTextField.textProperty().bindBidirectional(this.examSubtotalProperty,
				new NumberStringConverter());
	}

	private void setupHomeworkSubtotalTextField() {
		this.homeworkSubtotalTextField.textProperty().bindBidirectional(this.homeworkSubtotalProperty,
				new NumberStringConverter());
	}

	private void setupQuizSubtotalTextField() {
		this.quizSubtotalTextField.textProperty().bindBidirectional(this.quizSubtotalProperty,
				new NumberStringConverter());
	}

	private void populateWithTestGrades() {
		for (int i = 0; i < 3; i++) {
			SimpleGrade grade = new SimpleGrade(i * 10);
			this.quizGrades.add(grade);
		}
		for (int i = 3; i >= 1; i--) {
			SimpleGrade grade = new SimpleGrade(i * 20);
			this.homeworkGrades.add(grade);
		}
		this.examGrades.add(new SimpleGrade(99.0D));
		this.examGrades.add(new SimpleGrade(88.0D));
		this.examGrades.add(new SimpleGrade(77.0D));

		this.quizSubtotalProperty.set(30.0D);
		this.homeworkSubtotalProperty.set(50.0D);
		this.examSubtotalProperty.set(88.0D);
		this.finalGradeProperty.set(65.0D);
	}

	private void setupState() {
		this.quizGrades = FXCollections.observableArrayList();
		this.homeworkGrades = FXCollections.observableArrayList();
		this.examGrades = FXCollections.observableArrayList();
		this.finalGradeProperty = new SimpleDoubleProperty();
		this.examSubtotalProperty = new SimpleDoubleProperty();
		this.homeworkSubtotalProperty = new SimpleDoubleProperty();
		this.quizSubtotalProperty = new SimpleDoubleProperty();
	}

	private void setupQuizListView() {
		this.quizzesListView.setItems(this.quizGrades);
		this.quizzesListView.setCellFactory(new GradeCellFactory());
	}

	private void setupHomeworkListView() {
		this.homeworkListView.setItems(this.homeworkGrades);
		this.homeworkListView.setCellFactory(new GradeCellFactory());
	}

	private void setupExamListView() {
		this.examsListView.setItems(this.examGrades);
		this.examsListView.setCellFactory(new GradeCellFactory());
	}

	@FXML
	void onRecalculateButtonClick(ActionEvent event) {
		recalculateAll();
	}

	@FXML
	void onAddExamMenuItemClick(ActionEvent event) {
		this.examGrades.add(new SimpleGrade(0.0D));
		sendFocusToLastCell(this.examsListView);
	}

	@FXML
	void onAddHomeworkMenuItemClick(ActionEvent event) {
		this.homeworkGrades.add(new SimpleGrade(0.0D));
		sendFocusToLastCell(this.homeworkListView);
	}

	@FXML
	void onAddQuizMenuItemClick(ActionEvent event) {
		this.quizGrades.add(new SimpleGrade(0.0D));
		sendFocusToLastCell(this.quizzesListView);
	}

	private void sendFocusToLastCell(ListView<SimpleGrade> listView) {
		listView.getSelectionModel().selectLast();
		int index = listView.getSelectionModel().getSelectedIndex();
		listView.requestFocus();
		listView.getFocusModel().focus(index);
	}
}
