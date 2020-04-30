package com.ipolo.a1_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText email;
    private Button subscribe;
    private Button clean;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        subscribe = findViewById(R.id.buttonSubscribe);
        result = findViewById(R.id.textViewResult);
        clean = findViewById(R.id.buttonClean);
        subscribe.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (userName.getText().length() == 0 || email.getText().length() == 0) {
                    result.setText(getString(R.string.subscribe_error));
                    result.setTextColor(Color.RED);
                } else {
                    result.setText(getString(R.string.subscribe_done, userName.getText(), email.getText()));
                    result.setTextColor(Color.BLACK);
                }
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                userName.getText().clear();
                email.getText().clear();
            }
        });
    }
}
