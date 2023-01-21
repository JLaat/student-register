package com.example.myapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Student dao.
 */
public class StudentDAO {

    /**
     * Insert student.
     *
     * @param student_id   the student id
     * @param f_name       the f name
     * @param l_name       the l name
     * @param address      the address
     * @param district     the district
     * @param post_code    the post code
     * @param email        the email
     * @param phone_number the phone number
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void insertStudent(Integer student_id, String f_name, String l_name, String address,
                                     String district, String post_code, String email, String phone_number) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO student VALUES(" +student_id + ", '" + f_name + "', '" + l_name + "', '"
                + address + "', '" + district + "', '" + post_code + "', '" + email + "', '" + phone_number + "');";
        dbStuff.dbExecuteQuery(sql);
    }

    /**
     * Delete student by id.
     *
     * @param id the id
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void deleteStudentById(int id) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM student WHERE student_id = " + id + ";";
        try {
            dbStuff.dbExecuteQuery(sql);
        } catch (SQLException e){
            System.out.println("Student deleting failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets student by id.
     *
     * @param id the id
     * @return the student by id
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static ObservableList<Student> getStudentById(int id) throws SQLException, ClassNotFoundException{
        try {
            String sql = "SELECT * FROM student WHERE student_id ="+id+";";
            ResultSet rs = dbStuff.dbExecute(sql);
            ObservableList<Student> studentList = getStudentObjects(rs);
            return studentList;
        } catch (SQLException e){
            System.out.println("Fetching data from database failed" + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets all students.
     *
     * @return the all students
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static ObservableList<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM student;";
        try {
            ResultSet rs = dbStuff.dbExecute(sql);
            ObservableList<Student> studentList = getStudentObjects(rs);
            return studentList;
        } catch (SQLException e){
            System.out.println("Fetching data from database failed" + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets student objects.
     *
     * @param resultSet the result set
     * @return the student objects
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Student> getStudentObjects(ResultSet resultSet) throws ClassNotFoundException, SQLException{
        try {
            ObservableList<Student> studentList = FXCollections.observableArrayList();

            while (resultSet.next()){
                Student student = new Student();
                student.setIdProperty(resultSet.getInt("student_id"));
                student.setfNameProperty(resultSet.getString("firstname"));
                student.setlNameProperty(resultSet.getString("lastname"));
                student.setAddressProperty(resultSet.getString("address"));
                student.setDistrictProperty(resultSet.getString("district"));
                student.setZipProperty(resultSet.getString("post_code"));
                student.setEmailProperty(resultSet.getString("email"));
                student.setPhoneProperty(resultSet.getString("phonenumber"));
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e){
            System.out.println("Fetching data from database failed " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
