package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the Weighted Grade test class
 *
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class TestWeightedGrade {

	private WeightedGrade grade;

	/**
	 * Setup before the test
	 */
	@Before
	public void setUp() {
		grade = new WeightedGrade(new SimpleGrade(1.0D), 1.0);
	}

	/**
	 * Test for the null grade
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNullGrade() {
		grade = new WeightedGrade(null, 1.0D);
	}

	/**
	 * Test for the invalid grade less than 1.0
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithInvalidLowerGrade() {
		grade = new WeightedGrade(new SimpleGrade(1.0D), -1.0D);
	}

	/**
	 * Test for the invalid grade more than 1.0
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithInvalidUpperGrade() {
		grade = new WeightedGrade(new SimpleGrade(1.0D), 1.1D);
	}

	/**
	 * Test for the getValue
	 */
	@Test
	public void testWithGetValue() {
		assertEquals(new Double(1.0), new Double(grade.getValue()));
	}
}