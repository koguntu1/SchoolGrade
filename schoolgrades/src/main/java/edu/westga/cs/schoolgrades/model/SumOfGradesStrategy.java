package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * This is SumOfGradesStrategy class
 *
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */

public class SumOfGradesStrategy implements GradeCalculationStrategy {

	/**
	 * This is calculate method
	 * 
	 * @author Keith Oguntuwase
	 *
	 * @param grades
	 * @return double
	 */

	@Override
	public double calculate(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades should not be null");
		}
		double sum = 0.0D;
		for (Grade grade : grades) {
			sum += grade.getValue();
		}
		return sum;
	}
}