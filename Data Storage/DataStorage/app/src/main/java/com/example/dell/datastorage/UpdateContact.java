package com.example.dell.datastorage;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateContact extends AppCompatActivity {
    private AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-contacts")
            .allowMainThreadQueries()   //Allows room to do operation on main thread
            .build();

    private ContactDAO c;

    EditText fn;
    EditText ln;
    EditText pn;
    Button uc;
    Contact temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        c = database.getContactDAO();


        fn = (EditText) findViewById(R.id.editText);
        ln = (EditText) findViewById(R.id.editText2);
        pn = (EditText) findViewById(R.id.editText4);
        uc = (Button)findViewById(R.id.button4);

        temp = new Contact();



        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fn.getText().toString().equals("") || ln.getText().toString().equals("") || pn.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Missing field", Toast.LENGTH_LONG).show();


                }
                else{
                    temp.setFirstName(fn.getText().toString());
                    temp.setLastName(ln.getText().toString());
                    temp.setPhoneNumber(pn.getText().toString());



                }

                if(c.getContact(pn.getText().toString())!=null){
                    c.update(temp);
                    Toast.makeText(getApplicationContext(),"Name updated", Toast.LENGTH_LONG).show();

                }
                else{
                    c.updatePhoneNumber(pn.getText().toString(),fn.getText().toString(),ln.getText().toString());
                    Toast.makeText(getApplicationContext(),"Phone Number Updated", Toast.LENGTH_LONG).show();






                }

            }
        });








    }
}
