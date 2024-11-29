package tn.rnu.isetr.tp.Database;

import static tn.rnu.isetr.tp.Database.DatabaseHelper.COLUMN_TEACHER_EMAIL;
import static tn.rnu.isetr.tp.Database.DatabaseHelper.COLUMN_USER_EMAIL;
import static tn.rnu.isetr.tp.Database.DatabaseHelper.COLUMN_USER_NAME;
import static tn.rnu.isetr.tp.Database.DatabaseHelper.COLUMN_USER_PASSWORD;
import static tn.rnu.isetr.tp.Database.DatabaseHelper.TABLE_USER;
import static tn.rnu.isetr.tp.Database.DatabaseHelper.COLUMN_TEACHER_ID;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context){
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();

    }
    // Insert a Teacher
    public void insertTeacher(String name, String email) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TEACHER_NAME, name);
        values.put(DatabaseHelper.COLUMN_TEACHER_EMAIL, email);
        database.insert(DatabaseHelper.TABLE_TEACHER, null, values);
    }
    // Insert a Course
    public void insertCourse(String name, double nbHeure, String type, String enseigId) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_COURS_NAME, name);
        values.put(DatabaseHelper.COLUMN_COURS_NB_HEURE, nbHeure);
        values.put(DatabaseHelper.COLUMN_COURS_TYPE, type);
        values.put(DatabaseHelper.COLUMN_COURS_ENSEIG_ID, enseigId);
        database.insert(DatabaseHelper.TABLE_COURS, null, values);
    }
    public Cursor getAllTeachers() {
        return database.query(
                DatabaseHelper.TABLE_TEACHER, // Table
                null,                         // All columns
                null,                         // No WHERE clause
                null,                         // No WHERE args
                null,                         // No GROUP BY
                null,                         // No HAVING
                null                          // No ORDER BY
        );

    }
    //Insert a User
    public boolean insertUser(String name, String email, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, name);
        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_USER_PASSWORD, password);
        long result = db.insert(TABLE_USER, null, values);
        return result != -1;
    }
    //Get User by Email
    public Cursor  getUserByEmail(String email) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(TABLE_USER, null, COLUMN_USER_EMAIL + " = ?", new String[]{email}, null, null, null);
    }

    // Authenticate User
    public boolean authenticateUser(String email, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, null, COLUMN_USER_EMAIL + " = ? AND " + COLUMN_USER_PASSWORD + " = ?", new String[]{email, password}, null, null, null);
        boolean IsAuthenticated = cursor.getCount() > 0;
        cursor.close();
        return IsAuthenticated;
    }


    //Add teacher
    public void addTeacher(String name, String email) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TEACHER_NAME, name);
        values.put(DatabaseHelper.COLUMN_TEACHER_EMAIL, email);
        database.insert(DatabaseHelper.TABLE_TEACHER, null, values);
    }
    //Delete teacher
    public Boolean deleteTeacher(String email) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rows = db.delete(DatabaseHelper.TABLE_TEACHER, COLUMN_TEACHER_EMAIL + " = ?", new String[]{email});
        db.close();
        return rows > 0;

    }

    //Get all Courses
    public Cursor getAllCourses() {
        return database.query(
                DatabaseHelper.TABLE_COURS, // Table
                null,                         // All columns
                null,                         // No WHERE clause
                null,                         // No WHERE args
                null,                         // No GROUP BY
                null,                         // No HAVING
                null                          // No ORDER BY
        );
    }



}
