package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * This is TestCompositeGradeConstructor class
 * 
 * @author Keith Oguntuwase
 * @version 1.0 Mock
 *
 */
public class TestCompositeGradeConstructor {

	/**
	 * This is shouldNotAllowNullStrategy class
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNullStrategy() {
		new CompositeGrade(null);
	}

	/**
	 * This is shouldHaveNoGradesWhenCreated class
	 */
	@Test
	public void shouldHaveNoGradesWhenCreated() {
		CompositeGrade grade = new CompositeGrade(mock(SumOfGradesStrategy.class));
		assertTrue(grade.getGrades().isEmpty());
	}

}
