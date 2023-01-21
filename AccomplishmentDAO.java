package com.example.myapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * The type Accomplishment dao.
 */
public class AccomplishmentDAO {
    /**
     * Insert accomplishment.
     *
     * @param student_id the student id
     * @param course_id  the course id
     * @param grade      the grade
     * @param date       the date
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void insertAccomplishment(Integer student_id, Integer course_id, Integer grade, LocalDate date) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO accomplishment VALUES("+student_id+","+course_id+","+grade+",'"+date+"');";
        dbStuff.dbExecuteQuery(sql);
    }

    /**
     * Delete accomplishment by id.
     *
     * @param id the id
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void deleteAccomplishmentById(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM accomplishment WHERE student_id ="+id+";";
        dbStuff.dbExecuteQuery(sql);
    }

    /**
     * Gets accomplishment by student id.
     *
     * @param id the id
     * @return the accomplishment by student id
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static ObservableList<Accomplishment> getAccomplishmentByStudentId(int id) throws SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM accomplishment WHERE student_id ="+id+";";
            ResultSet rs = dbStuff.dbExecute(sql);
            return getAccomplishmentObjects(rs);
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Fetching data from database failed "+e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets accomplishment by course id.
     *
     * @param id the id
     * @return the accomplishment by course id
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static ObservableList<Accomplishment> getAccomplishmentByCourseId(int id) throws SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT * FROM accomplishment WHERE course_id ="+id+";";
            ResultSet rs = dbStuff.dbExecute(sql);
            return getAccomplishmentObjects(rs);
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Fetching data from database failed "+e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets all accomplishments.
     *
     * @return the all accomplishments
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static ObservableList<Accomplishment> getAllAccomplishments() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM accomplishment;";
        try {
            ResultSet rs = dbStuff.dbExecute(sql);
            return getAccomplishmentObjects(rs);
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Fetching data from database failed"+e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * To local date local date.
     *
     * @param date the date
     * @return the local date
     */
    public static LocalDate toLocalDate(String date){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, dateFormatter);
    }


    /**
     * Gets accomplishment objects.
     *
     * @param resultSet the result set
     * @return the accomplishment objects
     * @throws SQLException the sql exception
     */
    public static ObservableList<Accomplishment> getAccomplishmentObjects(ResultSet resultSet) throws SQLException {
        try {
            ObservableList<Accomplishment> accomplishmentList = FXCollections.observableArrayList();

            while (resultSet.next()){
                Accomplishment accomplishment = new Accomplishment();
                accomplishment.setCourseId(resultSet.getInt("course_id"));
                accomplishment.setGrade(resultSet.getInt("grade"));
                accomplishment.setStudentId(resultSet.getInt("student_id"));
                accomplishment.setTime((Date) resultSet.getObject("accomplishment_date"));
                accomplishmentList.add(accomplishment);
            }
        return accomplishmentList;
        } catch (SQLException e){
            System.out.println("Fetching data from database failed "+e);
            e.printStackTrace();
            throw e;
        }
    }
}
