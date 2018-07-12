package com.projects.school.androidattendancesysmte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.projects.school.androidattendancesysmte.Model.Model_attendance;

//import com.example.razu.newcsitproject.Model.Model_favouriteslis;
//import com.example.razu.newcsitproject.Model.Routinedata_sqlite;


/**
 * Created by Razu on 12/3/2017.
 */

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
//databse name
    private static final String DATABASE_NAME="ATTENDANCE";
    //Routine table
    private static final String TABLE_attendance = "attend";
    private static final String Routine_name = "Name";
    private static final String Routine_class="Class";
    private static final String Routine_semester="Semester";
    private static final String Routine_attendance = "Attendance";
    private static final String Routine_date = "Date";
    private static final String Routine_Teacher = "Teacher";
    private static final String Routine_Course = "Course";
    private static final String Routine_Rollno = "ROll";

// private static final String CREATE_ROUTINE_TABLE = "CREATE TABLE " + TABLE_Routine + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
        // Routine_day + " TEXT, " + Routine_endtime + " TEXT, " + Routine_subject + " TEXT, " + Routine_teacher + " TEXT)";
private static final String CREATE_ROUTINE_Attendance = "CREATE TABLE " + TABLE_attendance + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
        Routine_name + " VARCHAR(500) NOT NULL, " +
        Routine_class + " VARCHAR(500) NOT NULL, " +
        Routine_semester + " VARCHAR(50) NOT NULL, " +
        Routine_attendance + " VARCHAR(50) NOT NULL, " +
        Routine_date + " VARCHAR(500) NOT NULL, " +
        Routine_Teacher + " VARCHAR(500) NOT NULL, " +
        Routine_Rollno + " VARCHAR(500) NOT NULL, " +
        Routine_Course + " VARCHAR(500) NOT NULL)";
//favourtie news list table
//    private static final String Favourite_Newstable = "FavouriteNewstable";
//    private static final String News_id = "newsid";
//    private static final String News_name = "newsname";
//    private static final String News_descrption = "newsdescription";
//    private static final String CREATE_Favourite_Newstable = "CREATE TABLE " + Favourite_Newstable + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            News_id + " VARCHAR(500) NOT NULL, " +
//            News_name + " VARCHAR(500) NOT NULL, " +
//            News_descrption + " VARCHAR(500) NOT NULL)";
//
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(CREATE_ROUTINE_Attendance);
        //sqLiteDatabase.execSQL(CREATE_Favourite_Newstable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
          sqLiteDatabase.execSQL("DROP IF TABLE EXISTS" + TABLE_attendance);
        //sqLiteDatabase.execSQL("DROP IF TABLE EXISTS" + Favourite_Newstable);
          onCreate(sqLiteDatabase);
    }
    //add datas of routine
    public boolean adddata(Model_attendance datas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(Routine_name,datas.getName());
        content.put(Routine_class,datas.getClas());
        content.put(Routine_semester,datas.getSem());
        content.put(Routine_attendance,datas.getAttendance());
        content.put(Routine_date,datas.getDate());
        content.put(Routine_Teacher, datas.getTeacher());
        content.put(Routine_Rollno,datas.getRollno());
        content.put(Routine_Course,datas.getCourse());
        long result = db.insert(TABLE_attendance,null,content);
        if(result == -1){
         return false;
       }else {
         return true;
        }
            }
            //getdatas of routine
    public Cursor getdata_sun(String days){
        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "SELECT ID,Name,Attendance,ROll FROM " + TABLE_attendance + " WHERE " + Routine_attendance + " = '" + days + "'";//+ " where Day=SUN" ;
        String query = "SELECT ID,Name,Attendance,Roll FROM " + TABLE_attendance ;
       // SQLiteDatabase db = this.getReadableDatabase();
       // String query = "SELECT ID,ime,tim,Subject,Teacher FROM " + TABLE_Routine + " WHERE " + Routine_day + "='" + sunday + "'"  ;
        //Cursor data = db.rawQuery(query,null);
        Cursor datas =db.rawQuery(query,null);
        Log.d("database", "getdata_sun: kkkkkkkkkkkkkkkk"+datas.toString());
        return datas;
    }
//    public boolean delete_routine(Routinedata_sqlite id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        long resutl = db.delete(TABLE_Routine,"ID = ?",new String[]{String.valueOf(id.getId())});
//        db.close();
//        if(resutl== -1){
//            return false;
//        }
//        else{
//            return true;
//    }
//    }
//    public boolean update_routine(Routinedata_sqlite datas){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues content = new ContentValues();
//        content.put(Routine_day,datas.getDay());
//        content.put(Routine_starttime,datas.getStart_times());
//        content.put(Routine_endtime,datas.getEnd_times());
//        content.put(Routine_subject,datas.getSubject());
//        content.put(Routine_teacher,datas.getTeacher());
//        long resutl = db.update(TABLE_Routine,content,"ID = ?",new String[]{String.valueOf(datas.getId())});
//        db.close();
//        if(resutl==1){
//            return true;
//
//        }else{
//            return false;
//        }
//    }
//    //add datas to favourite news
//    public boolean add_favouritenews(String fid,String fnes,String fdes){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues mvalues = new ContentValues();
//        mvalues.put(News_id,fid);
//        mvalues.put(News_name,fnes);
//        mvalues.put(News_descrption,fdes);
//        long result = db.insert(Favourite_Newstable,null,mvalues);
//        if(result == -1){
//            return false;
//        }else {
//            return true;
//        }
//
//    }
//    //get datas from favourite news
//    public Cursor getdata_favourites(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT * FROM " + Favourite_Newstable ;
//        Cursor mcursor = db.rawQuery(query,null);
//        return mcursor;
//    }
//    //removie data from favourite news
//    public boolean remove_favourite(int id){
//    SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.delete(Favourite_Newstable,"ID = ?",new String[]{String.valueOf(id)});
//        db.close();
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
