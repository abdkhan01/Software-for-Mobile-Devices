package com.example.dell.assignment2;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {


    private TextView tv;
    private Button RButton;
    private Button CButton;

    public Button ButtonToR;
    public CheckBox cbR;
    public EditText EmailR;
    public EditText PassR;
    public RadioGroup radioGroupR;
    public RadioButton RadioButtonR;

    public Button ButtonToC;
    public CheckBox cbC;
    public EditText EmailC;
    public EditText PassC;
    public RadioGroup radioGroupC;
    public RadioButton RadioButtonC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);

        RButton = (Button)findViewById(R.id.button3);
        CButton = (Button)findViewById(R.id.button4);


        RButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.signup_relative);

                ButtonToR = (Button) findViewById(R.id.button);
                cbR = (CheckBox) findViewById(R.id.checkBox);
                radioGroupR = (RadioGroup)findViewById(R.id.radioGroup1);
                EmailR = (EditText) findViewById(R.id.editText);
                PassR = (EditText) findViewById(R.id.editText2);

                ButtonToR.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if(cbR.isChecked()) {

                            if(radioGroupR.getCheckedRadioButtonId()== -1)
                            {
                                Toast.makeText(MainActivity.this, "Please select Gender", Toast.LENGTH_SHORT).show();
                            }
                            else if  (EmailR.getText().toString().trim().length() == 0){
                                Toast.makeText(MainActivity.this, "Please input email", Toast.LENGTH_SHORT).show();

                            }
                            else if  (PassR.getText().toString().trim().length() == 0){
                                Toast.makeText(MainActivity.this, "Please input password", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                // get selected radio button from radioGroup
                                int selectedId = radioGroupR.getCheckedRadioButtonId();
                                // find the radiobutton by returned id
                                RadioButtonR = (RadioButton)findViewById(selectedId);
                                Toast.makeText(MainActivity.this,
                                        tv.getText().toString()+" Email:"+
                                                EmailR.getText().toString()+" Password:"+
                                                PassR.getText().toString()+" "+
                                                RadioButtonR.getText().toString()+" "+
                                        cbR.getText().toString()+" checked!", Toast.LENGTH_LONG).show();
                            }

                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please select terms and conditions", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        CButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.signup_constraint);

                ButtonToC = (Button) findViewById(R.id.button2);
                cbC = (CheckBox) findViewById(R.id.checkBox2);
                radioGroupC = (RadioGroup)findViewById(R.id.radioGroup);
                EmailC = (EditText) findViewById(R.id.editText3);
                PassC = (EditText) findViewById(R.id.editText4);

                ButtonToC.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if(cbC.isChecked()) {

                            if(radioGroupC.getCheckedRadioButtonId()== -1)
                            {
                                Toast.makeText(MainActivity.this, "Please select Gender", Toast.LENGTH_SHORT).show();
                            }
                            else if  (EmailC.getText().toString().trim().length() == 0){
                                Toast.makeText(MainActivity.this, "Please input email", Toast.LENGTH_SHORT).show();

                            }
                            else if  (PassC.getText().toString().trim().length() == 0){
                                Toast.makeText(MainActivity.this, "Please input password", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                // get selected radio button from radioGroup
                                int selectedId = radioGroupC.getCheckedRadioButtonId();
                                // find the radiobutton by returned id
                                RadioButtonC = (RadioButton)findViewById(selectedId);
                                Toast.makeText(MainActivity.this,
                                        tv.getText().toString()+" Email:"+
                                                EmailC.getText().toString()+" Password:"+
                                                PassC.getText().toString()+" "+
                                                RadioButtonC.getText().toString()+" "+
                                                cbC.getText().toString()+" checked!", Toast.LENGTH_LONG).show();
                            }

                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please select terms and conditions", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });




    }
}
