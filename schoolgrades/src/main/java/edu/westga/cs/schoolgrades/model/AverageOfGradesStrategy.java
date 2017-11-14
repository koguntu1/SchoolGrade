package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Strategy for averaging a list of {@link Grade}s
 * @author lewisb
 *
 */
public class AverageOfGradesStrategy extends SumOfGradesStrategy {

	@Override
	public double calculate(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades list can not be null");
		}
		
		if (grades.isEmpty()) {
			return 0;
		}
		
		double sum = super.calculate(grades);
		return sum / grades.size();
	}

}
