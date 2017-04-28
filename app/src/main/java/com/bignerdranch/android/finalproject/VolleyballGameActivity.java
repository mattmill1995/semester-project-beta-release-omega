package com.bignerdranch.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class VolleyballGameActivity extends AppCompatActivity{

    Button Team1Score_Button, Team2Score_Button, SaveGame_Button, MainMenu_Button, SetClock_Button, Reset_Button, SetScore_Button, Undo_Button;
    int team1Score = 0, team2Score = 0, team1Wins = 0, team2Wins = 0;
    TextView team_1_score, team_2_score, team_1_wins, team_2_wins;
    boolean team1_flag = false, team2_flag = false;
    String result;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volleyball_game);

        // wire up the buttons
        Team1Score_Button = (Button) findViewById(R.id.team_1_score_button_1);
        Team2Score_Button = (Button) findViewById(R.id.team_2_score_button_1);
        SaveGame_Button = (Button) findViewById(R.id.save_game_button);
        MainMenu_Button = (Button) findViewById(R.id.main_menu_button);
        SetClock_Button = (Button) findViewById(R.id.set_clock_button);
        Reset_Button = (Button) findViewById(R.id.reset_button);
        SetScore_Button = (Button) findViewById(R.id.set_score_button);
        Undo_Button = (Button) findViewById(R.id.undo_button);

        // wire up the text views
        team_1_score = (TextView) findViewById(R.id.team_1_score_view);
        team_2_score = (TextView) findViewById(R.id.team_2_score_view);
        team_1_wins = (TextView) findViewById(R.id.team_1_wins);
        team_2_wins = (TextView) findViewById(R.id.team_2_wins);


        //display initial score
        updateScore();



        // Make the buttons do stuff
        MainMenu_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolleyballGameActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        Team1Score_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team1Score++;
                team1_flag = true;
                team2_flag = false;
                updateScore();

               checkScores();
            }
        });

        Team2Score_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team2Score++;
                team1_flag = false;
                team2_flag = true;
                updateScore();

                checkScores();
            }
        });

        Reset_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team1Score = 0;
                team2Score = 0;
                team1Wins = 0;
                team2Wins = 0;
                updateScore();


            }
        });

        Undo_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(team1_flag){
                    if(team1Score > 0){
                        team1Score--;
                        updateScore();
                        team1_flag = false;
                        team2_flag = false;
                    }
                } else if (team2_flag){
                    if(team2Score > 0) {
                        team2Score--;
                        updateScore();
                        team1_flag = false;
                        team2_flag = false;
                    }
                }
            }
        });

        team_1_wins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1Wins++;
                checkScores();
                team1Score = 0;
                team2Score = 0;
                updateScore();
            }
        });

        team_2_wins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2Wins++;
                checkScores();
                team1Score = 0;
                team2Score = 0;
                updateScore();
            }
        });


    }

    void updateScore() {
        team_1_score.setText(""+team1Score);
        team_2_score.setText(""+team2Score);
        team_2_wins.setText(""+team2Wins);
        team_1_wins.setText(""+team1Wins);
    }

    void checkScores() {
        if (team1Score >= team2Score && team1Score >= 15){
            team1Wins++;
            updateScore();
            Reset_Button.callOnClick();
        }

        if (team2Score >= team1Score && team2Score >= 15){
            team2Wins++;
            updateScore();
            Reset_Button.callOnClick();
        }

        if (team1Wins >= 3 || team2Wins >=3){
            Bundle values = new Bundle();
            values.putInt("team1score", team1Wins);
            values.putInt("team2score", team2Wins);
            Reset_Button.callOnClick();
            team1Wins = 0;
            team2Wins = 0;
            updateScore();

            Intent intent = new Intent(getBaseContext(), VictoryScreen.class);
            intent.putExtras(values);
            startActivity(intent);
        }
    }





}
