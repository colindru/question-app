package com.example.colin.questionapp;

import java.sql.Time;

/**
 * Created by Colin on 12/21/2015.
 */
public class DataStructures {
    public static int intType = 0;
    public static int textType = 1;

    /**
     * This is the question to be asked
     */
    public class Question {
        String questionText;
        int answerType;
        boolean loggable;

        public Question(){

        }
    }
    /**
     * This ties together a list of questions with a schedule
     */
    public class QuestionEvent {
        Schedule schedule;
        Question[] questions;

        public QuestionEvent(){

        }
    }

    /**
     * Used by Question Event to create a proper recurring time interval.
     */
    public class Schedule {
        boolean[] daysActive;
        int repeatInterval;

        // This is probably not the right thing to do:
        Time whenActive;

        public Schedule(){

        }
    }

}
