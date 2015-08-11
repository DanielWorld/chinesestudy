package com.danielworld.chinesestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.danielworld.chinesestudy.model.ChineseData;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class StudyListActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    // Decide to exit the application or not.
    private boolean isBackKeyPressed = false;
    // Is no more showing toast message?
    private boolean isNoMoreToast = false;
    private Toast warningToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studylist);

        warningToast = Toast.makeText(this, "Press one more time to exit", Toast.LENGTH_SHORT);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

        for(int i=0; i < ChineseData.totalChapterCount; i++) {
            mAdapter.add("Chapter " + i);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(StudyListActivity.this, MainActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(isBackKeyPressed){
            warningToast.cancel();
            isNoMoreToast = true;
            super.onBackPressed();
        }

        isBackKeyPressed = true;

        if(!isNoMoreToast)
            warningToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isBackKeyPressed = false;
            }
        }, 2000);
    }
}
