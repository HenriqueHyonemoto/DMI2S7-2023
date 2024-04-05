package com.example.h_tratamentodeeventos1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.contentIntent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton btn = (ImageButon)findViewById(R.id.imageButton2);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                mostraMensagem();
            }
        });
        EditText et = (EditText)findViewById(R.id.campoRegiao);
        et.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostraMensagem();
            }
        })
    }
}
