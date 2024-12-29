package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USER
 */
public class Reports {
    private String reportID = generateUniqueID();
    private InteractiveMap daerah;
    private ArrayList<String> comments;
    
    private String generateUniqueID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    //Levels
    public int waterLevel;
    public int sanitationLevel;
    //Questions
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
    private String question6;
    private String question7;
    private String question8;
    private String question9;
    private String question10;
    

    public String getReportID() {
        return reportID;
    }
    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public InteractiveMap getDaerah() {
        return daerah;
    }
    public void setDaerah(InteractiveMap daerah) {
        this.daerah = daerah;
    }

    public List<String> getComments() {
        return comments;
    }
    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public int getWaterLevel() {
        return waterLevel;
    }
    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getSanitationLevel() {
        return sanitationLevel;
    }
    public void setSanitationLevel(int sanitationLevel) {
        this.sanitationLevel = sanitationLevel;
    }

    
    
    public String getQuestion1() {
        return question1;
    }
    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }
    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }
    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }
    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getQuestion5() {
        return question5;
    }
    public void setQuestion5(String question5) {
        this.question5 = question5;
    }

    public String getQuestion6() {
        return question6;
    }
    public void setQuestion6(String question6) {
        this.question6 = question6;
    }

    public String getQuestion7() {
        return question7;
    }
    public void setQuestion7(String question7) {
        this.question7 = question7;
    }

    public String getQuestion8() {
        return question8;
    }
    public void setQuestion8(String question8) {
        this.question8 = question8;
    }

    public String getQuestion9() {
        return question9;
    }
    public void setQuestion9(String question9) {
        this.question9 = question9;
    }

    public String getQuestion10() {
        return question10;
    }
    public void setQuestion10(String question10) {
        this.question10 = question10;
    }
    
    public void pertanyaanLaporanair() {
        System.out.println("Silakan jawab pertanyan dengan ya/tidak sesuai dengan kondisi air anda");
        setQuestion1("Apakah warna air di dalam rumah anda keruh atau memiliki perubahan warna?");
        setQuestion2("Apakah airnya memiliki bau yang aneh atau tidak wajar?");
        setQuestion3("Apakah air anda memiliki endapan atau ada partikel-partikel yang mengapung?");
        setQuestion4("Apakah air anda terasa lengket setelah digunakan?");
        setQuestion5("Menurut anda apakah air anda Tidak sesuai dengan standar kebersihan air?");
    }
    
    public void pertanyaanLaporansanitasi() {
        System.out.println("Silakan jawab pertanyan dengan ya/tidak sesuai dengan kondisi sanitasi anda");
        setQuestion6("Apakah ada sampah yang berserakan di lingkungan sekitar anda?");
        setQuestion7("Apakah septic tank di lingkungan anda ada yang tersumbat?");
        setQuestion8("Apakah selokan anda kotor dan memiliki bau yang tidak wajar?");
        setQuestion9("Apakah di selokan lingkungan anda tidak ada capung?");
        setQuestion10("Apakah menurut anda fasilitas di lingkungan anda belum memiliki sanitasi yang layak?");
    }       
    
    public void addComment(String comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }
    
        public void printComments() {
        if (comments != null && !comments.isEmpty()) {
            for (String comment : comments) {
                System.out.println(comment);
            }
        } else {
            System.out.println("No comments.");
        }
    }
}