package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.Reports;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author USER
 */
public class UserDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost/aquasanity";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "revialdyarifs324";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveUser(User user) {
        // Perform database insert operation to save the user
        // Use prepared statements to avoid SQL injection
        String query = "INSERT INTO users(username, password, name, email) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String username, String password) {
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Add proper logging in a real application
        }

        return null;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String email = rs.getString("email");

                User user = new User(username, password, name, email);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public static void saveReport(User user, Reports report) {
        String query = "INSERT INTO reports(report_id, water_level, sanitation_level, username) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, report.getReportID());
            pstmt.setInt(2, report.getWaterLevel());
            pstmt.setInt(3, report.getSanitationLevel());
            pstmt.setString(4, user.getUsername());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving report: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
        public static List<Reports> getReports(String username) {
        List<Reports> reports = new ArrayList<>();
        String query = "SELECT * FROM reports WHERE username = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Reports report = new Reports();
                    report.setReportID(resultSet.getString("report_id"));
                    report.setWaterLevel(resultSet.getInt("water_level"));
                    report.setSanitationLevel(resultSet.getInt("sanitation_level"));
                    // Add other attributes as needed
                    reports.add(report);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching reports: " + e.getMessage());
            e.printStackTrace();
        }

        return reports;
    }
    
    public static List<String> getCommentsByReportID(String reportID) {
        List<String> comments = new ArrayList<>();
        String query = "SELECT * FROM comments WHERE report_id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, reportID);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    comments.add(resultSet.getString("comment"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching comments: " + e.getMessage());
            e.printStackTrace();
        }

        return comments;
    }

    public static void saveComments(String reportID, List<String> comments) {
        if (comments != null && !comments.isEmpty()) {
            String query = "INSERT INTO comments(report_id, comment) VALUES (?, ?)";
            try (Connection con = getConnection();
                 PreparedStatement pstmt = con.prepareStatement(query)) {
                for (String comment : comments) {
                    pstmt.setString(1, reportID);
                    pstmt.setString(2, comment);
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            } catch (SQLException e) {
                System.err.println("Error saving comments: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    
    public static void deleteReport(String reportID) {
        String deleteReportQuery = "DELETE FROM reports WHERE report_id = ?";
        String deleteCommentsQuery = "DELETE FROM comments WHERE report_id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmtReport = con.prepareStatement(deleteReportQuery);
             PreparedStatement pstmtComments = con.prepareStatement(deleteCommentsQuery)) {
            con.setAutoCommit(false); // Set autocommit to false to ensure atomicity

            // Delete comments associated with the report
            pstmtComments.setString(1, reportID);
            pstmtComments.executeUpdate();

            // Delete the report itself
            pstmtReport.setString(1, reportID);
            pstmtReport.executeUpdate();

            con.commit(); // Commit the transaction
            con.setAutoCommit(true); // Set autocommit back to true
        } catch (SQLException e) {
            System.err.println("Error deleting report: " + e.getMessage());
            e.printStackTrace();
        }
  } 
}