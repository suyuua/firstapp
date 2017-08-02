package com.example.snow.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
public class MainActivity extends AppCompatActivity {


    private LinearLayout mLayout;
    private EditText mEditText;
    private Button ask,submitQ, add, clear;
    TextView answer, question;
    EditText editQuestion, addItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList items = new ArrayList();
        items.add("Yes");
        items.add("No");

        answer = (TextView) findViewById(R.id.answer);
        question = (TextView) findViewById(R.id.question);
        ask = (Button) findViewById(R.id.askQuestion);
        submitQ = (Button) findViewById(R.id.submitQ);
        add = (Button) findViewById(R.id.addItems);
        clear = (Button) findViewById(R.id.clear);
        editQuestion = (EditText) findViewById(R.id.changeQuestion);
        addItems = (EditText) findViewById(R.id.items);

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(items.get((new Random()).nextInt(items.size())).toString());
            }
        });



        submitQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q = editQuestion.getText().toString();
                question.setText(q);
            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = addItems.getText().toString();
                items.add(item);
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.clear();
                items.add("Yes");
                items.add("No");
            }
        });





    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    boolean toogle = false;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.resetQuestion:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                question = (TextView) findViewById(R.id.question);
                return true;

            case R.id.customize:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...


                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}
