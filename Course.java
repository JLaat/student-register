package com.example.myapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The type Course.
 */
public class Course {
    /**
     * The Course id 2.
     */
    IntegerProperty courseId2;
    /**
     * The Course name.
     */
    StringProperty courseName;
    /**
     * The Credit.
     */
    IntegerProperty credit;
    /**
     * The Description.
     */
    StringProperty description;

    /**
     * Instantiates a new Course.
     */
    public Course(){
        this.courseId2 = new SimpleIntegerProperty();
        this.courseName = new SimpleStringProperty();
        this.credit = new SimpleIntegerProperty();
        this.description = new SimpleStringProperty();
    }

    /**
     * Sets course id 2.
     *
     * @param courseId the course id
     */
    public void setCourseId2(int courseId) {
        this.courseId2.set(courseId);
    }

    /**
     * Sets course name.
     *
     * @param courseName the course name
     */
    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    /**
     * Sets credit.
     *
     * @param credit the credit
     */
    public void setCredit(int credit) {
        this.credit.set(credit);
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description.set(description);
    }
}
