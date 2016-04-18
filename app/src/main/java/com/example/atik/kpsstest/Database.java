package com.example.atik.kpsstest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    DBHelper helper;
    public Database(Context context){
        helper = new DBHelper(context);
    }
    public long insertQuestion(Question question) {
        SQLiteDatabase database = helper.getWritableDatabase();
        int ders = question.getQuestionClass();
        String soru = question.getQuestion();
        String a = question.getA();
        String b = question.getB();
        String c = question.getC();
        String d = question.getD();
        String e = question.getE();
        int dogruCevap = question.getAnswer();
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_DERS, ders);
        values.put(DBHelper.KEY_SORU, soru);
        values.put(DBHelper.KEY_A, a);
        values.put(DBHelper.KEY_B, b);
        values.put(DBHelper.KEY_C, c);
        values.put(DBHelper.KEY_D, d);
        values.put(DBHelper.KEY_E, e);
        values.put(DBHelper.KEY_DOGRUCEVAP, dogruCevap);
        long id = database.insert(DBHelper.DB_TABLE, null, values);
        return id;
    }
    public void clearTable(){
        SQLiteDatabase database = helper.getWritableDatabase();
        database.delete(DBHelper.DB_TABLE, null, null);
    }
    public List<Question> queryMathQuestions() {
        SQLiteDatabase db = helper.getReadableDatabase();
        List<Question> mathQuestions = new ArrayList<>();
        String query = "Select * from " + DBHelper.DB_TABLE + " where " + DBHelper.KEY_DERS + " = " + DBHelper.MATH;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestionClass(cursor.getInt(1));
                question.setQuestion(cursor.getString(2));
                question.setA(cursor.getString(3));
                question.setB(cursor.getString(4));
                question.setC(cursor.getString(5));
                question.setD(cursor.getString(6));
                question.setE(cursor.getString(7));
                question.setAnswer(cursor.getInt(8));
                mathQuestions.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mathQuestions;
    }

    public List<Question> queryHistoryQuestions() {
        List<Question> historyQuestions = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "Select * from " + DBHelper.DB_TABLE + " where " + DBHelper.KEY_DERS + " = " + DBHelper.HISTORY;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestionClass(cursor.getInt(1));
                question.setQuestion(cursor.getString(2));
                question.setA(cursor.getString(3));
                question.setB(cursor.getString(4));
                question.setC(cursor.getString(5));
                question.setD(cursor.getString(6));
                question.setE(cursor.getString(7));
                question.setAnswer(cursor.getInt(8));
                historyQuestions.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return historyQuestions;
    }

    public List<Question> queryTurkishQuestions() {
        List<Question> turkishQuestions = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "Select * from " + DBHelper.DB_TABLE + " where " + DBHelper.KEY_DERS + " = " + DBHelper.TURKISH;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestionClass(cursor.getInt(1));
                question.setQuestion(cursor.getString(2));
                question.setA(cursor.getString(3));
                question.setB(cursor.getString(4));
                question.setC(cursor.getString(5));
                question.setD(cursor.getString(6));
                question.setE(cursor.getString(7));
                question.setAnswer(cursor.getInt(8));
                turkishQuestions.add(question);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return turkishQuestions;
    }

    public List<Question> queryGeographyQuestions() {
        List<Question> geographyQuestions = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "Select * from " + DBHelper.DB_TABLE + " where " + DBHelper.KEY_DERS + " = " +DBHelper.GEOGRAPHY;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestionClass(cursor.getInt(1));
                question.setQuestion(cursor.getString(2));
                question.setA(cursor.getString(3));
                question.setB(cursor.getString(4));
                question.setC(cursor.getString(5));
                question.setD(cursor.getString(6));
                question.setE(cursor.getString(7));
                question.setAnswer(cursor.getInt(8));
                geographyQuestions.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return geographyQuestions;
    }

    public List<Question> queryLawQuestions() {
        List<Question> lawQuestions = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "Select * from " + DBHelper.DB_TABLE + " where " + DBHelper.KEY_DERS + " = " + DBHelper.LAW;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestionClass(cursor.getInt(1));
                question.setQuestion(cursor.getString(2));
                question.setA(cursor.getString(3));
                question.setB(cursor.getString(4));
                question.setC(cursor.getString(5));
                question.setD(cursor.getString(6));
                question.setE(cursor.getString(7));
                question.setAnswer(cursor.getInt(8));
                lawQuestions.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lawQuestions;
    }


    class DBHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "KPSSQuizDB.db";
        private static final int DB_VERSION = 4;
        private static final String DB_TABLE = "questions";

        public static final String KEY_ROWID = "_id";
        public static final String KEY_DERS = "ders";
        public static final String KEY_SORU = "soru";
        public static final String KEY_A = "A";
        public static final String KEY_B = "B";
        public static final String KEY_C = "C";
        public static final String KEY_D = "D";
        public static final String KEY_E = "E";
        public static final String KEY_DOGRUCEVAP = "dogruCevap";
        public static final int HISTORY = 0;
        public static final int GEOGRAPHY = 1;
        public static final int LAW = 2;
        public static final int TURKISH = 3;
        public static final int MATH = 4;
        public static final int ANSWER_A = 0;
        public static final int ANSWER_B = 1;
        public static final int ANSWER_C = 2;
        public static final int ANSWER_D = 3;
        public static final int ANSWER_E = 4;

        private Context mContext;

        private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + DB_TABLE
                + " (" + KEY_ROWID + " integer primary key autoincrement, "
                + KEY_DERS + " integer null, "
                + KEY_SORU + " text not null, "
                + KEY_A + " text not null, "
                + KEY_B + " text not null, "
                + KEY_C + " text not null, "
                + KEY_D + " text not null, "
                + KEY_E + " text not null, "
                + KEY_DOGRUCEVAP + " integer not null);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+DB_TABLE;

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            mContext = context;

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
                Toast.makeText(mContext,"onCreate is called",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(mContext,""+e,Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(mContext,"onUpgrade is called",Toast.LENGTH_LONG).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Toast.makeText(mContext,""+e,Toast.LENGTH_LONG).show();
            }
        }

    }

}