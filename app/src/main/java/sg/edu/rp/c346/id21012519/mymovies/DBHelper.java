package sg.edu.rp.c346.id21012519.mymovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Movie List.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_MOVIE = "movie";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "Title";
    private static final String COLUMN_GENRE = "Genre";
    private static final String COLUMN_YEAR = "Year";
    private static final String COLUMN_RATING = "Rating";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_MOVIE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_GENRE + " TEXT2,"
                + COLUMN_YEAR + " TEXT3,"
                + COLUMN_RATING + " INTEGER )";
        db.execSQL(createNoteTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_MOVIE + " ADD COLUMN  module_name TEXT ");
        db.execSQL("ALTER TABLE " + TABLE_MOVIE + " ADD COLUMN  module_name TEXT2 ");
        db.execSQL("ALTER TABLE " + TABLE_MOVIE + " ADD COLUMN  module_name TEXT3 ");
        db.execSQL("ALTER TABLE " + TABLE_MOVIE + " ADD COLUMN  module_name TEXT4 ");
    }

    public long insertNote(String noteContent, String noteContent2, int noteContent3, String noteContent4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, noteContent);
        values.put(COLUMN_GENRE, noteContent2);
        values.put(COLUMN_YEAR, noteContent3);
        values.put(COLUMN_RATING, noteContent4);
        long result = db.insert(TABLE_MOVIE, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result);
        return result;
    }
    public ArrayList<Movies> getAllNotes() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE,COLUMN_YEAR, COLUMN_RATING};
        Cursor cursor = db.query(TABLE_MOVIE, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }

    public ArrayList<Movies> getRatedG() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        String condition = COLUMN_RATING + " Like ?";
        String[] args = {"G"};
        Cursor cursor = db.query(TABLE_MOVIE, columns, condition, args,null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public ArrayList<Movies> getRatedPG() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        String condition = COLUMN_RATING + " Like ?";
        String[] args = {"PG"};
        Cursor cursor = db.query(TABLE_MOVIE, columns, condition, args,null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public ArrayList<Movies> getRatedPG13() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        String condition = COLUMN_RATING + " Like ?";
        String[] args = {"PG13"};
        Cursor cursor = db.query(TABLE_MOVIE, columns, condition, args,null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public ArrayList<Movies> getRatedNC16() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        String condition = COLUMN_RATING + " Like ?";
        String[] args = {"NC16"};
        Cursor cursor = db.query(TABLE_MOVIE, columns, condition, args,null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public ArrayList<Movies> getRatedM18() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        String condition = COLUMN_RATING + " Like ?";
        String[] args = {"M18"};
        Cursor cursor = db.query(TABLE_MOVIE, columns, condition, args,null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public ArrayList<Movies> getRatedR21() {
        ArrayList<Movies> notes = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        String condition = COLUMN_RATING + " Like ?";
        String[] args = {"R21"};
        Cursor cursor = db.query(TABLE_MOVIE, columns, condition, args,null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String noteContent = cursor.getString(1);
                String noteContent2 = cursor.getString(2);
                int noteContent3 = cursor.getInt(3);
                String noteContent4 = cursor.getString(4);
                Movies note = new Movies(id, noteContent, noteContent2, noteContent3, noteContent4);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }
    public int updateMovie(Movies data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, data.getTitle());
        values.put(COLUMN_GENRE , data.getGenre());
        values.put(COLUMN_YEAR , data.getYear());
        values.put(COLUMN_RATING , data.getRating());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_MOVIE, values, condition, args);
        db.close();
        return result;
    }
    public int deleteMovie(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_MOVIE, condition, args);
        db.close();
        return result;
    }
}
