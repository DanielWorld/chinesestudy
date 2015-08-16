package com.danielworld.chinesestudy.unitTest;

import android.test.AndroidTestCase;

import com.danielworld.chinesestudy.model.ChineseData;
import com.danielworld.chinesestudy.util.ParsingUtil;

import java.util.List;

/**
 * Created by danielpark on 2015-08-16.
 */
public class ParsingUtilTest extends AndroidTestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParsing(){
        List<String> a= ParsingUtil.fromRawData(ChineseData.getChapterData(ChineseData.CHAPTER.CHAPTER01));

        for(int i=0; i < a.size(); i++) {
            ParsingUtil.fromCDLine(a.get(i));
        }
    }
}
