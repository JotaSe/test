/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.List;

/**
 *
 * @author JotaSe
 */
public class Student extends BasicIdentification {

    private List<Course> courses;
    private List<TestScore> testScores;

    public Student() {
    }

    public List<TestScore> getTestScores() {
        return testScores;
    }

    public void setTestScores(List<TestScore> testScores) {
        this.testScores = testScores;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
