package com.projects.school.androidattendancesysmte;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.projects.school.androidattendancesysmte.Adapter.Listadapter;
import com.projects.school.androidattendancesysmte.Adapter.Recyclerview_Adapter;
import com.projects.school.androidattendancesysmte.Model.Attendance_models;
import com.projects.school.androidattendancesysmte.Model.Selectedvalue;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecyclerview;
    private Recyclerview_Adapter madapter;
    private List<Attendance_models> marraylist = new ArrayList<>();
    private RecyclerView.LayoutManager mlayoutmanager;
    private Toolbar mtolbar;
    private Database mdatabse ;
    private String spinneritem_course,spinneritem_type;
    private Button mbtn;
    private String[] name={"razu","bhattarai","akskksks","razu","bhattarai","akskksks","razu","bhattarai","akskksks","razu","bhattarai","akskksks"};
    private int [] idss ={1,3,4,5,6,7,8,9,0,1,7,8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtolbar = (Toolbar) findViewById(R.id.mtolbars);
        setSupportActionBar(mtolbar);
        mtolbar.setTitle("MBM Attendance System");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mbtn = (Button) findViewById(R.id.mbtn_submit);
        mdatabse = new Database(this);
        mrecyclerview = (RecyclerView)findViewById(R.id.mrecycler_view);
        mlayoutmanager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mrecyclerview.setLayoutManager(mlayoutmanager);
        Attendance_models mattendance1 = new Attendance_models(1,"Razu");
        marraylist.add(mattendance1);
        Attendance_models mattendance2 = new Attendance_models(2,"Razu Bhattara");
        marraylist.add(mattendance2);
        Attendance_models mattendance3 = new Attendance_models(3,"Razusdf");
        marraylist.add(mattendance3);
        Attendance_models mattendance4 = new Attendance_models(4,"Razusdsd");
        marraylist.add(mattendance4);
        Attendance_models mattendance5 = new Attendance_models(1,"Razu");
        marraylist.add(mattendance5);
        Attendance_models mattendance6 = new Attendance_models(2,"Razu Bhattara");
        marraylist.add(mattendance6);
        Attendance_models mattendance7 = new Attendance_models(3,"Razusdf");
        marraylist.add(mattendance7);
        Attendance_models mattendance8 = new Attendance_models(4,"Razusdsd");
        marraylist.add(mattendance8);
        mrecyclerview.setAdapter(new Recyclerview_Adapter(this,marraylist));
//      final List<Selectedvalue> mlist = new ArrayList<>();
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this,Newlist.class));

                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
                View mview = getLayoutInflater().inflate(R.layout.alertdialog_confirm,null);
               // final ListView mlistview = (ListView)mview.findViewById(R.id.mlistview);
//                final Listadapter madapter;
                //mlistview.setAdapter(new Listadapter(getApplicationContext(),mlist));
                mbuilder.setView(mview);
                final AlertDialog dialog = mbuilder.create();
                dialog.show();


                }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_sync:
                Toast.makeText(this, "Syncing...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
                View mview = getLayoutInflater().inflate(R.layout.alertdialog_report,null);
                // final ListView mlistview = (ListView)mview.findViewById(R.id.mlistview);
                final Button mbtn_save = (Button) mview.findViewById(R.id.btn_confirm);
                final Button mbtn_cancel = (Button) mview.findViewById(R.id.btn_cancel);

                //final Spinner spinner_date = (Spinner) mview.findViewById(R.id.spinner_date);
                final Spinner spinner_course = (Spinner) mview.findViewById(R.id.spinner_course);
                final Spinner spinner_type = (Spinner) mview.findViewById(R.id.spinner_Type);
                //for spinner course
                ArrayList<String> elist = new ArrayList<>();
                elist.add("OOP");
                elist.add("OS");
                elist.add("CA");
                elist.add("Management");
                elist.add("NM");
                ArrayAdapter<String> madapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,elist);
                madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_course.setAdapter(madapter);
                spinner_course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        spinneritem_course = adapterView.getItemAtPosition(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                //for spinner types
                ArrayList<String> elist_type= new ArrayList<>();
                elist_type.add("Absent");
                elist_type.add("Present");
                elist_type.add("All");
                ArrayAdapter<String> madapter_type = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,elist_type);
                madapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_type.setAdapter(madapter_type);
                spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        spinneritem_type = adapterView.getItemAtPosition(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
//                final Listadapter madapter;
                //mlistview.setAdapter(new Listadapter(getApplicationContext(),mlist));
                mbuilder.setView(mview);
                final AlertDialog dialog = mbuilder.create();
                dialog.show();
                mbtn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                         startActivity(new Intent(MainActivity.this,Newlist.class));
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
