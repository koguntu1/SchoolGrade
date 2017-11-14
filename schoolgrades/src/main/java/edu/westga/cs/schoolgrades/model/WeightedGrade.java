package edu.westga.cs.schoolgrades.model;

/**
 * Decorator for {@link Grade} objects that applies a multiplicative weight.
 * 
 * @author lewisb
 *
 */
public class WeightedGrade implements Grade {

	private final Grade grade;
	private final double weight;
	
	/**
	 * Creates a WeightedGrade that decorates the given {@link Grade} by applying the given weight to it.
	 * 
	 * @param decoratedGrade the {@link Grade} to decorate. Must not be null
	 * @param weight the weight to apply to decoratedGrade. Must be between 0.0 and 1.0
	 */
	public WeightedGrade(final Grade decoratedGrade, double weight) {
		if (decoratedGrade == null) {
			throw new IllegalArgumentException("grade should not be null");
		}
		
		if (weight < 0 || weight > 1) {
			throw new IllegalArgumentException("weight must be between 0.0 and 1.0");
		}
		
		this.grade = decoratedGrade;
		this.weight = weight;
	}
	
	@Override
	public double getValue() {
		return this.grade.getValue() * this.weight;
	}

}
