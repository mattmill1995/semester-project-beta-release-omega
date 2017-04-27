package com.bignerdranch.android.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by morgan on 4/27/2017.
 */

public class VictoryScreen extends AppCompatActivity {

    TextView team_1_score, team_2_score, victory_display;
    protected void onCreate(Bundle savedInstanceState){
        Bundle extras = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victory_screen);

        team_1_score = (TextView) findViewById(R.id.team_1_score_view);
        team_2_score = (TextView) findViewById(R.id.team_2_score_view);
        victory_display = (TextView) findViewById(R.id.team_won);

        team_1_score.setText(extras.getInt("team1score"));
    }
}
