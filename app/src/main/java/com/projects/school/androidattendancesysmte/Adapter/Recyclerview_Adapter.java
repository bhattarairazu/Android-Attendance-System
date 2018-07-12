package com.projects.school.androidattendancesysmte.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.school.androidattendancesysmte.Database;
import com.projects.school.androidattendancesysmte.Model.Attendance_models;
import com.projects.school.androidattendancesysmte.Model.Model_attendance;
import com.projects.school.androidattendancesysmte.Model.Selectedvalue;
import com.projects.school.androidattendancesysmte.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 6/18/2018.
 */

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.MyViewHolder> {
    private Context mcontext;
    private List<Attendance_models> mdatamodels;


    public Recyclerview_Adapter(Context mcontext, List<Attendance_models> mdatamodels) {
        this.mcontext = mcontext;
        this.mdatamodels = mdatamodels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_attendancelayout1,parent,false);
        return new MyViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.MyViewHolder holder, int position) {
        Attendance_models mdata = mdatamodels.get(position);
        holder.ids.setText(Integer.toString(mdata.getId()));
        holder.names.setText(mdata.getName());


    }

    @Override
    public int getItemCount() {
        return mdatamodels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ids,names;
        CheckBox mcheckbox_presnt,mcheckbox_absent;
        public MyViewHolder(View itemView) {
            super(itemView);
            ids = (TextView)itemView.findViewById(R.id.mtextview_rollno);
            names = (TextView)itemView.findViewById(R.id.mtextview_name);
            mcheckbox_presnt =(CheckBox) itemView.findViewById(R.id.checkBox_present);
            mcheckbox_absent = (CheckBox) itemView.findViewById(R.id.checkBox_Absent);
//            itemView.setOnClickListener(this);
//            ids.setOnClickListener(this);
//            names.setOnClickListener(this);
            mcheckbox_presnt.setOnClickListener(this);
            mcheckbox_absent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int id = getAdapterPosition();
            final Database mdatabse = new Database(mcontext);
            switch (v.getId()){
                case R.id.checkBox_present:
                    mcheckbox_presnt.isChecked();
                    if(mcheckbox_presnt.isChecked()){
                        String name = mdatamodels.get(id).getName().toString();
                        String rollno = Integer.toString(mdatamodels.get(id).getId());
                        String attendance = "P";
                        String clas = "3rd sem";
                        String teacher = "Santosh";
                        String semester = "A";
                        String date = "2017/10/10";
                        String course ="OOP";
                        boolean res = mdatabse.adddata(new Model_attendance(name,semester,clas,attendance,date,teacher,course,rollno));
                        if(res) {
                            //Toast.makeText(mcontext, "Data added Sucessfull", Toast.LENGTH_SHORT).show();
                        }else {
                             Toast.makeText(mcontext, "Data added Failed", Toast.LENGTH_SHORT).show();
                            Log.d("ADDS", "adddatas_routine: kkkkkkkkkkk" + res);
                        }

                    }else{
                        Toast.makeText(mcontext, "you have unchecked", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.checkBox_Absent:
                    mcheckbox_absent.isChecked();
                    if(mcheckbox_absent.isChecked()){
                        String name = mdatamodels.get(id).getName().toString();
                        String rollno = Integer.toString(mdatamodels.get(id).getId());
                        String attendance = "A";
                        String clas = "3rd sem";
                        String teacher = "Santosh";
                        String semester = "A";
                        String date = "2017/10/10";
                        String course ="OOP";
                        boolean res = mdatabse.adddata(new Model_attendance(name,semester,clas,attendance,date,teacher,course,rollno));
                        if(res) {
                            //Toast.makeText(mcontext, "Data added Sucessfull", Toast.LENGTH_SHORT).show();
                        }else {
                             Toast.makeText(mcontext, "Data added Failed", Toast.LENGTH_SHORT).show();
                            Log.d("ADDS", "adddatas_routine: kkkkkkkkkkk" + res);
                        }

                    }else{
                        Toast.makeText(mcontext, "you have unchecked", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

//            mcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//           Selectedvalue mvalue = new Selectedvalue();
//            mcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

//            });
//            Boolean val;
          //Toast.makeText(mcontext, "Good Boy"+selectedStrings.get(id).getId(), Toast.LENGTH_SHORT).show();
//
//
////            switch (v.getId()){
//            if (mcheckbox.isChecked()){
//
//                Toast.makeText(mcontext, "values are:"+mdatamodels.get(id).getName()+"roll is:"+mdatamodels.get(id).getId(), Toast.LENGTH_SHORT).show();
//
//            }
//
//
//            }
        }
    }
}
