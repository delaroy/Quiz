package com.delaroystudios.quiz;
import java.util.ArrayList;
import java.util.List;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.delaroystudios.quiz.data.database.entity.Questions;
import com.delaroystudios.quiz.utility.InjectorUtils;
import com.delaroystudios.quiz.viewmodel.MainViewModel;
import com.delaroystudios.quiz.viewmodel.MainViewModelFactory;

public class QuizActivity extends AppCompatActivity {
	List<Questions> quesList = new ArrayList<>();
	int score=0;
	int qid=0;
	Questions currentQ;
	TextView txtQuestion;
	RadioButton rda, rdb, rdc;
	Button butNext;
    private MainViewModel vMainViewModel;
	private RelativeLayout relativeLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);

		relativeLayout = (RelativeLayout) findViewById(R.id.profileLoadingScreen);

        MainViewModelFactory factory = InjectorUtils.getMainViewModelFactory(getApplicationContext());
        vMainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);

        vMainViewModel.getmQuestions().observe(this, questions -> {

            if(questions != null && questions.size()>0){
                quesList.clear();
                quesList.addAll(questions);

                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    takeAction();
                    relativeLayout.setVisibility(View.GONE);
                }, 3000);
            }
        });

        postRequest();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}
	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQuestion());
		rda.setText(currentQ.getOptA());
		rdb.setText(currentQ.getOptB());
		rdc.setText(currentQ.getOptC());
		qid++;
	}

    public void takeAction(){
        relativeLayout.setVisibility(View.INVISIBLE);
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);

                if (grp.getCheckedRadioButtonId() == -1){
                    return;
                }

                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());

                grp.clearCheck();
                //Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());

                if(currentQ.getAnswer().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void postRequest(){
        vMainViewModel.postRequest();
    }

}
