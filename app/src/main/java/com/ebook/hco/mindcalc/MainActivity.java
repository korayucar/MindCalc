package com.ebook.hco.mindcalc;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
    }

    public Question question;
    public GameTimer gameTimer;
    public int scoreNum = 0;

    public void StartGame(View v){
        setContentView(R.layout.activity_main);
        ShowQuestion();
        gameTimer = new GameTimer(60000, 1000);
        gameTimer.start();
    }

    public void ShowQuestion(){
        question = new Question();
        int[] choices = new int[4];

        TextView questionBox = (TextView)findViewById(R.id.questionBox);
        Button aChoice = (Button)findViewById(R.id.a);
        Button bChoice = (Button)findViewById(R.id.b);
        Button cChoice = (Button)findViewById(R.id.c);
        Button dChoice = (Button)findViewById(R.id.d);

        Random r = new Random();
        int var = r.nextInt(3);

        question.Questioner();

        String showedQuestion = question.question;
        choices[0] = question.selection1;
        choices[1] = question.selection2;
        choices[2] = question.selection3;
        choices[3] = question.selection4;
        choices[var] = question.answer;

        questionBox.setText(showedQuestion);
        aChoice.setText(choices[0] + "");
        bChoice.setText(choices[1] + "");
        cChoice.setText(choices[2] + "");
        dChoice.setText(choices[3] + "");
    }

    public void Score(){
        TextView score = (TextView)findViewById(R.id.score);
        scoreNum = scoreNum + 55;
        score.setText(scoreNum + "");
    }

    public class GameTimer extends CountDownTimer {
        public GameTimer(long millisInFuture, long countDownInterval){
            super(millisInFuture, countDownInterval);
        }
        TextView countdown = (TextView)findViewById(R.id.countdown);

        @Override
        public void onTick(long millisInFuture) {
            countdown.setText(String.valueOf(millisInFuture/1000));
        }

        @Override
        public void onFinish() {
            countdown.setText("Finished!!");
            setContentView(R.layout.end_page);
            TextView scoreEndBox2 = (TextView)findViewById(R.id.scoreEnd);
            scoreEndBox2.setText(scoreNum + "");
            scoreNum = 0;
        }
    }

    public void AnswerChecker(View v){
        Button userChoice = (Button)findViewById(v.getId());
        String userAnswer = userChoice.getText().toString();
        TextView scoreEndBox = (TextView)findViewById(R.id.scoreEnd);
        int userAnswerInt = Integer.parseInt(userAnswer);
        int rightAnswerInt = question.answer;

        if (userAnswerInt == rightAnswerInt){
            ShowQuestion();
            Score();
        } else {
            setContentView(R.layout.end_page);
            TextView scoreEndBox2 = (TextView)findViewById(R.id.scoreEnd);
            scoreEndBox2.setText(scoreNum + "");
            scoreNum = 0;
        }
    }
}
