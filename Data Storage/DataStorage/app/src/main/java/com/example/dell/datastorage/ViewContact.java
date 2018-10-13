package com.example.dell.datastorage;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ViewContact extends AppCompatActivity {
    private AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-contacts")
            .allowMainThreadQueries()   //Allows room to do operation on main thread
            .build();

    private ContactDAO c;
    TextView fn;
    TextView ln;
    TextView pn;
    TextView hln;
    TextView hfn;
    TextView hpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        c = database.getContactDAO();

        fn = (TextView) findViewById(R.id.textView);

        ln = (TextView) findViewById(R.id.textView2);

        pn = (TextView) findViewById(R.id.textView3);

        hfn = (TextView) findViewById(R.id.textView4);

        hln = (TextView) findViewById(R.id.textView5);

        hpn =  (TextView) findViewById(R.id.textView6);

        hfn.setText("First Name:");
        hln.setText("Last Name:");
        hpn.setText("Phone Number:");

        List<Contact> buff = c.getAllContacts();

        fn.setText(buff.get(buff.size()-1).getFirstName());
        ln.setText(buff.get(buff.size()- 1).getLastName());
        pn.setText(buff.get(buff.size()- 1).getPhoneNumber());










    }
}
