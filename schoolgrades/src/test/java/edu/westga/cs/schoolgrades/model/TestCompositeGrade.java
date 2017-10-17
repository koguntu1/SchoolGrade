package edu.westga.cs.schoolgrades.model;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the Composite Grade Test
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class TestCompositeGrade {

	private CompositeGrade grade;

	/**
	 * Setup before the test
	 */
	@Before
	public void setUp() {
		grade = new CompositeGrade(new SumOfGradesStrategy());
	}

	/**
	 * Test for null calculation strategy
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNullStrategy() {
		new CompositeGrade(null);
	}

	/**
	 * Test for null grade
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNullGrade() {
		grade.add(null);
	}

	/**
	 * Test for duplicate grade
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithDupGrade() {
		SimpleGrade sgrade = new SimpleGrade(0.9);
		grade.add(sgrade);
		grade.add(sgrade);
	}

}
