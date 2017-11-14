package edu.westga.cs.schoolgrades.model;

/**
 * A {@link Grade} with a constant value.
 * 
 * @author lewisb
 *
 */
public class SimpleGrade implements Grade {
	private double value;

	/**
	 * Creates a SimpleGrade with the given value.
	 * 
	 * @param value the assigned numerical grade. Must be >= 0
	 */
	public SimpleGrade(double value) {
		setValue(value);
	}
	
	@Override
	public double getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 * 
	 * @param value
	 */
	public void setValue(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("value should not be < 0");
		}
		
		this.value = value;
	}
	
	
}
