package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DAO.UserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private ArrayList<Reports> reportHistory;    
    private ArrayList<Reports> reports;
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public User (String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.reportHistory = new ArrayList<>();

    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    } 

    public List<Reports> getReports() {
        return reports;
    }
    public void setReports(ArrayList<Reports> reports) {
        this.reports = reports;
    }
    
    
    
    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    // Metode SignUp
    public static User signUp(String username, String password, String name, String email, List<User> existingUsers) {
        // Periksa apakah username sudah digunakan
        for (User existingUser : existingUsers) {
            if (existingUser.getUsername().equals(username)) {
                System.out.println("Sign up failed. Username already in use.");
                return null;
            }
        }

        // Jika username belum digunakan, buat objek User baru dan kembalikan
        User newUser = new User(username, password, name, email);
        existingUsers.add(newUser);
        System.out.println("Sign up successful!");
        return newUser;
    }
    
    // Metode untuk memeriksa keunikan username dan password
    public static boolean isUnique(String username, String password, List<User> existingUsers) {
        for (User existingUser : existingUsers) {
            if (existingUser.getUsername().equals(username) || existingUser.getPassword().equals(password)) {
                return false;
            }
        }
        return true;
    }

    // Metode Login
    public static User signIn(String username, String password, List<User> existingUsers) {
        for (User existingUser : existingUsers) {
            if (existingUser.getUsername().equals(username) && existingUser.authenticate(password)) {
                return existingUser;
            }
        }
        return null;
    }

    // Metode LogOut
    public void logOut() {
        // Logika logout, misalnya membersihkan sesi pengguna
        System.out.println("Logging out user: " + username);
    }

    //Laporan 
    public void reportSystem(Reports obj) {
        Scanner yesNo = new Scanner(System.in);

        // Questions about water
        obj.pertanyaanLaporanair();

        // Water questions
        processAnswer(yesNo, obj, obj.getQuestion1(), true);
        processAnswer(yesNo, obj, obj.getQuestion2(), true);
        processAnswer(yesNo, obj, obj.getQuestion3(), true);
        processAnswer(yesNo, obj, obj.getQuestion4(), true);
        processAnswer(yesNo, obj, obj.getQuestion5(), true);

        // Questions about sanitation
        obj.pertanyaanLaporansanitasi();

        // Sanitation questions
        processAnswer(yesNo, obj, obj.getQuestion6(), false);
        processAnswer(yesNo, obj, obj.getQuestion7(), false);
        processAnswer(yesNo, obj, obj.getQuestion8(), false);
        processAnswer(yesNo, obj, obj.getQuestion9(), false);
        processAnswer(yesNo, obj, obj.getQuestion10(), false);
        
        reportHistory.add(obj);
    }

    public void processAnswer(Scanner scanner, Reports obj, String question, boolean isWaterQuestion) {
        System.out.println(question);

        // Check if there is more input
        if (scanner.hasNext()) {
            String answer = scanner.next().toLowerCase(); 

            while (!(answer.equals("ya") || answer.equals("tidak"))) {
                // Repeat the question until a valid answer is provided
                System.out.println("Tolong jawab dengan 'ya' atau 'tidak'.");
                if (scanner.hasNext()) {
                    answer = scanner.next().toLowerCase();
                } else {
                    System.out.println("Tidak ada jawaban. Melanjutkan proses...");
                    return;
                }
            }

            if (isWaterQuestion) {
                obj.waterLevel += (answer.equals("tidak")) ? 20 : 0;
            } else {
                obj.sanitationLevel += (answer.equals("tidak")) ? 20 : 0;
            }
        } else {
            System.out.println("Tidak ada jawaban. Melanjutkan proses...");
        }
    }
    
    public void addComment(String comment) {
        if (reports != null && !reports.isEmpty()) {
            reports.get(reports.size() - 1).addComment(comment);
        }
    }
    public void printComments() {
        if (reports != null && !reports.isEmpty()) {
            reports.get(reports.size() - 1).printComments();
        }
    }
    
    public void viewReportHistory() {
       if (reportHistory.isEmpty()) {
           System.out.println("Tidak ada riwayat laporan.");
       } else {
           System.out.println("Riwayat Laporan User " + username);
           for (Reports report : reportHistory) {
               System.out.println("Laporan ID: " + report.getReportID());
               System.out.println("Water Level: " + report.getWaterLevel());
               System.out.println("Sanitation Level: " + report.getSanitationLevel());
               System.out.println("Komentar: " + report.getComments());
               System.out.println("------------------------------");
           }
       }    
    }
    
    public void deleteReport(int index) {
      if (index >= 1 && index <= reportHistory.size()) {
          Reports deletedReport = reportHistory.remove(index - 1);
          System.out.println("Laporan dengan ID " + deletedReport.getReportID() + " berhasil dihapus.");
          UserDAO.deleteReport(deletedReport.getReportID());
      } else {
          System.out.println("Indeks laporan tidak valid.");
      }
    }
     
}