package com.example.atik.kpsstest;

public class Question {
    private int mId;
    private int mQuestionClass;
    private String mQuestion;
    private int mAnswer;
    private String mA;
    private String mB;
    private String mC;
    private String mD;
    private String mE;

    public Question() {
        mId = 0;
        mQuestion = "";
        mQuestionClass = 0;
        mA = "";
        mB = "";
        mC = "";
        mD = "";
        mE = "";
        mAnswer = 0;
    }

    public Question(int questionClass, String question, String A, String B, String C, String D, String E, int answer) {
        mQuestionClass = questionClass;
        mQuestion = question;
        mAnswer = answer;
        mA = A;
        mB = B;
        mC = C;
        mD = D;
        mE = E;
    }

    public int getId() {
        return mId;
    }

    public void setId(int questionId) {
        mId = questionId;
    }

    public int getQuestionClass() {
        return mQuestionClass;
    }

    public void setQuestionClass(int questionClass) {
        mQuestionClass = questionClass;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public void setAnswer(int answer) {
        mAnswer = answer;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public String getA() {
        return mA;
    }

    public void setA(String a) {
        mA = a;
    }

    public String getB() {
        return mB;
    }

    public void setB(String b) {
        mB = b;
    }

    public String getC() {
        return mC;
    }

    public void setC(String c) {
        mC = c;
    }

    public String getD() {
        return mD;
    }

    public void setD(String d) {
        mD = d;
    }

    public String getE() {
        return mE;
    }

    public void setE(String e) {
        mE = e;
    }
}