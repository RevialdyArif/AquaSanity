package Model;


import DAO.UserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class MAIN {
    
        public static void main(String[] args) {
            
        Scanner scanner = new Scanner(System.in);   
        List<User> users = new ArrayList<>();
        User currentUser = null;

        boolean isRunning = true;
        while (isRunning) {
            if (currentUser == null) {
                // Menampilkan menu untuk user yang belum login
                System.out.println("1. Sign Up");
                System.out.println("2. Sign In");
                System.out.println("3. Keluar");
                System.out.print("Pilih nomor yang diinginkan: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // consume newline character

                switch (choice) {
                    case 1:
                        // Sign Up
                        String signUpName;
                        String signUpEmail;
                        String signUpUsername;
                        String signUpPassword;
                        // Melakukan loop untuk memastikan username dan password yang unik
                        boolean isUnique;
                        do {
                            System.out.print("Masukan Nama Anda: ");
                            signUpName = scanner.nextLine();
                            System.out.print("Masukan Email Anda: ");
                            signUpEmail = scanner.nextLine();
                            System.out.print("Masukan Username Anda: ");
                            signUpUsername = scanner.nextLine();
                            System.out.print("Masukan Password Anda: ");
                            signUpPassword = scanner.nextLine();
                            // Pemanggilan metode signUp dengan memasukkan daftar pengguna yang sudah ada
                            isUnique = User.isUnique(signUpUsername, signUpPassword, users);

                            if (!isUnique) {
                                System.out.println("Username atau password sudah digunakan. Tolong buat yang berbeda.");
                            }
                        } while (!isUnique);

                        // Pemanggilan metode signUp dengan memasukkan daftar pengguna yang sudah ada
                        User newUser = User.signUp(signUpUsername, signUpPassword,signUpName, signUpEmail, users);

                        if (newUser != null) {
                            // Save the new user to the database
                            UserDAO.saveUser(newUser);
                            System.out.println("Sign up berhasil!");
                        }
                        
                        
                        break;

                    case 2:
                        // Sign In
                        System.out.print("Masukan username: ");
                        String signInUsername = scanner.nextLine();
                        System.out.print("Masukan password: ");
                        String signInPassword = scanner.nextLine();
                        
                        // Retrieve user from the database
                        currentUser = UserDAO.getUser(signInUsername, signInPassword);
                        
                        if (currentUser != null) {
                            System.out.println("Sign in berhasi!");
                        } else {
                            System.out.println("Sign in Gagal. Username atau Password Salah.");
                        }
                        break;

                    case 3:
                        // Exit
                        isRunning = false;
                        System.out.println("Mengeluarkan anda dari program. Sampai jumpa lagi!");
                        break;

                    default:
                        System.out.println("Pilihan Salah. Mohon Pilih Nomor Yang Benar.");
                }
            } else {
                // Menampilkan menu untuk user yang sudah login
                System.out.println("1. Lihat Data User");
                System.out.println("2. Lihat Level Sanitasi dan Kualitas Air Di Dalam Interactive Map");
                System.out.println("3. Lihat Riwayat Laporan User ");
                System.out.println("4. Membuat Laporan");
                System.out.println("5.Menghapus Laporan");
                System.out.println("6. Log Out");
                System.out.println("7. Keluar");
                System.out.print("Pilih nomor yang diinginkan: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // Show User Identity
                        System.out.println("Data User:");
                        System.out.println("Name: " + currentUser.getName());
                        System.out.println("Email: " + currentUser.getEmail());
                        break;
                    case 2:
                    case 3:
                        currentUser.viewReportHistory();
                        break;
                    case 4:
                        Reports obj = new Reports();
                        currentUser.reportSystem(obj);

                        // Add comment
                        System.out.print("Masukan komen: ");
                        String comment = scanner.nextLine();
                        obj.addComment(comment);

                        System.out.println("Water Level: " + obj.getWaterLevel());
                        System.out.println("Sanitation Level: " + obj.getSanitationLevel());
                        
                        // Save the report to the database
                        UserDAO.saveReport(currentUser, obj);

                        // Save comments to the database
                        UserDAO.saveComments(obj.getReportID(), obj.getComments());
                        
                        // Print comments
                        currentUser.printComments();
                        break;
                    case 5:
                        // Delete Report
                        System.out.print("Enter the index of the report to delete: ");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        currentUser.deleteReport(deleteIndex);                        
                        break;
                        
                    case 6:
                        // Log Out
                        currentUser.logOut();
                        currentUser = null;
                        System.out.println("Log out Berhasil!");
                        break;

                    case 7:
                        // Exit
                        isRunning = false;
                        System.out.println("Mengeluarkan anda dari program. Sampai jumpa lagi!");
                        break;

                    default:
                        System.out.println("Pilihan Salah. Mohon Pilih Nomor Yang Benar.");
                }
            }
        }
            
            
    }
}