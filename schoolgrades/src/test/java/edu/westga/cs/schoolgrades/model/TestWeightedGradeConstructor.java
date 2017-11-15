package edu.westga.cs.schoolgrades.model;

import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * This is the TestWeightedGradeConstructor class
 * 
 * @author Keith Oguntuwase
 * @version 1.0 Mock
 *
 *          This is the Test Weighted Grade Constructor class
 *
 */
public class TestWeightedGradeConstructor {

	/**
	 * This is shouldNotAllowNullGrade method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNullGrade() {
		new WeightedGrade(null, 10.0);
	}

	/**
	 * This is shouldNotAllowNegativeWeight method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNegativeWeight() {
		new WeightedGrade(mock(Grade.class), -10.0);
	}

	/**
	 * This is shouldNotAllowWeightGreaterThanOne method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowWeightGreaterThanOne() {
		new WeightedGrade(mock(Grade.class), 10.0);
	}
}
