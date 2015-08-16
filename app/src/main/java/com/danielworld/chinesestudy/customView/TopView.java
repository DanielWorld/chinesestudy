package com.danielworld.chinesestudy.customView;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.danielworld.chinesestudy.R;
import com.danielworld.chinesestudy.SettingsActivity;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class TopView extends RelativeLayout {
    TextView title;
    ImageButton settingBtn;

    public TopView(Context context) {
        super(context);
        init(context);
    }

    public TopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TopView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(final Context context){
        View v = LayoutInflater.from(context).inflate(R.layout.view_top, null);
        title = (TextView) v.findViewById(R.id.topView_title);
        settingBtn = (ImageButton) v.findViewById(R.id.setting_button);
        settingBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, SettingsActivity.class));
            }
        });

        addView(v);
    }

    /**
     * Set the title of TopView
     * @param str
     */
    public void setTitle(String str){
        title.setText(str);
    }
}
