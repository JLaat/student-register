package com.example.myapp;

import javafx.beans.property.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;

/**
 * The type Accomplishment.
 */
public class Accomplishment {
    /**
     * The Student id.
     */
    IntegerProperty studentId;
    /**
     * The Course id.
     */
    IntegerProperty courseId;
    /**
     * The Grade.
     */
    IntegerProperty grade;
    /**
     * The Time.
     */
    ObjectProperty<Date> time = new SimpleObjectProperty<>();

    /**
     * Instantiates a new Accomplishment.
     */
    public Accomplishment(){
        this.courseId = new SimpleIntegerProperty();
        this.grade =  new SimpleIntegerProperty();
        this.studentId = new SimpleIntegerProperty();
        this.time =  new SimpleObjectProperty<>();
    }


    /**
     * Sets course id.
     *
     * @param courseId the course id
     */
    public void setCourseId(int courseId) {
        this.courseId.set(courseId);
    }

    /**
     * Sets grade.
     *
     * @param grade the grade
     */
    public void setGrade(int grade) {
        this.grade.set(grade);
    }

    /**
     * Sets student id.
     *
     * @param studentId the student id
     */
    public void setStudentId(int studentId) {
        this.studentId.set(studentId);
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Date time) {
        this.time.set(time);
    }
}
