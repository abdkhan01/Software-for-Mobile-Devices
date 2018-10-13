 package com.example.dell.datastorage;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

 public class MainActivity extends AppCompatActivity {


    private AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-contacts")
            .allowMainThreadQueries()   //Allows room to do operation on main thread
            .build();
    public Button insertBtn;
    public Button viewBtn;
    public Button updateBtn;
    private ContactDAO c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = database.getContactDAO();


        insertBtn =  findViewById(R.id.button);

        viewBtn = (Button) findViewById(R.id.button2);

        updateBtn = (Button) findViewById(R.id.button3);


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                List<Contact> l = c.getAllContacts();

                if(l.size()==0){
                    for(int i=0;i<l.size();i++){
                        c.delete(l.get(i));
                    }
                }


                //Inserting a contact
                Contact contact = new Contact();
                contact.setFirstName("Abdullah");
                contact.setLastName("Khan");
                contact.setPhoneNumber("1234567890");

                c.insert(contact);
                Toast.makeText(getApplicationContext(),"Dummy Contact Added", Toast.LENGTH_LONG).show();


            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ViewContact.class);
                MainActivity.this.startActivity(myIntent);

            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(MainActivity.this, UpdateContact.class);
                MainActivity.this.startActivity(myIntent2);
            }
        });



        }
}
