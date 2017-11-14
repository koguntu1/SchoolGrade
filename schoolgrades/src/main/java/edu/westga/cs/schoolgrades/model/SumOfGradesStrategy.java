package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Strategy for calculating a grade by summing several grades.
 * 
 * @author lewisb
 *
 */
public class SumOfGradesStrategy implements GradeCalculationStrategy {

	@Override
	public double calculate(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades should not be null");
		}
		
		double sum = 0;
		for (Grade grade: grades) {
			sum += grade.getValue();
		}
		return sum;
	}

}
