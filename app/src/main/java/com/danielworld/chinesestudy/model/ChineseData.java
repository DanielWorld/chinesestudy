package com.danielworld.chinesestudy.model;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p/>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class ChineseData {

    public static final int totalChapterCount = 20;
    public static final int pageCountPerChapter = 6;

    public enum CHAPTER{
        CHAPTER00(0), CHAPTER01(1), CHAPTER02(2), CHAPTER03(3), CHAPTER04(4), CHAPTER05(5);

        private final int id;
        CHAPTER(int id){
            this.id = id;
        }
        public int getValue(){
            return id;
        }
    }

    private static final String chatper00 = "[cd1_06 | {A: Hello! | B: Hello! | A: How are you?}]";
    private static final String chatper01 = "[" +
            "cd1_06 | {A: Hello! | B: Hello! | A: How are you? | B: I'm fine, thanks. | A: How's your family? | B: They are all fine | A: Do you go to school? | B: I don't. Do you? | A: I do}" +
            "cd1_07 | {你 [nǐ] you | 好 [hǎo] good well | 你好! [nǐ hǎo] Hello! | 你好! [nǐ hǎo] Hello! | 吗 [ma] 의문을 나타내는 어기조사 | 我 [wǒ] I, me | }"+
            "cd1_08 | {}"+
            "cd1_09 | {}"+
            "]";
    private static final String chapter02 = "[cd1_07 | {A: Hello! | B: Hello! | A: How are you?}]";

    /**
     * Get chapter's data using enum
     * @param chapter
     * @return
     */
    public static String getChapterData(CHAPTER chapter){
        switch (chapter){
            case CHAPTER01:
                return chatper01;
            default:
                return "";
        }
    }

    /**
     * Get chapter's data using position
     * @param chapter
     * @return
     */
    public static String getChapterData(int chapter){
        switch (chapter){
            case 0:
                return chatper00;
            case 1:
                return chatper01;
            default:
                return "";
        }
    }
}
