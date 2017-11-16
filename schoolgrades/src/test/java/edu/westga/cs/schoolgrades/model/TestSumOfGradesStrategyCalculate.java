package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * This is the TestSumOfGradesStrategyCalculate class 
 * @author Keith Oguntuwase
 * @version 1.0 Mock
 *
 */
public class TestSumOfGradesStrategyCalculate {

    private static final double DELTA = 0.001;
    private Grade grade0;
    private Grade grade1;
    private Grade grade2;

    private List<Grade> grades;

    private SumOfGradesStrategy strategy;

    /**
     * This is setup method 
     */
    @Before
    public void setup() {
        grade0 = mock(SimpleGrade.class);
        grade1 = mock(SimpleGrade.class);
        grade2 = mock(SimpleGrade.class);

        grades = new ArrayList<Grade>();

        strategy = new SumOfGradesStrategy();
    }

    /**
     * This is shouldNotAllowNullGradesList method 
     */
    @Test(expected = IllegalArgumentException.class)
    public  void shouldNotAllowNullGradesList() {
        strategy.calculate(null);
    }

    /**
     * This is shouldGiveZeroIfNoGrades method 
     */
    @Test
    public void shouldGiveZeroIfNoGrades() {
        assertEquals(0, strategy.calculate(grades), DELTA);
    }

    /**
     * This is shouldCalculateSumOfOneGrades method 
     */
    @Test
    public void shouldCalculateSumOfOneGrades() {
        grades.add(grade0);
        when(grade0.getValue()).thenReturn(0.001);        
        assertEquals(grade0.getValue(), strategy.calculate(grades), DELTA);
    }

    /**
     * This is shouldCalculateSumOManyGrades method 
     */
    @Test
    public void shouldCalculateSumOManyGrades() {
        when(grade0.getValue()).thenReturn(10.00);
        when(grade1.getValue()).thenReturn(20.00);
        when(grade2.getValue()).thenReturn(30.00);        
        
        grades.add(grade0);
        grades.add(grade1);
        grades.add(grade2);
        assertEquals(60, strategy.calculate(grades), DELTA);
    }
}
