package com.projects.school.androidattendancesysmte.Model;

/**
 * Created by Dell on 6/19/2018.
 */

public class Model_attendance {
    private int id;
    private String name;
    private String sem;
    private String clas;
    private String attendance;
    private String date;
    private String teacher;
    private String course;
    private String Rollno;

    public Model_attendance() {
    }

    public Model_attendance(int id, String name, String sem, String clas, String attendance, String date, String teacher, String course, String rollno) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.clas = clas;
        this.attendance = attendance;
        this.date = date;
        this.teacher = teacher;
        this.course = course;
        Rollno = rollno;
    }

    public Model_attendance(String name, String sem, String clas, String attendance, String date, String teacher, String course, String rollno) {
        this.name = name;
        this.sem = sem;
        this.clas = clas;
        this.attendance = attendance;
        this.date = date;
        this.teacher = teacher;
        this.course = course;
        Rollno = rollno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRollno() {
        return Rollno;
    }

    public void setRollno(String rollno) {
        Rollno = rollno;
    }
}
