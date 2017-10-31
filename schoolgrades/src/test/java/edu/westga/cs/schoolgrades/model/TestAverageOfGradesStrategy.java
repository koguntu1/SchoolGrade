package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the Average of Grades Strategy test class
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class TestAverageOfGradesStrategy {

	private AverageOfGradesStrategy strategy;
	private List<Grade> listGrade;

	/**
	 * Setup before the test
	 */
	@Before
	public void setUp() {
		listGrade = new ArrayList<Grade>();
		listGrade.add(new SimpleGrade(1.0D));
		listGrade.add(new SimpleGrade(2.0D));
		listGrade.add(new SimpleGrade(6.0D));

		strategy = new AverageOfGradesStrategy();
	}

	/**
	 * This test for null grade
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNullListGrade() {
		strategy.calculate(null);
	}

	/**
	 * This test for average of grade
	 */
	@Test
	public void testWithAvgGrade() {
		assertEquals(new Double("3"), new Double(strategy.calculate(listGrade)));
	}
}