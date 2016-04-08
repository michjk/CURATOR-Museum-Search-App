package com.cz2006.curator.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import com.cz2006.curator.Constants.ExhibitionConstants;
import com.cz2006.curator.R;

public class MuseumProfileUI extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.cz2006.curator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_profile_ui);

        String museumName = getIntent().getStringExtra(EXTRA_MESSAGE);
        TextView title = (TextView) findViewById(R.id.museum_name);
        title.setText(museumName);

        ExhibitionConstants.setExhibitionConstants(this);

    }

    public void onClickExhibition(View view) {
        // listener for the Exhibition button



        Intent intent = new Intent(this, ExhibitionUI.class);
        String message = "Singapore Art Museum";
        // this message means nothing for now
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
