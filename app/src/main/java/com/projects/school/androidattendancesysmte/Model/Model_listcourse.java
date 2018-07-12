package com.projects.school.androidattendancesysmte.Model;

/**
 * Created by Dell on 6/22/2018.
 */

public class Model_listcourse {
    private String class_name;
    private String sec_name;

    public Model_listcourse(String class_name, String sec_name) {
        this.class_name = class_name;
        this.sec_name = sec_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }
}
