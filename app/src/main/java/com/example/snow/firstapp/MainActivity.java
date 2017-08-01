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
import java.util.Random;
public class MainActivity extends AppCompatActivity {


    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    TextView answer, question;
    EditText editQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        answer = (TextView) findViewById(R.id.answer);

        Button ask = (Button) findViewById(R.id.askQuestion);
        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random a = new Random();
                if (a.nextBoolean()){
                    answer.setText("Yes");
                }else {
                    answer.setText("No");
                }

            }
        });

        question = (TextView) findViewById(R.id.question);
        editQuestion = (EditText) findViewById(R.id.changeQuestion);
        Button submitQ = (Button) findViewById(R.id.submitQ);
        submitQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q = editQuestion.getText().toString();
                question.setText(q);
            }
        });









    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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

            case R.id.myQuestion:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                answer = (TextView) findViewById(R.id.question);
                answer.setText("heelo?");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}
