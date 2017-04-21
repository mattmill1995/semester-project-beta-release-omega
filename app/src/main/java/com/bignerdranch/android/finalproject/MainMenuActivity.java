package com.bignerdranch.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainMenuActivity extends AppCompatActivity {

    //button declarations
    Button mQuickGameButton, mNewGameButton, mLoadGameButton, mAppSettingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mNewGameButton = (Button) findViewById(R.id.new_game_btn);
        mNewGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, GameSelectActivity.class);
                startActivity(intent);
            }
        });

        mQuickGameButton = (Button) findViewById(R.id.quick_game_btn);
        mQuickGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, QuickGameActivity.class);
                startActivity(intent);
            }
        });

        mLoadGameButton = (Button) findViewById(R.id.load_game_btn);
        mLoadGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, LoadGameActivity.class);
                startActivity(intent);
            }
        });

        mAppSettingsButton = (Button) findViewById(R.id.app_settings_btn);
        mAppSettingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, AppSettingsActivity.class);
                startActivity(intent);
            }
        });
}}
