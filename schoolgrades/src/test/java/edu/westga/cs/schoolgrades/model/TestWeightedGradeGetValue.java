package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

/**
 * This is TestWeightedGradeGetValue class
 * 
 * @author Keith Oguntuwase
 * @version 1.0 Mock
 *
 */
public class TestWeightedGradeGetValue {

	private static final double DELTA = 0.001;
	private WeightedGrade weightedGrade;
	private SimpleGrade mockGrade;

	/**
	 * This is setup method
	 */
	@Before
	public void setup() {
		mockGrade = mock(SimpleGrade.class);

	}

	/**
	 * This is shouldApplyZeroWeight method
	 */
	@Test
	public void shouldApplyZeroWeight() {
		weightedGrade = new WeightedGrade(mockGrade, 0);
		assertEquals(0, weightedGrade.getValue(), DELTA);
	}

	/**
	 * This is shouldApplyWeightOfOne method
	 */
	@Test
	public void shouldApplyWeightOfOne() {
		when(mockGrade.getValue()).thenReturn(100.00);
		weightedGrade = new WeightedGrade(mockGrade, 1);
		assertEquals(100, weightedGrade.getValue(), DELTA);
	}

	/**
	 * This is shouldApplyWeightBetweenZeroAndOne method
	 */
	@Test
	public void shouldApplyWeightBetweenZeroAndOne() {
		when(mockGrade.getValue()).thenReturn(100.00);
		weightedGrade = new WeightedGrade(mockGrade, 0.5);
		assertEquals(50, weightedGrade.getValue(), DELTA);
	}

}
