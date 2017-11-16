package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the Test Average Of Grades Strategy Calculate class
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 * 
 */
public class TestAverageOfGradesStrategyCalculate {

	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	private List<Grade> grades;
	private AverageOfGradesStrategy strategy;

	/**
	 * The before method
	 */
	@Before
	public void setup() {
		grade0 = mock(SimpleGrade.class);
		grade1 = mock(SimpleGrade.class);
		grade2 = mock(SimpleGrade.class);

		grades = new ArrayList<Grade>();

		strategy = new AverageOfGradesStrategy();
	}

	/**
	 * This is should Not Allow Null Grades List method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNullGradesList() {
		strategy.calculate(null);
	}

	/**
	 * This is should Give Zero If No Grades method
	 */
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, strategy.calculate(grades), DELTA);
	}

	/**
	 * This is should Calculate Average Of One Grades method
	 */
	@Test
	public void shouldCalculateAverageOfOneGrades() {
		when(grade0.getValue()).thenReturn(0.001);
		grades.add(grade0);
		assertEquals(grade0.getValue(), strategy.calculate(grades), DELTA);
	}

	/**
	 * This is should Calculate Sum Of Many Grades method
	 */
	@Test
	public void shouldCalculateSumOManyGrades() {
		when(grade0.getValue()).thenReturn(10.00);
		when(grade1.getValue()).thenReturn(20.00);
		when(grade2.getValue()).thenReturn(30.00);

		grades.add(grade0);
		grades.add(grade1);
		grades.add(grade2);
		assertEquals(20, strategy.calculate(grades), DELTA);
	}
}
