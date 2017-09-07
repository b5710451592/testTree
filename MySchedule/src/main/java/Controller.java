

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;





public class Controller {

    Connection connection = null;   //con
    PreparedStatement pst = null;
    ResultSet resultSet = null;   //rs


    public Connection databaseConnection() throws SQLException {
        Connection conn = null;
        try {
            // setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Myschedule.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database.");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }



    public void loadDataFromDB(ObservableList<String> items, ListView listView ) throws SQLException {
        //tableList.clear();  items
        try {
            pst = connection.prepareStatement("Select * from Myschedule");
            resultSet = pst.executeQuery();
            MySchedule schedule= new MySchedule(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4));
            while(resultSet.next()) {
        //        items.add(new MySchedule(resultSet.getString(1), resultSet.getString(2)));
                items.add(schedule.getTextNumber()+") "+schedule.getTextDate()+" "
                        +schedule.getTextTime()+" "+schedule.getTextNote());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        listView.setItems(items);
    }



    public MySchedule getEvent(int num, String date, String time, String details) {
        MySchedule entry = new MySchedule(num, date, time, details);
        return entry;
    }


    public void addEvent(MySchedule schedule) throws SQLException {
        int num = 0;
        //pst = connection.prepareStatement("Select Max(no) from Myschedule");
        pst = connection.prepareStatement("Select  from Myschedule");
        resultSet = pst.executeQuery();
        while(resultSet.next()) {
            num = resultSet.getInt(1)+1;
        }
        String sql = "INSERT INTO Myschedule(no, date, time, note) VALUES(?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, num);
            pst.setString(2, schedule.getTextDate());
            pst.setString(3, schedule.getTextTime());
            pst.setString(4, schedule.getTextNote());
            int i = pst.executeUpdate();
            if(i == 1) {
                System.out.println("Add Event");
               // System.out.println("No: " + c.getNumber() + " Date:" + c.getDate() + " Time: " + c.getTime() + " Details:" + c.getDetail());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            pst.close();
        }
    }


    public void deleteEvent(int num) throws SQLException {
        String sql = "DELETE FROM Myschedule WHERE no = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, num);
            pst.executeUpdate();
            System.out.println("Delete Event");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            pst.close();
        }
    }











}
