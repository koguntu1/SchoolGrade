package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the CompositeGrade class
 *
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */

public class CompositeGrade implements Grade {
	private final GradeCalculationStrategy strategy;
	private final List<Grade> childGrades;

	/**
	 * The constructor
	 *
	 * @param strategy
	 */
	public CompositeGrade(GradeCalculationStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("strategy must not be null");
		}
		this.strategy = strategy;
		this.childGrades = new ArrayList<Grade>();
	}

	/**
	 * This is add method
	 *
	 * @param grade
	 */

	public void add(Grade grade) {
		if (grade == null) {
			throw new IllegalArgumentException("grade can not be null");
		}
		if (this.childGrades.contains(grade)) {
			throw new IllegalArgumentException("can not add the same grade twice");
		}
		this.childGrades.add(grade);
	}

	/**
	 * This is getGrade method
	 *
	 * @return List
	 */
	public List<Grade> getGrades() {
		return Collections.unmodifiableList(this.childGrades);
	}

	/**
	 * This is getValue method
	 *
	 * @return double
	 */
	@Override
	public double getValue() {
		return this.strategy.calculate(this.childGrades);
	}

	/**
	 * This is addAll method
	 *
	 * @param grades
	 */
	public void addAll(List<? extends Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades can not be null");
		}
		for (Grade grade : grades) {
			add(grade);
		}

	}

}
