package com.danielworld.chinesestudy.model;

/**
 * Copyright (C) 2014-2015 Daniel Park, op7773hons@gmail.com
 * <p/>
 * This file is part of chinesestudy (https://github.com/DanielWorld)
 * Created by danielpark on 2015. 8. 11..
 */
public class ChineseData {

    public static final int totalChapterCount = 21; // Chapter 0 ~ Chapter 20

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

    private static final String chapter00 =
            "<cd1_01 | 天天 [tiāntiān] everyday | 远 [yuǎn] far | 爷爷 [yéye] grand father | 飞机 [fēijī] airplane | 月 [yuè] moon | 鸡 [jī] chicken | " +
            "西 [xī] West | 吃 [chī] eat | 四 [sì] four" +
            "<cd1_02 | 爸爸 [bàba] father | 婆婆 [pópo] mother-in-law | 妈妈 [māma] mother | 夫妇 [fūfù] (married) couple | 弟弟 [dìdi] younger brother | " +
            "他 [tā] He | 女 [nǚ] woman | 来 [lái] come | 哥哥 [gēge] older brother | 哭 [kū] cry | 喝 [hē] drink | 鸡 [jī] chicken | 妻子 [qīzi] wife, spouse | " +
            "洗 [xǐ] clean | 猪 [zhū] pig | 吃 [chī] eat | 书 [shū] book | 日记 [rìjì] diary | 自己 [zìjǐ] myself | 醋 [cù] vinegar | 四 [sì] four" +
            "<cd1_03 | 妈 [mā] mom | 妈妈 [māma] mother | 麻 [má] 마 (먹는음식) | 爷爷 [yéye] grand father | 马 [mǎ] horse | 奶奶 [nǎinai] grand mother | 骂 [mà] swear(abusive behavior) | " +
            "爸爸 [bàba] father | 他 [tā] He | 好 [hǎo] good, well | 快 [kuài] quick, fast | 来 [lái] come | 给 [gěi] give | 喝 [hē] drink | 多 [duō] many, much | 口 [kǒu] mouth | " +
            "六 [liù] six | 九 [jiǔ] nine | 水 [shuǐ] water | 腿 [tuǐ] leg | 笔 [bǐ] pen | 四 [sì] four | 吃 [chī] eat | 自己 [zìjǐ] myself | 妈妈 [māma] mother | 妻子 [qīzi] wife, spouse | " +
            "婆婆 [pópo] mother-in-law | 朋友 [péngyou] friend | 奶奶 [nǎinai] grand mother | 本子 [běnzi] notebook | 妹妹 [mèimei] younger sister | 胖子 [pàngzi] fat person" +
            "<cd1_04 | 奶奶 [nǎinai] grand mother | 妹妹 [mèimei] younger sister | 猫 [māo] cat | 口 [kǒu] mouth | 家 [jiā] house | 牙 [yá] tooth | 爷爷 [yéye] grand father | " +
            "花 [huā] flower | 挖 [wā] dig | 我 [wǒ] I, me | 月 [yuè] moon | 药 [yào] medicine | 球 [qiú] ball | 帅 [shuài] handsome | 水 [shuǐ] water" +
            "<cd1_05 | sorry. Under construction!!"
            ;
    private static final String chapter01 =
            "<cd1_06 | A: Hello! | B: Hello! | A: How are you? | B: I'm fine, thanks. | A: How's your family? | B: They are all fine | A: Do you go to school? | B: I don't. Do you? | A: I do" +
            "<cd1_07 | 你 [nǐ] you | 好 [hǎo] good, well | 你好! [nǐ hǎo] Hello! | 你好! [nǐ hǎo] Hello! | 吗 [ma] 의문을 나타내는 어기조사 | 我 [wǒ] I, me | 很 [hěn] very | 谢谢 [xièxie] Thank you | " +
                    "你好吗? [nǐ hǎo ma] How are you? | 我很好, 谢谢. [wǒ hěn hǎo, xièxie] I'm fine, thanks."+
            "<cd1_08 | 家人 [jiārén] family | 他 [tā] He | 们 [men] (복수형)~들 | 也 [yě] also | 都 [dōu] all, all of them | 你家人好吗? [nǐ jiārén hǎo ma] How's your family? | " +
                    "他们也都很好 [tāmen yě dōu hěn hǎo] They're all fine too. | 去 [qù] go | 学校 [xuéxiào] school | 不 [bù] 부정을 나타냄 | 呢 [ne] 문장 끝에서 의문을 나타내는 어기조사 | " +
                    "你去学校吗? [nǐ qù xuéxiào ma] Do you go to school? | 我不去, 你呢? [wǒ bú qù, nǐ ne] I don't go, do you?"+
            "<cd1_09 | 你好! [nǐ hǎo] | 你好! [nǐ hǎo] | 你好吗? [nǐ hǎo ma] | 我很好, 谢谢. [wǒ hěn hǎo, xièxie] | 你家人好吗? [nǐ jiārén hǎo ma] | 他们也都很好 [tāmen yě dōu hěn hǎo] | " +
                    "你去学校吗? [nǐ qù xuéxiào ma] | 我不去, 你呢? [wǒ bú qù, nǐ ne] | 我去 [wǒ qù]"
            ;
    private static final String chapter02 = "";
    private static final String chapter03 = "";
    private static final String chapter04 = "";

    /**
     * Get chapter's data using enum
     * @param chapter
     * @return
     */
    public static String getChapterData(CHAPTER chapter){
        switch (chapter){
            case CHAPTER00:
                return chapter00;
            case CHAPTER01:
                return chapter01;
            case CHAPTER02:
                return chapter02;
            case CHAPTER03:
                return chapter03;
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
                return chapter00;
            case 1:
                return chapter01;
            case 2:
                return chapter02;
            case 3:
                return chapter03;
            case 4:
                return chapter04;
            default:
                return "";
        }
    }

    public static String getChapterTitle(int chapter){
        return "Chapter " + chapter;
    }
}
