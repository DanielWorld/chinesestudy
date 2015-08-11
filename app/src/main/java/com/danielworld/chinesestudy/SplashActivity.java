package com.danielworld.chinesestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p/>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class SplashActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        storeData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, StudyListActivity.class));
                finish();
            }
        }, 1000);
    }

    // store data to database
    private void storeData(){

    }
}
