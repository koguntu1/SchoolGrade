package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the DropLowestStrategy class
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class DropLowestStrategy implements GradeCalculationStrategy {
	private GradeCalculationStrategy childStrategy;

	/**
	 * The constructor
	 * 
	 * @param childStrategy
	 */
	public DropLowestStrategy(GradeCalculationStrategy childStrategy) {
		if (childStrategy == null) {
			throw new IllegalArgumentException("childStrategy can not be null");
		}
		this.childStrategy = childStrategy;
	}

	/**
	 * This is the calculate method
	 * 
	 * @param grades
	 * @return double
	 */
	@Override
	public double calculate(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades may not be null");
		}
		if (grades.size() < 2) {
			return this.childStrategy.calculate(grades);
		}
		List<Grade> withLowestRemoved = dropLowestFrom(grades);
		return this.childStrategy.calculate(withLowestRemoved);
	}

	/**
	 * The constructor
	 * 
	 * @param grades
	 * @return List
	 */
	private List<Grade> dropLowestFrom(List<Grade> grades) {
		Grade lowest = grades.get(0);
		for (Grade grade : grades) {
			if (lowest.getValue() > grade.getValue()) {
				lowest = grade;
			}
		}
		ArrayList<Grade> result = new ArrayList<Grade>(grades);
		((List<Grade>) result).remove(lowest);
		return result;
	}
}