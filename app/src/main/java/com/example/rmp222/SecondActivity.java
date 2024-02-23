package com.example.rmp222;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_second);
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);
        textView.setText("SecondActivity");
        setContentView(textView);


        Button button=new Button(this);
        button.setText("Вернуться");
        setContentView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Пустое намерение
                Intent resultIntent = new Intent();
                resultIntent.putExtra("key", "value");
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("hello").toString();
        textView.setText(name);


    }
}