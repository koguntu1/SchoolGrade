package edu.westga.cs.schoolgrades.model;

/**
 * This is the WeightedGrade class
 *
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class WeightedGrade implements Grade {

	private final Grade grade;
	private final double weight;

	/**
	 *
	 * The constructor
	 *
	 * @param decoratedGrade
	 * @param weight
	 */
	public WeightedGrade(Grade decoratedGrade, double weight) {
		if (decoratedGrade == null) {
			throw new IllegalArgumentException("grade should not be null");
		}
		if ((weight < 0.0D) || (weight > 1.0D)) {
			throw new IllegalArgumentException("weight must be between 0.0 and 1.0");
		}
		this.grade = decoratedGrade;
		this.weight = weight;
	}

	/**
	 * The getValue method
	 *
	 * @return double
	 */
	@Override
	public double getValue() {
		return this.grade.getValue() * this.weight;
	}
}