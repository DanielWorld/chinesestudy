package com.danielworld.chinesestudy;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielworld.chinesestudy.adapter.MainPagerAdapter;
import com.danielworld.chinesestudy.customView.TopView;
import com.danielworld.chinesestudy.model.ChineseData;
import com.danielworld.chinesestudy.util.SharedPrefUtil;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager = null;
    private MainPagerAdapter pagerAdapter = null;
    private TopView topView;

    private SharedPrefUtil pref;

    int chapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chapter = getIntent().getExtras().getInt("position");

        init();

        /**
         * This is not good way for performance, but you gotta save all records while you're ruffling pages...
         */
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pref.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // No over scroll, which means no blue affects are available
        pager.setOverScrollMode(View.OVER_SCROLL_NEVER);


    }

    private void init(){
        pref = new SharedPrefUtil(getApplicationContext());
        topView = (TopView) findViewById(R.id.topMenuBar);  // Top Menu bar

        pagerAdapter = new MainPagerAdapter();
        pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(pagerAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshPage();
    }

    private void refreshPage(){
        pagerAdapter.removeAllView(pager);

        try{
            LayoutInflater inflater = getLayoutInflater();
            LinearLayout[] fLayouts = new LinearLayout[ChineseData.pageCountPerChapter];

            for(int i = 0; i < fLayouts.length; i++){
                fLayouts[i] = (LinearLayout) inflater.inflate(R.layout.fragment_main, null);
                String data = ChineseData.getChapterData(chapter);

                TextView tv = new TextView(this);
                tv.setText(data);

                fLayouts[i].addView(tv);

                pagerAdapter.addView(fLayouts[i]);
            }
            pagerAdapter.notifyDataSetChanged();

            try{
                // Go to the certain page that saved before
//                pager.setCurrentItem(pref.getCurrentPage());
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
