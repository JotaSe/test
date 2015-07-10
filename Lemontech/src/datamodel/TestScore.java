/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datamodel;

/**
 *
 * @author JotaSe
 */
public class TestScore {
    private Test test;
    private double score;

    public TestScore(Test test, double score) {
        this.test = test;
        this.score = score;
    }

    public TestScore() {
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
}
