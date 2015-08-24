package com.danielworld.chinesestudy.customView;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.danielworld.chinesestudy.R;
import com.danielworld.chinesestudy.SettingsActivity;
import com.danielworld.chinesestudy.model.ChineseData;
import com.namgyuworld.utility.Logger;
import com.namgyuworld.utility.MediaPlayers;
import com.namgyuworld.utility.StringUtil;

import java.util.HashMap;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class TopView extends RelativeLayout implements View.OnClickListener {

    private String TAG = getClass().getSimpleName();
    Logger LOG = Logger.getInstance();

    TextView title;
    ImageButton settingBtn, playBtn;

    private String audioTitle;

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
        playBtn = (ImageButton) v.findViewById(R.id.play_button);
        settingBtn.setOnClickListener(this);
        playBtn.setOnClickListener(this);

        addView(v);
    }

    /**
     * Set the title of TopView
     * @param str
     */
    public void setTitle(String str){
        title.setText(str);
    }

    HashMap<Integer, String> audioList = new HashMap<>();

    public void setAudioList(int position, String str){
        audioList.put(position, str);
    }

    public void setAudioTitle(int position) throws Exception {
        LOG.i(TAG, "setAudioTitle : " + position);
        audioTitle = StringUtil.trimString(audioList.get(position));

        player.reset();
        player = null;
    }

    /**
     * Release MediaPlayer
     */
    public void releaseAudio(){
        try {
            player.release();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    MediaPlayer player = MediaPlayers.getInstance().getMediaPlayer();

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_button:
                getContext().startActivity(new Intent(getContext(), SettingsActivity.class));
                break;
            case R.id.play_button:
                LOG.i(TAG, "click play button");
                if(!StringUtil.isNullorEmpty(audioTitle)) {
                    try {
                        LOG.i(TAG, "audioTitle : " + audioTitle);
                        if(player != null && player.isPlaying()){
                            player.pause();
                            playBtn.setImageResource(android.R.drawable.ic_media_play);
                        } else if(player != null && !player.isPlaying()){
                            player.start();
                            playBtn.setImageResource(android.R.drawable.ic_media_pause);
                        }
                        else if(player == null){
                            player = MediaPlayer.create(getContext(), ChineseData.getInstance().getAudioTitle(audioTitle));
                            LOG.i(TAG, "resource id : " + ChineseData.getInstance().getAudioTitle(audioTitle));
                            player.start();
                            playBtn.setImageResource(android.R.drawable.ic_media_pause);
                        }
                    }catch (Exception e){
                       LOG.e(TAG, e.getMessage());
                    }
                }
                else{
                    LOG.e(TAG, "audioTitle is empty!");
                }
                break;
        }

    }
}
