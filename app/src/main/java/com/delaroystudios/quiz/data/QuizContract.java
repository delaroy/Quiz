package com.delaroystudios.quiz.data;

import android.provider.BaseColumns;

/**
 * Created by delaroy on 11/30/17.
 */

public class QuizContract {

    public static class MovieEntry implements BaseColumns {
        public static final String TABLE_QUEST = "quest";
        // tasks Table Columns names
        public static final String KEY_ID = "id";
        public static final String KEY_QUES = "question";
        public static final String KEY_ANSWER = "answer"; //correct option
        public static final String KEY_OPTA= "opta"; //option a
        public static final String KEY_OPTB= "optb"; //option b
        public static final String KEY_OPTC= "optc"; //option c
    }
}
