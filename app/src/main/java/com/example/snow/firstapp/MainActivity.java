package com.example.snow.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
public class MainActivity extends AppCompatActivity {


    private LinearLayout mLayout;
    private EditText mEditText;
    private Button ask,submitQ, add, clear, history;
    private TextView answer, question;
    private EditText editQuestion, addItems;
    private ArrayList items;
    SQLiteHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        action();

    }

    public void init(){
        items = new ArrayList();
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
        history = (Button)findViewById(R.id.addHistory);

        myDb = new SQLiteHelper(this);
    }

    public void action(){
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
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=myDb.getallQuestions();
                if (res.getCount() == 8) {
                    myDb.deleteFirst();
                }

                String listString = TextUtils.join(",", items);
                myDb.insertQuestion(question.getText().toString(), listString);
                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
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
                myDb.deleteDB();
                return true;

            case R.id.history:
                Intent intent = new Intent(MainActivity.this, history.class);
                startActivity(intent);
                return true;
            case R.id.customize:
                if (toogle){
                    submitQ.setVisibility(View.GONE);
                    add.setVisibility(View.GONE);
                    clear.setVisibility(View.GONE);
                    editQuestion.setVisibility(View.GONE);
                    addItems.setVisibility(View.GONE);
                    toogle = false;
                }else{
                    submitQ.setVisibility(View.VISIBLE);
                    add.setVisibility(View.VISIBLE);
                    clear.setVisibility(View.VISIBLE);
                    editQuestion.setVisibility(View.VISIBLE);
                    addItems.setVisibility(View.VISIBLE);
                    toogle = true;
                }

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}
