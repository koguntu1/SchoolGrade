package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * This is the GradeCellFactory class
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
class GradeCellFactory implements Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>> {
    @Override
	public ListCell<SimpleGrade> call(ListView<SimpleGrade> param) {
        final TextFieldListCell<SimpleGrade> cell = new TextFieldListCell<SimpleGrade>();
        cell.setEditable(true);
        cell.setConverter(new StringConverter<SimpleGrade>() {
            @Override
			public String toString(SimpleGrade grade) {
                String value = String.format("%.2f", new Object[] { 
                        Double.valueOf(grade.getValue()) 
                });
                cell.setAccessibleText(value);
                return value;
            }

            @Override
			public SimpleGrade fromString(String text) {
                try {
                    double value = Double.parseDouble(text);
                    return new SimpleGrade(value);
                } catch (NumberFormatException exc) {
                    throw new IllegalArgumentException("Could not parse text");
                }
            }
        });
        return cell;
    }
}
