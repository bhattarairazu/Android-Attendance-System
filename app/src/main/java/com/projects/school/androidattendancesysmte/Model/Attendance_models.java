package com.projects.school.androidattendancesysmte.Model;

/**
 * Created by Dell on 6/18/2018.
 */

public class Attendance_models {
    private int id;
    private String name;
    private Boolean checkboxitem;

    public Attendance_models(int id, String name, Boolean checkboxitem) {
        this.id = id;
        this.name = name;
        this.checkboxitem = checkboxitem;
    }

    public Attendance_models(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Attendance_models() {
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

    public Boolean getCheckboxitem() {
        return checkboxitem;
    }

    public void setCheckboxitem(Boolean checkboxitem) {
        this.checkboxitem = checkboxitem;
    }
}
