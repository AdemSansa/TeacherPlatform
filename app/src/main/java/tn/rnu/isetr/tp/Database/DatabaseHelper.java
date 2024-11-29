package tn.rnu.isetr.tp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Info
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 2;

    // Table Names
    public static final String TABLE_COURS = "Cours";
    public static final String TABLE_TEACHER = "Teacher";
    public static final String TABLE_USER = "User";


    //User Table
    public static final String COLUMN_USER_ID = "_id";
    public static final String COLUMN_USER_NAME = "name";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PASSWORD = "password";

    // Columns for "Cours" Table
    public static final String COLUMN_COURS_ID = "_id";
    public static final String COLUMN_COURS_NAME = "name";
    public static final String COLUMN_COURS_NB_HEURE = "nbheure";
    public static final String COLUMN_COURS_TYPE = "type";
    public static final String COLUMN_COURS_ENSEIG_ID = "enseign_id";

    // Columns for "Teacher" Table
    public static final String COLUMN_TEACHER_ID = "_id";
    public static final String COLUMN_TEACHER_NAME = "name";
    public static final String COLUMN_TEACHER_EMAIL = "email";

    // Create "Cours" Table SQL
    private static final String CREATE_TABLE_COURS =
            "CREATE TABLE " + TABLE_COURS + " (" +
                    COLUMN_COURS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_COURS_NAME + " TEXT NOT NULL, " +
                    COLUMN_COURS_NB_HEURE + " REAL NOT NULL, " +
                    COLUMN_COURS_TYPE + " TEXT NOT NULL, " +
                    COLUMN_COURS_ENSEIG_ID + " TEXT NOT NULL)";

    // Create "Teacher" Table SQL
    private static final String CREATE_TABLE_TEACHER =
            "CREATE TABLE " + TABLE_TEACHER + " (" +
                    COLUMN_TEACHER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TEACHER_NAME + " TEXT NOT NULL, " +
                    COLUMN_TEACHER_EMAIL + " TEXT)";
    // Create User Table
    private static final String CREATE_TABLE_USER =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_NAME + " TEXT NOT NULL, " +
                    COLUMN_USER_EMAIL + " TEXT NOT NULL, " +
                    COLUMN_USER_PASSWORD + " TEXT NOT NULL)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Tables
        db.execSQL(CREATE_TABLE_COURS);
        db.execSQL(CREATE_TABLE_TEACHER);
        db.execSQL(CREATE_TABLE_USER);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        onCreate(db);
    }
}