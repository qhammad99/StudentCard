package pk.edu.uiit.arid_2471.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String  db_name = "firstDatabase";
    private static final String table_name = "student";
    private static final int db_ver=1;

    public DatabaseHelper(Context context){
        super(context, db_name, null, db_ver);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE IF NOT EXISTS " + table_name +
                "( st_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,mail VARCHAR, phone VARCHAR, password VARCHAR)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }

    public long insertion(String name, String mail, String ph, String pass){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mail", mail);
        contentValues.put("phone", ph);
        contentValues.put("password", pass);
        long detail=db.insert(table_name, null, contentValues);
        return detail;
    }

    public Cursor login(String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor user_data = sqLiteDatabase.rawQuery("SELECT name, mail, phone from " + table_name + " WHERE mail='" + email + "'" + "AND password ='" + password + "'", null);
        return user_data;
    }

}
