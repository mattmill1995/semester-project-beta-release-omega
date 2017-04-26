package com.bignerdranch.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class BaseballGameActivity extends AppCompatActivity{

    Button Team1Score_Button, Team2Score_Button, SaveGame_Button, MainMenu_Button, SetClock_Button, Reset_Button, SetScore_Button, Undo_Button;
    int team1Score = 0, team2Score = 0, strikes = 0, balls = 0, outs = 0;
    TextView team_1_score, team_2_score, clock_view, outs_view, balls_view, strikes_view, balls_title, strikes_title, outs_title;
    boolean team1_flag = false, team2_flag = false, clock_Start = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_game);

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
        clock_view = (TextView) findViewById(R.id.timer);
        outs_view = (TextView) findViewById(R.id.outs_indicator);
        balls_view = (TextView) findViewById(R.id.balls_indicator);
        strikes_view = (TextView) findViewById(R.id.strikes_indicator);
        balls_title = (TextView) findViewById(R.id.balls_title);
        strikes_title = (TextView) findViewById(R.id.strikes_title);
        outs_title = (TextView) findViewById(R.id.outs_title);

        //display initial score
        updateScore();

        // display outs, balls, and strikes
        outs_view.setText(""+outs);
        strikes_view.setText(""+strikes);
        balls_view.setText(""+balls);

        //display initial clock
        clock_view.setText("1 ↑");

        // Make the buttons do stuff
        MainMenu_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseballGameActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        Team1Score_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1Score++;
                team1_flag = true;
                team2_flag = false;
                updateScore();
            }
        });

        Team2Score_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2Score++;
                team1_flag = false;
                team2_flag = true;
                updateScore();
            }
        });

        Reset_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1Score = 0;
                team2Score = 0;
                updateScore();
                clock_view.setText("1 ↑");
                team_2_score.setVisibility(View.VISIBLE);
                team_1_score.setVisibility(View.VISIBLE);
            }
        });

        Undo_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team1_flag) {
                    if (team1Score > 0) {
                        team1Score--;
                        updateScore();
                        team1_flag = false;
                        team2_flag = false;
                    }
                } else if (team2_flag) {
                    if (team2Score > 0) {
                        team2Score--;
                        updateScore();
                        team1_flag = false;
                        team2_flag = false;
                    }
                }
            }
        });

        strikes_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strikes++;
                strikes_view.setText(""+strikes);
                if (strikes == 3){
                    outs++;
                    outs_view.setText(""+outs);
                    strikes = 0;
                    strikes_view.setText(""+strikes);
                }

                if (outs == 3){
                    updateClock();
                    outs = 0;
                    outs_view.setText(""+outs);
                }
            }
        });

        balls_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balls++;
                balls_view.setText(""+balls);

                if (balls == 4){
                    balls = 0;
                    strikes = 0;

                    balls_view.setText(""+balls);
                    strikes_view.setText(""+strikes);
                }
            }
        });

        outs_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outs++;
                strikes_view.setText(""+outs);

                if (outs == 3){
                    updateClock();
                    outs = 0;
                    outs_view.setText(""+outs);
                }
            }
        });

        clock_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateClock();
            }
        });
    }

    void updateScore() {
        team_1_score.setText(""+team1Score);
        team_2_score.setText(""+team2Score);
    }

    void updateClock(){
        switch (clock_view.getText().toString()){
            case "1 ↑": clock_view.setText("1 ↓");
                        break;
            case "1 ↓": clock_view.setText("2 ↑");
                break;
            case "2 ↑": clock_view.setText("2 ↓");
                break;
            case "2 ↓": clock_view.setText("3 ↑");
                break;
            case "3 ↑": clock_view.setText("3 ↓");
                break;
            case "3 ↓": clock_view.setText("4 ↑");
                break;
            case "4 ↑": clock_view.setText("4 ↓");
                break;
            case "4 ↓": clock_view.setText("5 ↑");
                break;
            case "5 ↑": clock_view.setText("5 ↓");
                break;
            case "5 ↓": clock_view.setText("6 ↑");
                break;
            case "6 ↑": clock_view.setText("6 ↓");
                break;
            case "6 ↓": clock_view.setText("7 ↑");
                break;
            case "7 ↑": clock_view.setText("7 ↓");
                break;
            case "7 ↓": clock_view.setText("8 ↑");
                break;
            case "8 ↑": clock_view.setText("8 ↓");
                break;
            case "8 ↓": clock_view.setText("9 ↑");
                break;
            case "9 ↑": clock_view.setText("9 ↓");
                break;
            case "9 ↓": clock_view.setText("GAME OVER");
                team_1_score.setVisibility(View.INVISIBLE);
                team_2_score.setVisibility(View.INVISIBLE);
                break;
        }
    }



}
