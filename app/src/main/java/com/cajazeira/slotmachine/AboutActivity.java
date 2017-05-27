package com.cajazeira.slotmachine;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView t;

    public void voltarTelaMenu(View view) {
    finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        t=(TextView) findViewById(R.id.text);
        Typeface minhafonte5=Typeface.createFromAsset(getAssets(),"fonts/dancing_in_the_rainbow.ttf");
        t.setTypeface(minhafonte5);

        t=(TextView) findViewById(R.id.version);
        Typeface minhafonte6=Typeface.createFromAsset(getAssets(),"fonts/dancing_in_the_rainbow.ttf");
        t.setTypeface(minhafonte6);

        t=(TextView) findViewById(R.id.see);
        Typeface minhafonte7=Typeface.createFromAsset(getAssets(),"fonts/dancing_in_the_rainbow.ttf");
        t.setTypeface(minhafonte7);

        t=(TextView) findViewById(R.id.name);
        Typeface minhafonte8=Typeface.createFromAsset(getAssets(),"fonts/dancing_in_the_rainbow.ttf");
        t.setTypeface(minhafonte8);

    }
}

