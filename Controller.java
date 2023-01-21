package com.example.myapp;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * The type Controller.
 */
public class Controller implements Initializable {
    /**
     * The Darkmode.
     */
    public boolean darkmode = true;

    @FXML
    private TableView<Accomplishment> accomplishmentTable;

    @FXML
    private Button btnAddAccomplishment;

    @FXML
    private Button btnAddCourse;

    @FXML
    private Button btnDeleteAccomplishment;

    @FXML
    private Button btnDeleteCourse;

    @FXML
    private Button btnDeleteStudent;

    @FXML
    private Button btnSearchAccomplishment;

    @FXML
    private Button btnSearchAccomplishment2;

    @FXML
    private Button btnSearchAccomplishments;

    @FXML
    private Button btnSearchCourse;

    @FXML
    private Button btnSearchCourses;

    @FXML
    private Button btnSearchStudent;

    @FXML
    private Button btnSearchStudents;

    @FXML
    private Button btnUpdateAccomplishment;

    @FXML
    private Button btnUpdateCourse;

    @FXML
    private Button btnUpdateStudent;

    @FXML
    private TableColumn<Student, String> colAddress;

    @FXML
    private TableColumn<Course, Integer> colCourseCredit;

    @FXML
    private TableColumn<Course, String> colCourseDescription;

    @FXML
    private TableColumn<Course, Integer> colCourseId;

    @FXML
    private TableColumn<Accomplishment, Integer> colCourseId2;

    @FXML
    private TableColumn<Course, String> colCourseName;

    @FXML
    private TableColumn<Accomplishment, Date> colDate;

    @FXML
    private TableColumn<Student, String> colDistrict;

    @FXML
    private TableColumn<Student, String> colEmail;

    @FXML
    private TableColumn<Student, String> colFName;

    @FXML
    private TableColumn<Accomplishment, Integer> colGrade;

    @FXML
    private TableColumn<Student, String> colLName;

    @FXML
    private TableColumn<Student, String> colPhone;

    @FXML
    private TableColumn<Student, Integer> colStudentId;

    @FXML
    private TableColumn<Accomplishment, Integer> colStudentId2;

    @FXML
    private TableColumn<Student, String> colZip;

    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TextArea resultConsole;

    @FXML
    private TextArea resultConsole2;

    @FXML
    private TextArea resultConsole3;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TabPane tabPaneeli;

    @FXML
    private TextField txtCourseId;

    @FXML
    private TextField txtCourseId2;

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCredit;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtSearchAccomplishments2;

    @FXML
    private TextField txtSearchCourse;

    @FXML
    private TextField txtSearchStudent;

    @FXML
    private TextField txtSearchStudent2;

    @FXML
    private TextField txtStudentAddress;

    @FXML
    private TextField txtStudentDistrict;

    @FXML
    private TextField txtStudentEmail;

    @FXML
    private TextField txtStudentFName;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentId2;

    @FXML
    private TextField txtStudentLName;

    @FXML
    private TextField txtStudentPhone;

    @FXML
    private TextField txtStudentZip;

    /**
     * Insert student.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    void insertStudent(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            StudentDAO.insertStudent(Integer.valueOf(txtStudentId.getText()), txtStudentFName.getText(), txtStudentLName.getText(),
                    txtStudentAddress.getText(), txtStudentDistrict.getText(), txtStudentZip.getText(),
                    txtStudentEmail.getText(), txtStudentPhone.getText());
            resultConsole.setText("Student added succesfully");
            ObservableList<Student> studentlist = StudentDAO.getAllStudents();
            populateStudentTable(studentlist);
        } catch (SQLException e){
            resultConsole.setText("Student creation failed. Check if Student-ID already exists.");
            throw e;
        }
    }

    /**
     * Insert accomplishment.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void insertAccomplishment(MouseEvent event) throws SQLException, ClassNotFoundException {
        try {
            AccomplishmentDAO.insertAccomplishment(Integer.valueOf(txtStudentId2.getText()), Integer.valueOf(txtCourseId2.getText()), Integer.valueOf(txtGrade.getText()), LocalDate.parse(txtDate.getText()));
            ObservableList<Accomplishment> accomplishments = AccomplishmentDAO.getAllAccomplishments();
            populateAccomplishmentTable(accomplishments);
            resultConsole2.setText("Accomplishment added succesfully");
        } catch (SQLException e){
            resultConsole2.setText("Accomplishment creation failed. Check if student-id or course-id exists.");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Insert course.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void insertCourse(MouseEvent event) throws SQLException, ClassNotFoundException {
        try {
            CourseDAO.insertCourse(Integer.valueOf(txtCourseId.getText()), txtCourseName.getText(), Integer.valueOf(txtCredit.getText()), txtDescription.getText());
            ObservableList<Course> courses = CourseDAO.getAllCourses();
            populateCourseTable(courses);
            resultConsole3.setText("Course added succesfully");
        } catch (SQLException e){
            resultConsole3.setText("Course creation failed. Does id already exist?");
        }
    }

    /**
     * Delete student.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    void deleteStudent(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            StudentDAO.deleteStudentById(Integer.parseInt(txtSearchStudent.getText()));
            resultConsole.setText("Student has been deleted");
            ObservableList<Student> studentlist = StudentDAO.getAllStudents();
            populateStudentTable(studentlist);
        } catch (SQLException e){
            resultConsole.setText("Student deleting failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Delete accomplishment.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void deleteAccomplishment(MouseEvent event) throws SQLException, ClassNotFoundException {
        try {
            AccomplishmentDAO.deleteAccomplishmentById(Integer.parseInt(txtSearchStudent2.getText()));
            resultConsole2.setText("Accomplishment has been deleted");
            ObservableList<Accomplishment> accomplishments = AccomplishmentDAO.getAllAccomplishments();
            populateAccomplishmentTable(accomplishments);
        } catch (SQLException e){
            resultConsole2.setText("Accomplishment deletion failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Delete course.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void deleteCourse(MouseEvent event) throws SQLException, ClassNotFoundException {
        try {
            CourseDAO.deleteCourseById(Integer.parseInt(txtSearchCourse.getText()));
            resultConsole3.setText("Course has been deleted");
            ObservableList<Course> courses = CourseDAO.getAllCourses();
            populateCourseTable(courses);
        } catch (SQLException e){
            resultConsole3.setText("Course deletion failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Search students.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    void searchStudents(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            int id = Integer.parseInt(txtSearchStudent.getText());
            ObservableList<Student> studentList = StudentDAO.getStudentById(id);
            resultConsole.setText("Students searched succesfully");
            populateStudentTable(studentList);
        } catch (SQLException e){
            resultConsole.setText("Student searching failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Search accomplishments by student id.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void searchAccomplishmentsByStudentId(MouseEvent event) throws SQLException, ClassNotFoundException {
        try {
            int id = Integer.parseInt(txtSearchStudent2.getText());
            ObservableList<Accomplishment> accomplishments = AccomplishmentDAO.getAccomplishmentByStudentId(id);
            resultConsole2.setText("Accomplishments searched succesfully");
            populateAccomplishmentTable(accomplishments);
        } catch (SQLException e){
            resultConsole2.setText("Accomplishment searching failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Search accomplishments by course id.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    void searchAccomplishmentsByCourseId(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            int id = Integer.parseInt(txtSearchAccomplishments2.getText());
            ObservableList<Accomplishment> accomplishments = AccomplishmentDAO.getAccomplishmentByCourseId(id);
            resultConsole2.setText("Accomplishments searched succesfully");
            populateAccomplishmentTable(accomplishments);
        } catch (SQLException e){
            resultConsole2.setText("Accomplishment searching failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Search courses.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    void searchCourses(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            int id = Integer.parseInt(txtSearchCourse.getText());
            ObservableList<Course> courses = CourseDAO.getCourseById(id);
            resultConsole3.setText("Courses searched succesfully");
            populateCourseTable(courses);
        } catch (SQLException e){
            resultConsole3.setText("Course searching failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Update student.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    void updateStudent(MouseEvent event) throws ClassNotFoundException, SQLException{
        try {
            String value1 = txtStudentId.getText();
            String value2 = txtStudentFName.getText();
            String value3 = txtStudentLName.getText();
            String value4 = txtStudentAddress.getText();
            String value5 = txtStudentDistrict.getText();
            String value6 = txtStudentZip.getText();
            String value7 = txtStudentEmail.getText();
            String value8 = txtStudentPhone.getText();

            String sql = "UPDATE student SET student_id = "+value1+", firstname = '"+value2+"', lastname = '"+value3+"', address = '"+
                    value4+"', district = '"+value5+"', post_code = '"+value6+"', email = '"+value7+"', phonenumber = '"+value8+"' WHERE student_id = "+value1+";";

            dbStuff.dbExecuteQuery(sql);
            resultConsole.setText("Student updated succesfully");
            ObservableList<Student> studentlist = StudentDAO.getAllStudents();
            populateStudentTable(studentlist);
        }
        catch (Exception e){
            resultConsole.setText("Student updating failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Update accomplishment.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void updateAccomplishment(MouseEvent event) throws SQLException, ClassNotFoundException {
        try {
            String value1 = txtStudentId2.getText();
            String value2 = txtCourseId2.getText();
            String value3 = txtGrade.getText();
            String value4 = txtDate.getText();

            String sql = "UPDATE accomplishment SET student_id ="+value1+", course_id ="+value2+", grade ="+value3+", accomplishment_date ='"+value4+"' WHERE student_id = "+value1+";";

            dbStuff.dbExecuteQuery(sql);
            resultConsole2.setText("Accomplishment updated succesfully");
            ObservableList<Accomplishment> accomplishments = AccomplishmentDAO.getAllAccomplishments();
            populateAccomplishmentTable(accomplishments);
        } catch (SQLException e){
            resultConsole2.setText("Accomplishment updating failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Update course.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    void updateCourse(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            String value1 = txtCourseId.getText();
            String value2 = txtCourseName.getText();
            String value3 = txtCredit.getText();
            String value4 = txtDescription.getText();
            String sql = "UPDATE course SET course_id ="+value1+", name ='"+value2+"', credit ="+value3+", description ='"+value4+"' WHERE course_id = "+value1+";";

            dbStuff.dbExecuteQuery(sql);
            resultConsole3.setText("Course updated succesfully");
            ObservableList<Course> courses = CourseDAO.getAllCourses();
            populateCourseTable(courses);
        } catch (SQLException e){
            resultConsole3.setText("Course updating failed");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Show students.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void showStudents(MouseEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Student> studentlist = StudentDAO.getAllStudents();
        populateStudentTable(studentlist);
        resultConsole.setText("Displaying all students");
    }

    /**
     * Show accomplishments.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void showAccomplishments(MouseEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Accomplishment> accomplishments = AccomplishmentDAO.getAllAccomplishments();
        populateAccomplishmentTable(accomplishments);
        resultConsole2.setText("Displaying all accomplishments");
    }

    /**
     * Show courses.
     *
     * @param event the event
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    @FXML
    void showCourses(MouseEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Course> courses = CourseDAO.getAllCourses();
        populateCourseTable(courses);
        resultConsole3.setText("Displaying all courses");
    }

    /**
     * Gets student selected.
     *
     * @param event the event
     */
    @FXML
    void getStudentSelected(MouseEvent event) {
        int index = studentTable.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtStudentId.setText(colStudentId.getCellData(index).toString());
        txtStudentFName.setText(colFName.getCellData(index));
        txtStudentLName.setText(colLName.getCellData(index));
        txtStudentAddress.setText(colAddress.getCellData(index));
        txtStudentDistrict.setText(colDistrict.getCellData(index));
        txtStudentZip.setText(colZip.getCellData(index));
        txtStudentEmail.setText(colEmail.getCellData(index));
        txtStudentPhone.setText(colPhone.getCellData(index));
        txtSearchStudent.setText(colStudentId.getCellData(index).toString());

    }

    /**
     * Get accomplishment selected.
     *
     * @param event the event
     */
    @FXML
    void getAccomplishmentSelected(MouseEvent event){
        int index = accomplishmentTable.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtStudentId2.setText(colStudentId2.getCellData(index).toString());
        txtCourseId2.setText(colCourseId2.getCellData(index).toString());
        txtGrade.setText(colGrade.getCellData(index).toString());
        txtDate.setText(String.valueOf(colDate.getCellData(index)));
    }

    /**
     * Get course selected.
     *
     * @param event the event
     */
    @FXML
    void getCourseSelected(MouseEvent event){
        int index = courseTable.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtCourseId.setText(colCourseId.getCellData(index).toString());
        txtCourseName.setText(colCourseName.getCellData(index));
        txtCredit.setText(colCourseCredit.getCellData(index).toString());
        txtDescription.setText(colCourseDescription.getCellData(index));
        txtSearchCourse.setText(colCourseId.getCellData(index).toString());
    }

    private void populateStudentTable(ObservableList<Student> studentList){
        studentTable.setItems(studentList);
    }
    private void populateAccomplishmentTable(ObservableList<Accomplishment> accomplishmentList){
        accomplishmentTable.setItems(accomplishmentList);
    }
    private void populateCourseTable(ObservableList<Course> courseList){
        courseTable.setItems(courseList);
    }

    /**
     * Toggle dark mode.
     *
     * @param event the event
     */
    @FXML
    public void toggleDarkMode(MouseEvent event){
        if(darkmode){
            tabPaneeli.getScene().getRoot().getStylesheets().add(getClass().getResource("style.css").toString());
            darkmode = false;
        }
        else {
            tabPaneeli.getScene().getRoot().getStylesheets().remove(getClass().getResource("style.css").toString());
            darkmode = true;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            dbStuff.dbCreatedB();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        colStudentId.setCellValueFactory(cellData -> cellData.getValue().idProperty.asObject());
        colFName.setCellValueFactory(cellData -> cellData.getValue().fNameProperty);
        colLName.setCellValueFactory(cellData -> cellData.getValue().lNameProperty);
        colAddress.setCellValueFactory(cellData -> cellData.getValue().addressProperty);
        colDistrict.setCellValueFactory(cellData -> cellData.getValue().districtProperty);
        colZip.setCellValueFactory(cellData -> cellData.getValue().zipProperty);
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty);
        colPhone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty);

        colStudentId2.setCellValueFactory(cellData -> cellData.getValue().studentId.asObject());
        colCourseId2.setCellValueFactory(cellData -> cellData.getValue().courseId.asObject());
        colGrade.setCellValueFactory(cellData -> cellData.getValue().grade.asObject());
        colDate.setCellValueFactory(cellData -> cellData.getValue().time);


        colCourseId.setCellValueFactory(cellData -> cellData.getValue().courseId2.asObject());
        colCourseName.setCellValueFactory(cellData -> cellData.getValue().courseName);
        colCourseCredit.setCellValueFactory(cellData -> cellData.getValue().credit.asObject());
        colCourseDescription.setCellValueFactory(cellData -> cellData.getValue().description);

    }
}