package com.danielworld.chinesestudy;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.danielworld.chinesestudy.util.SharedPrefUtil;
import com.namgyuworld.utility.RegexUtil;
import com.namgyuworld.utility.StringUtil;

/**
 * Created by danielpark on 2015-08-16.
 */
public class SettingsActivity extends Activity {

    EditText mEditText; // the field that contains contents' text size
    SharedPrefUtil mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mPref = new SharedPrefUtil(getApplicationContext());
        mEditText = (EditText) findViewById(R.id.textSize_field);

        mEditText.setText(String.valueOf(mPref.getContentTextSize()));

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if(RegexUtil.isOnlyIntegerNumeric(s.toString())){
                        mPref.setContentTextSize(Integer.parseInt(s.toString()));
                    }else{
                        mEditText.setText(String.valueOf(mPref.getContentTextSize()));
                        Toast.makeText(SettingsActivity.this, "Only 1 ~ 99 text size is allowed!!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
//                    mEditText.setText(String.valueOf(mPref.getContentTextSize()));
                    Toast.makeText(SettingsActivity.this, "Error occurred while typing text size", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
