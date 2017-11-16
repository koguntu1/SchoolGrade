package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This is TestSimpleGradeConstructor class
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class TestSimpleGradeConstructor {

	private static final double DELTA = 0.001;

	/**
	 * This is shouldNotAllowNegativeGrades method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNegativeGrades() {
		new SimpleGrade(-1);
	}

	/**
	 * This is shouldAllowZeroValue method
	 */
	@Test
	public void shouldAllowZeroValue() {
		SimpleGrade grade = new SimpleGrade(0);
		assertEquals(0, grade.getValue(), DELTA);
	}

	/**
	 * This is shouldAllowPositiveValue method
	 */
	@Test
	public void shouldAllowPositiveValue() {
		SimpleGrade grade = new SimpleGrade(50.0);
		assertEquals(50.0, grade.getValue(), DELTA);
	}

}
