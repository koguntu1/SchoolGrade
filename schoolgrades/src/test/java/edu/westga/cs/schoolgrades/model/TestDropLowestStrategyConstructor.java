package edu.westga.cs.schoolgrades.model;

import org.junit.Before;
import org.junit.Test;

/**
 * This is TestDropLowestStrategyConstructor class
 * 
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public class TestDropLowestStrategyConstructor {

	/**
	 * This is setUp method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * This is shouldNotAllowNullChildStrategy method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNullChildStrategy() {
		new DropLowestStrategy(null);
	}

}
