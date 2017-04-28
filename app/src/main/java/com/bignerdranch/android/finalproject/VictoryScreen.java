package com.bignerdranch.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by morgan on 4/27/2017.
 */

public class VictoryScreen extends AppCompatActivity {

    TextView team_1_score, team_2_score, victory_display;

    Button newGameButton, mainMenuButton, replayButton;
    protected void onCreate(Bundle savedInstanceState){
        Intent i = getIntent();
        Bundle values = i.getExtras();
        int score1;
        int score2;



        super.onCreate(savedInstanceState);
        setContentView(R.layout.victory_screen);

        //textview declarations
        team_1_score = (TextView) findViewById(R.id.team_1_score_view);
        team_2_score = (TextView) findViewById(R.id.team_2_score_view);
        victory_display = (TextView) findViewById(R.id.team_won);

        //button declarations
        newGameButton = (Button) findViewById(R.id.new_game_btn);
        mainMenuButton = (Button) findViewById(R.id.main_menu_button);
        replayButton = (Button) findViewById(R.id.replay_button);

        //retrieves and sets team scores
        score1 = values.getInt("team1score");
        team_1_score.setText(""+score1);

        score2 = values.getInt("team2score");
        team_2_score.setText(""+score2);

        //determines winner output
        if (score1 > score2){
            victory_display.setText("Team 1 Won!");
        } else if (score1 == score2){
            victory_display.setText("Its a Tie!");
        } else {
            victory_display.setText("Team 2 Won!");
        }

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VictoryScreen.this, GameSelectActivity.class);
                startActivity(intent);
            }
        });

        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VictoryScreen.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
