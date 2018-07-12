package com.projects.school.androidattendancesysmte.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.school.androidattendancesysmte.MainActivity;
import com.projects.school.androidattendancesysmte.Model.Model_listcourse;
import com.projects.school.androidattendancesysmte.R;

import org.w3c.dom.Text;

import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by Dell on 6/22/2018.
 */

public class Recyclerview_listcourse extends RecyclerView.Adapter<Recyclerview_listcourse.MyViewHolder> {
    private Context mcontext;
    private List<Model_listcourse> mlist;

    public Recyclerview_listcourse(Context mcontext, List<Model_listcourse> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_attendancelayout,parent,false);
        return new MyViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model_listcourse mlistcourse = mlist.get(position);
        holder.mtextview_classname.setText(mlistcourse.getClass_name());
        holder.mtextview_secname.setText(mlistcourse.getSec_name());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mtextview_classname,mtextview_secname;
        public MyViewHolder(View itemView) {
            super(itemView);
            mtextview_classname =  (TextView) itemView.findViewById(R.id.textview_classname);
            mtextview_secname  = (TextView) itemView.findViewById(R.id.textview_secname);
            itemView.setOnClickListener(this);
            mtextview_secname.setOnClickListener(this);
            mtextview_classname.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = getAdapterPosition();
            Intent miintents  = new Intent(v.getContext(), MainActivity.class);
            miintents.putExtra("class_name",mlist.get(id).getClass_name());
            miintents.putExtra("sec_name",mlist.get(id).getSec_name());
            miintents.putExtra("teacher_name","Santosh");
            v.getContext().startActivity(miintents);

        }
    }
}
