package com.danielworld.chinesestudy;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.danielworld.chinesestudy.adapter.MainPagerAdapter;
import com.danielworld.chinesestudy.customView.TopView;
import com.danielworld.chinesestudy.model.ChineseData;
import com.danielworld.chinesestudy.util.ParsingUtil;
import com.danielworld.chinesestudy.util.SharedPrefUtil;
import com.namgyuworld.utility.Logger;
import com.namgyuworld.utility.app.AppUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Logger LOG = Logger.getInstance();

    private ViewPager pager = null;
    private MainPagerAdapter pagerAdapter = null;
    private TopView topView;

    private SharedPrefUtil pref;

    int chapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (AppUtil.isDebuggable(this)) {
            LOG.enableLog();
        } else {
            LOG.disableLog();
        }

        chapter = getIntent().getExtras().getInt("position");

        init();

        /**
         * This is not good way for performance, but you gotta save all records while you're ruffling pages...
         */
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                pref.setCurrentPage(position);
                try {
                    topView.setAudioTitle(position);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // No over scroll, which means no blue affects are available
        pager.setOverScrollMode(View.OVER_SCROLL_NEVER);


    }

    private void init() {
        pref = new SharedPrefUtil(getApplicationContext());
        topView = (TopView) findViewById(R.id.topMenuBar);  // Top Menu bar
        topView.setTitle(ChineseData.getInstance().getChapterTitle(chapter)); // Set the title of Top View

        pagerAdapter = new MainPagerAdapter();
        pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(pagerAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        topView.releaseAudio();  // make sure to release audio
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshPage();
    }

    private void refreshPage() {
        pagerAdapter.removeAllView(pager);

        try {
            LayoutInflater inflater = getLayoutInflater();
            String rawData = ChineseData.getInstance().getChapterData(chapter);

            List<String> cdList = ParsingUtil.fromRawData(rawData);
            List<String> wordList = null;

            LOG.d("NewTAG", "List Size : " + cdList.size());

            LinearLayout[] fLayouts = new LinearLayout[cdList.size()];
            TextView tv;

            for (int i = 0; i < fLayouts.length; i++) {
                fLayouts[i] = (LinearLayout) inflater.inflate(R.layout.fragment_main, null);

                wordList = ParsingUtil.fromCDLine(cdList.get(i));

                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < wordList.size(); j++) {
                    if (j == 0) {
                        topView.setAudioList(i, wordList.get(j));

                    }
                    sb.append(wordList.get(j));
                    sb.append("\n\n");
                }

//                TextView tv = new TextView(this);
                tv = (TextView) fLayouts[i].findViewById(R.id.study_contents);
                tv.setTextSize(pref.getContentTextSize());
                tv.setText(sb);

//                fLayouts[i].addView(tv);

                pagerAdapter.addView(fLayouts[i]);
            }
            pagerAdapter.notifyDataSetChanged();

            try {
                // Go to the certain page that saved before
//                pager.setCurrentItem(pref.getCurrentPage());
                topView.setAudioTitle(pager.getCurrentItem()); // Set current audio title
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
