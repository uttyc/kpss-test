package com.example.atik.kpsstest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends Activity implements View.OnClickListener {
    TextView txtQuestion;
    TextView txtQuestionNo;
    RadioButton rb_a, rb_b, rb_c, rb_d, rb_e;
    Button btnNext;
    Question currentQ;
    int qid = 0;
    int score = 0;

    List<Question> questions;
    private static final String TAG = "tr.edu.iyte.kpssquizapp";
    Database db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txtQuestion = (TextView) findViewById(R.id.textview_soru);
        txtQuestionNo = (TextView) findViewById(R.id.textview_soru_no);
        btnNext = (Button) findViewById(R.id.gonder);
        rb_a = (RadioButton) findViewById(R.id.answer_a);
        rb_b = (RadioButton) findViewById(R.id.answer_b);
        rb_c = (RadioButton) findViewById(R.id.answer_c);
        rb_d = (RadioButton) findViewById(R.id.answer_d);
        rb_e = (RadioButton) findViewById(R.id.answer_e);
        btnNext.setOnClickListener(this);

        setQuestionView();
    }

    @Override
    public void onClick(View v) {
        checkAnswer();
    }

    private void setQuestionView() {
        try {
            questions = new ArrayList<>();
            db = new Database(this);
            questions = db.queryHistoryQuestions();
            currentQ = questions.get(qid);
            txtQuestionNo.setText("Soru " + (qid + 1));
            txtQuestion.setText(currentQ.getQuestion());
            rb_a.setText(currentQ.getA());
            rb_b.setText(currentQ.getB());
            rb_c.setText(currentQ.getC());
            rb_d.setText(currentQ.getD());
            rb_e.setText(currentQ.getE());
            qid ++;
        } catch (Exception e) {
            Toast.makeText(this, "List is empty", Toast.LENGTH_SHORT).show();
        }

    }

    private int answerSelected(int radioButtonId) {
        int id = radioButtonId % 10 - 3;
        int returnId = 0;
        switch (id) {
            case 0:
                returnId = Database.DBHelper.ANSWER_A;
                break;
            case 1:
                returnId = Database.DBHelper.ANSWER_B;
                break;
            case 2:
                returnId = Database.DBHelper.ANSWER_C;
                break;
            case 3:
                returnId = Database.DBHelper.ANSWER_D;
                break;
            case 4:
                returnId = Database.DBHelper.ANSWER_E;
                break;

        }
        return returnId;
    }

    private void checkAnswer() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int id = radioGroup.getCheckedRadioButtonId();


        RadioButton answer = (RadioButton) findViewById(id);
        if (currentQ.getAnswer() == answerSelected(id)) {
            score++;
            Toast.makeText(this, "Cevap doğru!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Yanlış cevap!", Toast.LENGTH_SHORT).show();
        }
        if (qid < questions.size()) {
            currentQ = questions.get(qid);
            setQuestionView();
        } else {
            Toast toast = Toast.makeText(this,"Puanınız : "+score,Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

    }

}