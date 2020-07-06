import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper
{
    private static String DATABASE_CREATE;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DataBaseHelper.DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int _oldVersion, int _newVersion)
    {

        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");


        db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");

        onCreate(db);
    }

}

