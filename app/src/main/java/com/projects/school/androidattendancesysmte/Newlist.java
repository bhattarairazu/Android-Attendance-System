package com.projects.school.androidattendancesysmte;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ListView;

import com.projects.school.androidattendancesysmte.Adapter.Listadapter;
import com.projects.school.androidattendancesysmte.Model.Model_attendance;
import com.projects.school.androidattendancesysmte.Model.Selectedvalue;

import java.util.ArrayList;
import java.util.List;

public class Newlist extends AppCompatActivity {
    private ListView mlistview ;
    private Database mdatabase;
    private ArrayList<Model_attendance> marraylist = new ArrayList<>();
    private Toolbar mtolbar;
    private int [] idss ={1,3,4,5,6,7,8,9,0,1,7,8};

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customalertdialog);
        mtolbar = (Toolbar) findViewById(R.id.mtolbars);
        setSupportActionBar(mtolbar);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //mtolbar.setNavigationOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
               // finish();
            //}
        //});
        mlistview = (ListView) findViewById(R.id.mlistview);
        getdatas();
    }
    public void getdatas() {
        mdatabase = new Database(this);
        int i = 0;
        Cursor datas = mdatabase.getdata_sun("P");
        Log.d("cursor", "getdatas: ----------" + datas);
        while (datas.moveToNext()) {
            Model_attendance data_sqlite = new Model_attendance();
            i++;
            data_sqlite.setId(datas.getInt(datas.getColumnIndex("ID")));
            //data_sqlite.setDay(datas.getString(1));
            data_sqlite.setName(datas.getString(datas.getColumnIndex("Name")));
            data_sqlite.setAttendance(datas.getString(datas.getColumnIndex("Attendance")));
            data_sqlite.setRollno(datas.getString(datas.getColumnIndex("ROll")));
            //data_sqlite.setTeacher(datas.getString(4));
            //Log.d("data", "getdatas: kkkkkkkkkkk///////");
//            Log.d("data", "getdatas: " + datas.getString(datas.getColumnIndex("Name"))) +
//                    "dd+" + datas.getString(datas.getColumnIndex("Attendance")) +
//                    "dd+" );
            Log.d("datas", "getdatas: kkkkkkk"+datas.getString(datas.getColumnIndex("Attendance"))+"dkdk"+datas.getString(datas.getColumnIndex("Name")));
            marraylist.add(data_sqlite);

        }
        mlistview.setAdapter(new Listadapter(getApplicationContext(),marraylist));


    }
}
