package com.example.myapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Course dao.
 */
public class CourseDAO {

    /**
     * Insert course.
     *
     * @param course_id   the course id
     * @param course_name the course name
     * @param grade       the grade
     * @param description the description
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void insertCourse(Integer course_id, String course_name, Integer grade, String description) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO course VALUES("+course_id+",'"+course_name+"'," +grade+",'"+description+"');";
        dbStuff.dbExecuteQuery(sql);
    }

    /**
     * Delete course by id.
     *
     * @param id the id
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void deleteCourseById(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM course WHERE course_id = "+id+";";
        dbStuff.dbExecuteQuery(sql);
    }

    /**
     * Gets course by id.
     *
     * @param id the id
     * @return the course by id
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static ObservableList<Course> getCourseById(int id) throws SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM course WHERE course_id = "+id+";";
            ResultSet rs = dbStuff.dbExecute(sql);
            ObservableList<Course> courseList = getCourseObjects(rs);
            return courseList;
        } catch (SQLException e){
            System.out.println("Fetching data from database failed "+e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets all courses.
     *
     * @return the all courses
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static ObservableList<Course> getAllCourses() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM course;";
        try {
            ResultSet rs = dbStuff.dbExecute(sql);
            ObservableList<Course> courseList = getCourseObjects(rs);
            return courseList;
        } catch (SQLException e){
            System.out.println("Fetching data from database failed "+e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets course objects.
     *
     * @param resultSet the result set
     * @return the course objects
     * @throws SQLException the sql exception
     */
    public static ObservableList<Course> getCourseObjects(ResultSet resultSet) throws SQLException {
        try {
            ObservableList<Course> courseList = FXCollections.observableArrayList();

            while (resultSet.next()){
                Course course = new Course();
                course.setCourseId2(resultSet.getInt("course_id"));
                course.setCourseName(resultSet.getString("name"));
                course.setCredit(resultSet.getInt("credit"));
                course.setDescription(resultSet.getString("description"));
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException e) {
            System.out.println("Fetching data from database failed "+e);
            e.printStackTrace();
            throw e;
        }
    }
}
