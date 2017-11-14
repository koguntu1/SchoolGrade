package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Interface for strategies for calculating an aggregate grade based on several constituent grades.
 * 
 * @author lewisb
 *
 */
public interface GradeCalculationStrategy {
	/**
	 * Calculate the aggregate score given a list of {@link Grade} objects
	 * 
	 * @param grades the grades to which the calculation applies. Must not be null
	 * @return the aggregate score
	 */
	double calculate(List<Grade> grades);
}
