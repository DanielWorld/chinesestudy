package com.danielworld.chinesestudy.util;


import com.namgyuworld.utility.Logger;
import com.namgyuworld.utility.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class ParsingUtil {

    private static Logger LOG = Logger.getInstance();

    /**
     * Get CD List from chapter
     * @param rawData
     */
    public static List fromRawData(String rawData){
        List<String> cdList = new ArrayList<>();
        for(String i : rawData.split("[<]")){
            if(!StringUtil.isNullorEmpty(i)) {
                cdList.add(i);
            }
            LOG.d("cdList", i + "\n");
        }

        /**
         * cdList.size() : page number
         */
        return cdList;
    }

    /**
     * Get word from cd line
     * @param data
     */
    synchronized public static List fromCDLine(String data){
        List<String> wordList = new ArrayList<>();
        for(String i : data.split("[|]")){
            wordList.add(i);
            LOG.d("WordList", i + "\n\n\n\n\n");
        }

        return wordList;
    }
}
