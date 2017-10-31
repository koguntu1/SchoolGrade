package edu.westga.cs.schoolgrades.model;

/**
 * This is the SimpleGrade class
 * @author Keith Oguntuwase
 * @version 1.0
 */
public class SimpleGrade implements Grade {
    private double value;

    /**
     * The constructor
     * @param value   
     */
    public SimpleGrade(double value) {
        setValue(value);
    }

    /**
     * This is getValue method
     * @return double    
     */
    @Override
	public double getValue() {
        return this.value;
    }

    /**
     * This is setValue method
     * @param value   
     */
    public void setValue(double value) {
        if (value < 0.0D) {
            throw new IllegalArgumentException("value should not be < 0");
        }
        this.value = value;
    }
}
