package com.projects.school.androidattendancesysmte.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projects.school.androidattendancesysmte.Model.Model_attendance;
import com.projects.school.androidattendancesysmte.Model.Selectedvalue;
import com.projects.school.androidattendancesysmte.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 6/18/2018.
 */

public class Listadapter extends BaseAdapter {
    private Context mcontext;
    private List<Model_attendance> mlist = new ArrayList<>();

    public Listadapter(Context mcontext, List<Model_attendance> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //final ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.singleitemlistview,parent,false);

        }
        String type;
        TextView textid,textname,text_type_abset,text_type_present;
            textid = (TextView)convertView.findViewById(R.id.mtextivw_listid);
            textname =(TextView) convertView.findViewById(R.id.mtexview_listname);
            text_type_abset = (TextView) convertView.findViewById(R.id.mtextview_type_absent);
            text_type_present = (TextView) convertView.findViewById(R.id.mtextview_type_present);
            textid.setText(mlist.get(position).getAttendance());
            textname.setText(mlist.get(position).getName());
            type = mlist.get(position).getAttendance();
            if(type.equals("A")){
                text_type_abset.setText(type);
                text_type_abset.setVisibility(View.VISIBLE);
                text_type_present.setVisibility(View.GONE);
            }else{
                text_type_present.setText(type);
                text_type_present.setVisibility(View.VISIBLE);
                text_type_abset.setVisibility(View.GONE);
            }





       return convertView;
    }
}
