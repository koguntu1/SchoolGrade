package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the Test Composite Grade Add class
 * 
 * @author Keith Oguntuwase
 * @version 1.0 Mock
 *
 */
public class TestCompositeGradeAdd {

	private CompositeGrade composite;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	/**
	 * This is setup method
	 */
	@Before
	public void setup() {
		composite = new CompositeGrade(mock(SumOfGradesStrategy.class));
		grade0 = mock(SimpleGrade.class);
		grade1 = mock(SimpleGrade.class);
		grade2 = mock(SimpleGrade.class);
	}

	/**
	 * This is can Add One Grade method
	 */
	@Test
	public void canAddOneGrade() {
		composite.add(grade0);
		List<Grade> grades = composite.getGrades();
		assertEquals(1, grades.size());
		assertEquals(grade0, grades.get(0));
	}

	/**
	 * This is can Add Many Grades method
	 */
	@Test
	public void canAddManyGrades() {
		composite.add(grade0);
		composite.add(grade1);
		composite.add(grade2);
		List<Grade> grades = composite.getGrades();
		assertEquals(3, grades.size());
		assertEquals(grade0, grades.get(0));
		assertEquals(grade1, grades.get(1));
		assertEquals(grade2, grades.get(2));
	}

	/**
	 * This is should Not Add Same Grade Twice method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAddSameGradeTwice() {
		composite.add(grade0);
		composite.add(grade0);
	}

	/**
	 * This is should Not Add Null Grade method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAddNullGrade() {
		composite.add(null);
	}
}
