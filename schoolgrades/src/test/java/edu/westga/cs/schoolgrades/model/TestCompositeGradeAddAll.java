package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This is Test Composite Grade Add All method
 * 
 * @author Keith Oguntuwase
 * @version 1.0 Mock
 *
 */
public class TestCompositeGradeAddAll {

	private CompositeGrade composite;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	private List<Grade> list;

	/**
	 * This is setup method
	 */
	@Before
	public void setup() {
		composite = new CompositeGrade(mock(SumOfGradesStrategy.class));
		grade0 = mock(SimpleGrade.class);
		grade1 = mock(SimpleGrade.class);
		grade2 = mock(SimpleGrade.class);
		list = new ArrayList<Grade>();
	}

	/**
	 * This is shouldNotAddNullGradesList method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAddNullGradesList() {
		composite.addAll(null);
	}

	/**
	 * This is shouldAddEmptyList method
	 */
	@Test
	public void shouldAddEmptyList() {
		composite.addAll(new ArrayList<Grade>());
		assertTrue(composite.getGrades().isEmpty());
	}

	/**
	 * This is shouldAddOneElementList method
	 */
	@Test
	public void shouldAddOneElementList() {
		list.add(grade0);
		composite.addAll(list);
		List<Grade> actual = composite.getGrades();
		assertEquals(1, actual.size());
		assertEquals(grade0, actual.get(0));
	}

	/**
	 * This is shouldAddManyElementsList method
	 */
	@Test
	public void shouldAddManyElementsList() {
		list.add(grade0);
		list.add(grade1);
		list.add(grade2);
		composite.addAll(list);
		List<Grade> actual = composite.getGrades();
		assertEquals(3, actual.size());
		assertEquals(grade0, actual.get(0));
		assertEquals(grade1, actual.get(1));
		assertEquals(grade2, actual.get(2));
	}

	/**
	 * This is shouldNotAddListWithDuplicates method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAddListWithDuplicates() {
		list.add(grade0);
		list.add(grade1);
		list.add(grade0);
		list.add(grade2);
		composite.addAll(list);
	}
}
