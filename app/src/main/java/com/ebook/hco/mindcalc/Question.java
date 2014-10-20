package com.ebook.hco.mindcalc;

import android.app.Activity;

import java.util.Random;

/**
 * Created by halilcanozcelik on 30.9.2014.
 */
public class Question extends Activity{
    Random randInp = new Random();
    String[] opeList = {"+","-","/","x"};
    String question;
    int selection1, selection2, selection3, selection4, answer;

    public void Questioner() {
        int ind = randInp.nextInt(3) + 1;
        String op1 = opeList[ind];

        if (op1.equals("+")){
            int inp1 = randInp.nextInt(100) + 1;
            int inp2 = randInp.nextInt(100) + 1;

            question = (inp1 + " " + op1 + " " + inp2 + " = ?");
            answer = inp1 + inp2;

        } else if (op1.equals("-")){
            int inp1 = randInp.nextInt(100) + 1;
            int inp2 = randInp.nextInt(100) + 1;

            question = (inp1 + " " + op1 + " " + inp2 + " = ?");
            answer = inp1 - inp2;

        } else if (op1.equals("/")){
            int inp1a = randInp.nextInt(15) + 1;
            int inp2 = randInp.nextInt((15) + 1) + 1;

            int inp1 = inp1a * inp2;
            question = (inp1 + " " + op1 + " " + inp2 + " = ?");
            answer = inp1a;

        } else  {
            int inp1 = randInp.nextInt(20) + 1;
            int inp2 = randInp.nextInt(20) + 1;

            question = (inp1 + " " + op1 + " " + inp2 + " = ?");
            answer = inp1 * inp2;

        }
        selection1 = answer - 10;
        selection2 = answer + 10;
        selection3 = answer - randInp.nextInt(5);
        selection4 = answer + randInp.nextInt(50) + 11;

    }
}
