package com.delaroystudios.quiz.data.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by delaroy on 4/30/18.
 */

@Entity
public class Questions {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "question")
    private String question;

    @Nullable
    @ColumnInfo(name = "answer")
    private String answer;

    @Nullable
    @ColumnInfo(name = "optA")
    private String optA;

    @Nullable
    @ColumnInfo(name = "optB")
    private String optB;

    @Nullable
    @ColumnInfo(name = "optC")
    private String optC;


    public Questions(@NonNull String question, @Nullable String opta, @Nullable String optb, @Nullable String optc, @Nullable String answer) {
        this.question = question;
        this.optA = opta;
        this.optB = optb;
        this.optC = optc;
        this.answer = answer;
    }

    public Questions()
    {
        id=0;
        question="";
        optA="";
        optB="";
        optC="";
        answer="";
    }

    public int getId(){return this.id;}

    public void setId(int id){
        this.id = id;
    }
    public String getQuestion(){return this.question;}

    public void setQuestion(String question){
        this.question = question;
    }

    public String getAnswer(){return this.answer;}

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getOptA(){return this.optA;}

    public void setOptA(String opta){
        this.optA = opta;
    }

    public String getOptB(){return this.optB;}

    public void setOptB(String optb){
        this.optB = optb;
    }

    public String getOptC(){return this.optC;}

    public void setOptC(String optc){
        this.optC = optc;
    }
}
