package com.example.cst2335;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cst2335.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        TextView mytext =   variableBinding.textview;
        Button Button = variableBinding.mybutton;
        EditText myedit = variableBinding.myedittext;

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextContent = myedit.getText().toString();
                mytext.setText("Your edit text has : " + editTextContent);
            }
        });
    }
}