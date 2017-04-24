package com.bignerdranch.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class GameSelectActivity extends AppCompatActivity {

    //button declarations
    Button mFootball, mBaseball, mBasketball, mUltimate, mVolleyball, mSoccer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_select);

        mFootball = (Button) findViewById(R.id.football_btn);
        mFootball.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FootballGameActivity.class);
                startActivity(intent);
            }
        });

        mBaseball = (Button) findViewById(R.id.baseball_btn);
        mBaseball.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameSelectActivity.this, BaseballGameActivity.class);
                startActivity(intent);
            }
        });

        mBasketball = (Button) findViewById(R.id.basketball_btn);
        mBasketball.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameSelectActivity.this, BasketballGameActivity.class);
                startActivity(intent);
            }
        });

        mUltimate = (Button) findViewById(R.id.ultimate_btn);
        mUltimate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameSelectActivity.this, UltimateGameActivity.class);
                startActivity(intent);
            }
        });

        mVolleyball = (Button) findViewById(R.id.volleyball_btn);
        mVolleyball.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameSelectActivity.this, VolleyballGameActivity.class);
                startActivity(intent);
            }
        });

        mSoccer = (Button) findViewById(R.id.soccer_btn);
        mSoccer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameSelectActivity.this, SoccerGameActivity.class);
                startActivity(intent);
            }
        });
    }}
