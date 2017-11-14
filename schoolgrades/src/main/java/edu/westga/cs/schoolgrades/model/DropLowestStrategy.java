package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Decorator for {@link GradeCalculationStrategy}s that drops the lowest grade before applying the rest of the strategy.
 * 
 * @author lewisb
 *
 */
public class DropLowestStrategy implements GradeCalculationStrategy {

	private GradeCalculationStrategy childStrategy;
	
	/**
	 * Decorates the childStrategy by dropping its lowest grade.
	 * 
	 * @param childStrategy the strategy from which to drop the lowest grade.
	 */
	public DropLowestStrategy(GradeCalculationStrategy childStrategy) {
		if (childStrategy == null) {
			throw new IllegalArgumentException("childStrategy can not be null");
		}
		
		this.childStrategy = childStrategy;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * 
	 * @param grades {@inheritDoc}.
	 * @return if there are at least 2 grades, returns the calculated grade with the lowest dropped. Otherwise, returns the calculation without the lowest dropped.
	 */
	public double calculate(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades may not be null");
		}
		
		if (grades.size() < 2) {
			return childStrategy.calculate(grades);
		}
		
		List<Grade> withLowestRemoved = dropLowestFrom(grades);
		return childStrategy.calculate(withLowestRemoved);
	} 

	private List<Grade> dropLowestFrom(List<Grade> grades) {
		Grade lowest = grades.get(0);
		for (Grade grade: grades) {
			if (lowest.getValue() > grade.getValue()) {
				lowest = grade;
			}
		}
		List<Grade> result = new ArrayList<Grade>(grades);
		result.remove(lowest);
		return result;
	}
}
