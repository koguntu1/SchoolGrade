package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * This is the AverageOfGradesStrategy class
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class AverageOfGradesStrategy extends SumOfGradesStrategy {

	/**
	 * This is calculate method
	 * 
	 * @param grades
	 * @return double
	 */
	@Override
	public double calculate(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades list can not be null");
		}
		if (grades.isEmpty()) {
			return 0.0D;
		}
		double sum = super.calculate(grades);
		return sum / grades.size();
	}
}