package com.example.snow.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Snow on 10-Aug-2017.
 */

public class history extends AppCompatActivity{

    private Button h1,h2,h3,h4,h5,h6,h7,h8;
    private Button historyButtons[];
    private TextView answer, question;
    SQLiteHelper myDb;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.history);
            init();
            setHistory();
            action();
        }

    private void action() {
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h1.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });
        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h2.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h3.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });
        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h4.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });
        h5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h5.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });
        h6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h6.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });
        h7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h7.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });
        h8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String data = h8.getText().toString();
                intent.putExtra("qNa", data);
                setResult(RESULT_OK, intent);
                if (!data.equals("?")) finish();
            }
        });

    }


    public void init(){
        h1 = (Button) findViewById(R.id.h1);
        h2 = (Button) findViewById(R.id.h2);
        h3 = (Button) findViewById(R.id.h3);
        h4 = (Button) findViewById(R.id.h4);
        h5 = (Button) findViewById(R.id.h5);
        h6 = (Button) findViewById(R.id.h6);
        h7 = (Button) findViewById(R.id.h7);
        h8 = (Button) findViewById(R.id.h8);

        historyButtons = new Button[]{h1,h2,h3,h4,h5,h6,h7,h8};
        answer = (TextView) findViewById(R.id.answer);
        question = (TextView) findViewById(R.id.question);

    }

    public void setHistory(){

        myDb = new SQLiteHelper(this);
        Cursor res=myDb.getallQuestions();
        if (res.getCount() == 0) return;
        res.moveToLast();
        int i= 0;
        do{
            historyButtons[i].setText(res.getString(1)+"\n"+res.getString(2));
            i++;
        }
        while(res.moveToPrevious());


    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.history_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.history:
                    finish();
                    return true;

                default:
                    // If we got here, the user's action was not recognized.
                    // Invoke the superclass to handle it.
                    return super.onOptionsItemSelected(item);


            }
        }


}
