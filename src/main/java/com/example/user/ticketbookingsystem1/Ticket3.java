package com.example.user.ticketbookingsystem1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;



public class Ticket3 {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "LOGIN" +
            "( " + "ID" + " integer primary key autoincrement," + "USERNAME  text,PASSWORD text); ";
    public static String DataBase_CREATE;
    public SQLiteDatabase db;
    private final Context context;
    private static DataBaseHelper dbHelper;

    public Ticket3(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public Ticket3 open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String a, String b) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", a);
        newValues.put("PASSWORD", b);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
    }

    public String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
}

