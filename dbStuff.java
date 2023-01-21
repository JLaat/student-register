package com.example.myapp;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;


/**
 * The type Db stuff.
 */
public class dbStuff {

    private static Connection connection = null;

    private static final String connectString = "jbdc:mariadb://localhost:3307/university_database";

    /**
     * Db connect.
     *
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void dbConnect() throws SQLException, ClassNotFoundException {
        String dbName = "university_database";
        String dbUser = "root";
        String dbPassword = "1234";
        String url = "";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void dbCreatedB() throws SQLException, ClassNotFoundException {
        dbConnect();
        Statement statement = connection.createStatement();

        statement.addBatch("DROP DATABASE IF EXISTS `university_database`;");
        statement.addBatch("CREATE DATABASE IF NOT EXISTS `university_database`;");
        statement.addBatch("USE `university_database`;");
        statement.addBatch("CREATE TABLE IF NOT EXISTS `student` (\n" +
                "  `student_id` int(11) NOT NULL,\n" +
                "  `firstname` varchar(20) DEFAULT NULL,\n" +
                "  `lastname` varchar(40) DEFAULT NULL,\n" +
                "  `address` varchar(40) DEFAULT NULL,\n" +
                "  `district` varchar(30) DEFAULT NULL,\n" +
                "  `post_code` char(5) DEFAULT NULL,\n" +
                "  `email` varchar(50) DEFAULT NULL,\n" +
                "  `phonenumber` varchar(15) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`student_id`),\n" +
                "  KEY `Student_sukuname_index` (`lastname`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        statement.addBatch("CREATE TABLE IF NOT EXISTS `course` (\n" +
                "  `course_id` int(11) NOT NULL,\n" +
                "  `name` varchar(40) DEFAULT NULL,\n" +
                "  `credit` int(11) DEFAULT NULL,\n" +
                "  `description` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`course_id`),\n" +
                "  KEY `Course_name_index` (`name`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n");
        statement.addBatch("CREATE TABLE IF NOT EXISTS `accomplishment` (\n" +
                "  `student_id` int(11) NOT NULL,\n" +
                "  `course_id` int(11) NOT NULL,\n" +
                "  `grade` int(11) NOT NULL,\n" +
                "  `accomplishment_date` date DEFAULT NULL,\n" +
                "  PRIMARY KEY (`student_id`,`course_id`),\n" +
                "  KEY `Accomplishment_student_id_index` (`student_id`),\n" +
                "  KEY `Accomplishment_course_id_index` (`course_id`),\n" +
                "  CONSTRAINT `accomplishment_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE,\n" +
                "  CONSTRAINT `accomplishment_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        statement.addBatch("INSERT INTO `course` (`course_id`, `name`, `credit`, `description`) VALUES (1, 'Olio ohjelmointi', 5, 'Harjoitellaan olio ohjelmoinnin perusteita');");
        statement.addBatch("INSERT INTO `course` (`course_id`, `name`, `credit`, `description`) VALUES (2, 'Käyttöliittymäohjelmointi', 5, 'Harjoitellaan käyttöliittymäohjelmoinnin perusteita');");
        statement.addBatch("INSERT INTO `course` (`course_id`, `name`, `credit`, `description`) VALUES (3, 'Puutyöt', 30, 'Puutöiden salojen opiskelua');");
        statement.addBatch("INSERT INTO `course` (`course_id`, `name`, `credit`, `description`) VALUES (4, 'Espanja', 5, 'Espanjan alkeiden opiskelua');");
        statement.addBatch("INSERT INTO `student` (`student_id`, `firstname`, `lastname`, `address`, `district`, `post_code`, `email`, `phonenumber`) VALUES (1, 'Maiju', 'Mehiläinen', 'Tulliportinkatu 5', 'Joensuu', '80100', 'mehismaiju@gmail.com', '5551112345');");
        statement.addBatch("INSERT INTO `student` (`student_id`, `firstname`, `lastname`, `address`, `district`, `post_code`, `email`, `phonenumber`) VALUES (2, 'Keijo', 'Kekkonen', 'Tulliportinkatu 4', 'Joensuu', '80100', 'kekkiskeke@gmail.com', '5551112346');\n");
        statement.addBatch("INSERT INTO `student` (`student_id`, `firstname`, `lastname`, `address`, `district`, `post_code`, `email`, `phonenumber`) VALUES (3, 'Heikki', 'Hevosmies', 'Karjalankatu 5', 'Savonlinna', '57130', 'heppahege@gmail.com', '5551112347');\n");
        statement.addBatch("INSERT INTO `student` (`student_id`, `firstname`, `lastname`, `address`, `district`, `post_code`, `email`, `phonenumber`) VALUES (5, 'Väinämöinen', '', 'Väinämöisen koti', 'Kalevala', '', '', '0100100');\n");
        statement.addBatch("INSERT INTO `student` (`student_id`, `firstname`, `lastname`, `address`, `district`, `post_code`, `email`, `phonenumber`) VALUES (15, 'Muokkaa', 'Minua', 'Tulliportinkatu 6', 'Joensuu', '80100', 'email@gmail.com', '045667777');\n");
        statement.addBatch("INSERT INTO `accomplishment` (`student_id`, `course_id`, `grade`, `accomplishment_date`) VALUES (1, 1, 1, '1998-12-02');");
        statement.addBatch("INSERT INTO `accomplishment` (`student_id`, `course_id`, `grade`, `accomplishment_date`) VALUES (2, 2, 4, '1998-12-12');");
        statement.addBatch("INSERT INTO `accomplishment` (`student_id`, `course_id`, `grade`, `accomplishment_date`) VALUES (5, 1, 5, '2020-11-20');");
        statement.addBatch("INSERT INTO `accomplishment` (`student_id`, `course_id`, `grade`, `accomplishment_date`) VALUES (5, 2, 5, '2020-11-21');");
        statement.addBatch("INSERT INTO `accomplishment` (`student_id`, `course_id`, `grade`, `accomplishment_date`) VALUES (5, 3, 5, '2020-11-19');");
        statement.addBatch("INSERT INTO `accomplishment` (`student_id`, `course_id`, `grade`, `accomplishment_date`) VALUES (5, 4, 5, '2020-11-19');");
        statement.executeBatch();
        dbDisconnect();


    }
    /**
     * Db disconnect.
     *
     * @throws SQLException the sql exception
     */

    public static void dbDisconnect() throws SQLException{
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    /**
     * Db execute query.
     *
     * @param sqlStatement the sql statement
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */

// for insert/delete/update
    public static void dbExecuteQuery(String sqlStatement) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        try {
            dbConnect();
            statement = connection.createStatement();
            statement.executeQuery("USE university_database");
            statement.execute(sqlStatement);
        }
        catch (SQLException e){
            System.out.println("Query execution failed");
            throw e;
        }
        finally {
            if(statement != null){
                statement.close();
            }
            dbDisconnect();
        }
    }

    /**
     * Db execute result set.
     *
     * @param query the query
     * @return the result set
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
// For searching data
    public static ResultSet dbExecute(String query) throws ClassNotFoundException, SQLException{
        Statement statement = null;
        ResultSet rs = null;

        CachedRowSet crs;

        try {
            dbConnect();
            statement = connection.createStatement();
            statement.executeQuery("USE university_database");
            rs = statement.executeQuery(query);
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);
        }
        catch (SQLException e){
            System.out.println("Error in execute operation " + e);
            throw e;
        }
        finally {
            if (rs != null){
                rs.close();
            }
            if (statement != null){
                statement.close();
            }
            dbDisconnect();
        }
        return crs;
    }




}
