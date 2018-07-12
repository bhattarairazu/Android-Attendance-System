package com.projects.school.androidattendancesysmte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.projects.school.androidattendancesysmte.Adapter.Recyclerview_listcourse;
import com.projects.school.androidattendancesysmte.Model.Attendance_models;
import com.projects.school.androidattendancesysmte.Model.Model_listcourse;

import java.util.ArrayList;
import java.util.List;

public class First_courseList extends AppCompatActivity {

    private RecyclerView mrecyclerview;
    private RecyclerView.LayoutManager mlayoutmanager;
    private List<Model_listcourse> mlist = new ArrayList<>();
    private Toolbar mtolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_course_list);
        mtolbar = (Toolbar) findViewById(R.id.mtolbars);
        setSupportActionBar(mtolbar);
        setTitle("Dhanraj Sir");
        mtolbar.setSubtitle("Numerical Methodology");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mrecyclerview = (RecyclerView) findViewById(R.id.recyclervuew);
        mlayoutmanager = new GridLayoutManager(this,2);
        mrecyclerview.setLayoutManager(mlayoutmanager);

        Model_listcourse mattendance1 = new Model_listcourse("3rd Semester","A");
        mlist.add(mattendance1);
        Model_listcourse mattendance2 = new Model_listcourse("3rd Semester","B");
        mlist.add(mattendance2);
        Model_listcourse mattendance3 = new Model_listcourse("5th Semester","A");
        mlist.add(mattendance3);

        mrecyclerview.setAdapter(new Recyclerview_listcourse(this,mlist));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                Toast.makeText(this, "Logout Successfull", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
