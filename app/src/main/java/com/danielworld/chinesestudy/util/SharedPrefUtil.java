package com.danielworld.chinesestudy.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class SharedPrefUtil {

    private static SharedPreferences mPref;

    private static final String KEY_PREF = "key_pref";
    private final String KEY_CURRENT_PAGE = "key_current_page";

    public SharedPrefUtil(Context ctx){
        if(mPref == null)
            mPref = ctx.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
    }

    public void setCurrentPage(int page){
        mPref.edit().putInt(KEY_CURRENT_PAGE, page).commit();
    }

    public int getCurrentPage(){
        return mPref.getInt(KEY_CURRENT_PAGE, 0);
    }
}
