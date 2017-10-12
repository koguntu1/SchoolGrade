/**
 *
 */
package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the Test Simple Grade class
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */

public class TestSimpleGrade {
	private SimpleGrade grade;

	/**
	 * Setup before the test
	 */
	@Before
	public void setUp() {
		grade = new SimpleGrade(1.1D);
	}

	/**
	 * Test for the set grade
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetGrade() {
		grade.setValue(-1.1);
	}

	/**
	 * Test for get grade
	 */
	@Test
	public void testGetValue() {
		assertEquals(new Double("1.1"), new Double(grade.getValue()));
	}

}
