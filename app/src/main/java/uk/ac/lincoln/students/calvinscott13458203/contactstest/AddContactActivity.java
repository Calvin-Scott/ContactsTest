package uk.ac.lincoln.students.calvinscott13458203.contactstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    String firstName;
    String lastName;
    String email;
    String mobile;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void SaveContacts(View view) {
        EditText firstNameInput = (EditText) findViewById(R.id.editTextFirstName);
        EditText lastNameInput = (EditText) findViewById(R.id.editTextLastName);
        EditText emailInput = (EditText) findViewById(R.id.editTextEmail);
        EditText mobileInput = (EditText) findViewById(R.id.editTextMobile);
        EditText addressInput = (EditText) findViewById(R.id.editTextAddress);

        firstName = firstNameInput.getText().toString();
        lastName = lastNameInput.getText().toString();
        email = emailInput.getText().toString();
        mobile = mobileInput.getText().toString();
        address = addressInput.getText().toString();

        DatabaseHandler db = new DatabaseHandler(this);

        db.addContact(new ContactsDB(firstName,lastName,email,mobile,address));

    }

}
