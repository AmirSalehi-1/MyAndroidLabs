package com.example.cst2335;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst2335.databinding.ActivityMainBinding;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        ImageButton myImagebutton= variableBinding.myimagebutton;
        myImagebutton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                int width = v.getWidth();
                int height = v.getHeight();
                Toast.makeText(MainActivity.this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();

            }
        });

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        TextView mytext = variableBinding.textview;
        Button button = variableBinding.mybutton;
        EditText myedit = variableBinding.myedittext;
        ImageView mylogo = variableBinding.mylogo;

    variableBinding.mybutton.setOnClickListener(click->{
    viewModel.editString.postValue(variableBinding.myedittext.getText().toString());
});
    viewModel.editString.observe(this,s -> { variableBinding.textview.setText("You write here: "+s);});

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextContent = myedit.getText().toString();
                mytext.setText("Your edit text has : " + editTextContent);
            }
        });/*
         */
        viewModel.getIsSelected().observe(this, selected -> {
            variableBinding.mycheckbox.setChecked((Boolean) selected);
            variableBinding.myradioButton.setChecked((Boolean) selected);
            variableBinding.myswitch.setChecked((Boolean) selected);
            Toast.makeText(MainActivity.this, "The value is now: " + selected, Toast.LENGTH_SHORT).show();
        });

        variableBinding.mycheckbox.setOnCheckedChangeListener((btn, isChecked) -> viewModel.setIsSelected(isChecked));
        variableBinding.myradioButton.setOnCheckedChangeListener((btn, isChecked) -> viewModel.setIsSelected(isChecked));
        variableBinding.myswitch.setOnCheckedChangeListener((btn, isChecked) -> viewModel.setIsSelected(isChecked));
    }
}
