package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.ObservableList;

/**
 * A {@link Grade} representing the aggregation of several other grades. Uses a {@link GradeCalculationStrategy} to determine
 * the calculation for the aggregate score.
 * 
 * @author lewisb
 *
 */
public class CompositeGrade implements Grade {

	private final GradeCalculationStrategy strategy;
	private final List<Grade> childGrades;
	
	/**
	 * Creates a new CompositeGrade using the given strategy.
	 * 
	 * @param strategy the strategy to use for grade calculation. Must not be null.
	 */
	public CompositeGrade(GradeCalculationStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("strategy must not be null");
		}
		
		this.strategy = strategy;
		this.childGrades = new ArrayList<Grade>();
	}
	
	/**
	 * Adds a {@link Grade} to this CompositeGrade.
	 * 
	 * @param grade the grade to add. Must not be null and must not already exist in this CompositeGrade
	 */
	public void add(final Grade grade) {
		if (grade == null) {
			throw new IllegalArgumentException("grade can not be null");
		}
		
		if (childGrades.contains(grade)) {
			throw new IllegalArgumentException("can not add the same grade twice");
		}
		
		childGrades.add(grade);
	}
	
	/**
	 * Gets the {@link Grade}s contained in this CompositeGrade
	 * 
	 * @return all contained grades
	 */
	public List<Grade> getGrades() {
		return Collections.unmodifiableList(childGrades);
	}
	
	@Override
	public double getValue() {
		return strategy.calculate(childGrades);
	}

	/**
	 * Convenience method to add all grades in the list.
	 * 
	 * @param grades the list of grades to add. Will not allow duplicates or nulls inside the list.
	 */
	public void addAll(List<? extends Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades can not be null");
		}
		
		for (Grade grade: grades) {
			this.add(grade);
		}
	}

}
