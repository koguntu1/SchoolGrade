package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * This is the GradeCalculationStrategy interface
 * @author Keith Oguntuwase
 * @version 1.0
 *
 */
public interface GradeCalculationStrategy {
    
    /**
     * This is calculate method
     * @param paramList   
     * @return double   
     */
    double calculate(List<Grade> paramList);
}
