package com.cajazeira.slotmachine;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    public void irTelaPlay(View view){

        Intent intent1 = new Intent(getApplicationContext(),MaquinaActivity.class);

        startActivity(intent1);


    }



    public void irTelaAbout(View view){

        Intent intent2 = new Intent(getApplicationContext(),AboutActivity.class);

        startActivity(intent2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
