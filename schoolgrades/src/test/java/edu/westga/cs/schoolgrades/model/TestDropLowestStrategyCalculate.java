package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is TestDropLowestStrategyCalculate class
 * 
 * @author Keith Oguntuwase
 * @version 1.0 Mock
 *
 */
public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;

	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	private List<Grade> allGrades;
	private List<Grade> minusGrades;

	/**
	 * This is setup method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		grade0 = mock(SimpleGrade.class);
		grade1 = mock(SimpleGrade.class);
		grade2 = mock(SimpleGrade.class);

		allGrades = new ArrayList<Grade>();
		minusGrades = new ArrayList<Grade>();

		childStrategy = mock(SumOfGradesStrategy.class);
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
	}

	/**
	 * This is shouldNotAllowNullGradesList method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNullGradesList() {
		dropLowestStrategy.calculate(null);
	}

	/**
	 * This is shouldNotDropLowestIfGradesListIsEmpty method
	 */
	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		assertEquals(0, dropLowestStrategy.calculate(allGrades), DELTA);
	}

	/**
	 * This is shouldNotDropLowestIfGradesListHasOneElement method
	 */
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		allGrades.add(grade0);
		assertEquals(grade0.getValue(), dropLowestStrategy.calculate(allGrades), DELTA);
	}

	/**
	 * This is canDropWhenLowestIsFirst method
	 */
	@Test
	public void canDropWhenLowestIsFirst() {
		when(grade0.getValue()).thenReturn(10.00);
		when(grade1.getValue()).thenReturn(20.00);
		when(grade2.getValue()).thenReturn(30.00);

		allGrades.add(grade0);
		allGrades.add(grade1);
		allGrades.add(grade2);
		dropLowestStrategy.calculate(allGrades);
		minusGrades.add(grade1);
		minusGrades.add(grade2);

		verify(childStrategy).calculate(minusGrades);
	}

	/**
	 * This is canDropWhenLowestIsLast method
	 */
	@Test
	public void canDropWhenLowestIsLast() {
		when(grade0.getValue()).thenReturn(30.00);
		when(grade1.getValue()).thenReturn(20.00);
		when(grade2.getValue()).thenReturn(10.00);

		allGrades.add(grade0);
		allGrades.add(grade1);
		allGrades.add(grade2);
		dropLowestStrategy.calculate(allGrades);
		minusGrades.add(grade0);
		minusGrades.add(grade1);

		verify(childStrategy).calculate(minusGrades);
	}

	/**
	 * This is canDropWhenLowestIsInMiddle method
	 */
	@Test
	public void canDropWhenLowestIsInMiddle() {
		when(grade0.getValue()).thenReturn(20.00);
		when(grade1.getValue()).thenReturn(10.00);
		when(grade2.getValue()).thenReturn(30.00);

		allGrades.add(grade0);
		allGrades.add(grade1);
		allGrades.add(grade2);
		dropLowestStrategy.calculate(allGrades);
		minusGrades.add(grade0);
		minusGrades.add(grade2);

		verify(childStrategy).calculate(minusGrades);
	}

	/**
	 * This is dropsOnlyOneIfThereAreMultipleLowestGrades method
	 */
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		when(grade0.getValue()).thenReturn(10.00);
		when(grade1.getValue()).thenReturn(10.00);
		when(grade2.getValue()).thenReturn(30.00);

		allGrades.add(grade0);
		allGrades.add(grade1);
		allGrades.add(grade2);
		dropLowestStrategy.calculate(allGrades);
		minusGrades.add(grade1);
		minusGrades.add(grade2);

		verify(childStrategy).calculate(minusGrades);
	}
}
