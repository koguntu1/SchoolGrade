package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the DropLowestStrategy test class
 *
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class TestDropLowestStrategy {

	private DropLowestStrategy strategy;
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

		strategy = new DropLowestStrategy(new SumOfGradesStrategy());
	}

	/**
	 * This test for null strategy at constructor
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNullStrategyAtConstructor() {
		strategy = new DropLowestStrategy(null);
	}

	/**
	 * This test for null grade
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNullListGrade() {
		strategy.calculate(null);
	}

	/**
	 * This test for sum of grade
	 */
	@Test
	public void testWithSumGrade() {
		assertEquals(new Double("8"), new Double(strategy.calculate(listGrade)));
	}

}