package uk.ac.lincoln.students.calvinscott13458203.contactstest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calvi_000 on 02/04/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contacts";

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME_ID = "contactsid";
    public static final String COLUMN_NAME_FIRSTNAME = "firstname";
    public static final String COLUMN_NAME_LASTNAME = "lastName";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_MOBILENUM = "mobilenumber";
    public static final String COLUMN_NAME_ADDRESS = "address";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + COLUMN_NAME_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_FIRSTNAME + "TEXT,"
                + COLUMN_NAME_LASTNAME + " TEXT," + COLUMN_NAME_EMAIL + "TEXT," +
                COLUMN_NAME_MOBILENUM + "TEXT," + COLUMN_NAME_ADDRESS+ "TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }

    // Adding new contact to the database
    /*TODO error at the moment table contacts has no column named lastName Error inserting lastName=Scott firstname=Calvin mobilenumber=0486 address=home email=calvin@email
      TODO android.database.sqlite.SQLiteException: table contacts has no column named lastName (code 1): , while compiling: INSERT INTO contacts
    */
    void addContact(ContactsDB contactsDB) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_FIRSTNAME, contactsDB.getFirstName());
        values.put(COLUMN_NAME_LASTNAME, contactsDB.getLastName());
        values.put(COLUMN_NAME_EMAIL, contactsDB.getEmail());
        values.put(COLUMN_NAME_ADDRESS, contactsDB.getAddress());
        values.put(COLUMN_NAME_MOBILENUM, contactsDB.getMobileNumber());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // fetch all names of contacts and add them to a list
    public List<ContactsDB> getAllNames()
    {
        List<ContactsDB> namesList = new ArrayList<>();

        String selectAllNamesQuery = "SELECT" + COLUMN_NAME_FIRSTNAME + "FROM" + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectAllNamesQuery, null);

        if (cursor.moveToFirst())
        {
            do
            {
             ContactsDB contactsDB = new ContactsDB();
                contactsDB.setfirstName(cursor.getString(1));
                namesList.add(contactsDB);
            }while (cursor.moveToNext());
        }

        return namesList;
    }


}
