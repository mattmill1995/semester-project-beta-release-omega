package com.bignerdranch.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BasketballGameActivity extends AppCompatActivity{

    final int base_time = 6000;

    Button Team1Score1_Button, Team2Score1_Button, Team1Score2_Button, Team2Score2_Button, Team1Score3_Button, Team2Score3_Button, SaveGame_Button, MainMenu_Button, SetClock_Button, Reset_Button, SetScore_Button, Undo_Button;
    int team1Score = 0, team2Score = 0, clock_value = base_time, lastScore, shot_clock_value = 30000, half_number = 1;
    long minutes, seconds, current_clock_value;
    TextView team_1_score, team_2_score, clock_view, shotclock_view, quarter_view;
    boolean team1_flag = false, team2_flag = false, clock_Start = false, shot_clock_start = false;
    String result;

    CountDownTimer clock = new CountDownTimer(clock_value, 1000){

        public void onTick(long millRemaining){
            clock_view.setText(""+millRemaining/1000);
        }
        public void onFinish(){
            clock_view.setText("0:00");
        }
    };

    CountDownTimer shot_clock = new CountDownTimer(shot_clock_value, 1000) {
        @Override
        public void onTick(long millRemaining) {
            shotclock_view.setText(":"+millRemaining/1000);
        }

        @Override
        public void onFinish() {
            shotclock_view.setText(":30");
        }
    };

    void convertToTime(long totalSecs){
        double sec = (double) totalSecs;
        double double_seconds;
        minutes = (long) Math.floor(sec/60);
        double_seconds = (double) (sec/60 - Math.floor(sec/60)) * 60;
        double_seconds = Math.round(double_seconds);
        seconds = (long) double_seconds;
        seconds = seconds * 1;
    }

    String fixSecondDisplay(long seconds){
        if (seconds < 10) {
            result = "0";
        } else {
            result = "";
        }
        return result;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basketball_game);

        // wire up the buttons
        Team1Score1_Button = (Button) findViewById(R.id.team_1_score_button_1);
        Team2Score1_Button = (Button) findViewById(R.id.team_2_score_button_1);
        Team1Score2_Button = (Button) findViewById(R.id.team_1_score_button_2);
        Team2Score2_Button = (Button) findViewById(R.id.team_2_score_button_2);
        Team1Score3_Button = (Button) findViewById(R.id.team_1_score_button_3);
        Team2Score3_Button = (Button) findViewById(R.id.team_2_score_button_3);
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
        shotclock_view = (TextView) findViewById(R.id.shot_clock);
        quarter_view = (TextView) findViewById(R.id.half_indicator);

        //display initial score
        updateScore();

        //display initial clock
        clock_view.setText("10:00");
        shotclock_view.setText(":30");
        quarter_view.setText("1");

        // Make the buttons do stuff
        MainMenu_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasketballGameActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        Team1Score1_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team1Score++;
                team1_flag = true;
                team2_flag = false;
                lastScore = 1;
                updateScore();
            }
        });

        Team2Score1_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team2Score++;
                team1_flag = false;
                team2_flag = true;
                lastScore = 1;
                updateScore();
            }
        });

        Team1Score2_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team1Score = team1Score + 2;
                team1_flag = true;
                team2_flag = false;
                lastScore = 2;
                updateScore();
            }
        });

        Team2Score2_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team2Score = team2Score + 2;
                team1_flag = false;
                team2_flag = true;
                lastScore = 2;
                updateScore();
            }
        });

        Team1Score3_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team1Score = team1Score + 3;
                team1_flag = true;
                team2_flag = false;
                lastScore = 3;
                updateScore();
            }
        });

        Team2Score3_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team2Score = team2Score + 3;
                team1_flag = false;
                team2_flag = true;
                lastScore = 3;
                updateScore();
            }
        });

        Reset_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                team1Score = 0;
                team2Score = 0;
                updateScore();

                clock.cancel();
                clock_view.setText("10:00");
                clock_value = base_time;
                half_number = 1;
                quarter_view.setText(""+half_number);
                clock_Start = false;
            }
        });

        Undo_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(team1_flag){
                    if(team1Score > 0){
                        team1Score = team1Score - lastScore;
                        updateScore();
                        team1_flag = false;
                        team2_flag = false;
                    }
                } else if (team2_flag){
                    if(team2Score > 0) {
                        team2Score = team2Score - lastScore;
                        updateScore();
                        team1_flag = false;
                        team2_flag = false;
                    }
                }
            }
        });

        clock_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (clock_Start == false){
                    updateClock();
                    clock.start();
                    clock_Start = true;
                } else if (clock_Start == true){
                    clock_Start = false;
                    clock.cancel();
                    clock_value = (int) current_clock_value;
                    updateClock();
                }
            }
        });

        shotclock_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shot_clock_start == false) {
                    shot_clock.start();
                    shot_clock_start = true;
                } else if (shot_clock_start == true){
                    shot_clock.cancel();
                    shotclock_view.setText(":30");
                    shot_clock_start = false;
                }
            }});

        quarter_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                half_number = ((half_number)%4)+1;
                updateScore();
            }
        });
    }

    void updateScore() {
        team_1_score.setText(""+team1Score);
        team_2_score.setText(""+team2Score);
        quarter_view.setText(""+half_number);
    }

    void updateClock(){
        clock = new CountDownTimer(clock_value, 1000){

            public void onTick(long millRemaining){
                convertToTime(millRemaining/1000);
                String result = fixSecondDisplay(seconds);
                clock_view.setText(minutes + ":" + result + seconds);
                current_clock_value = millRemaining;
            }
            public void onFinish(){
                clock_view.setText("0:00");
                clock_value = base_time;
                clock_Start = false;
                if (half_number < 4){
                    half_number++;
                }
                else{
                    clock_view.setText("GAME OVER");
                }
                updateScore();
            }
        };
    }



}
