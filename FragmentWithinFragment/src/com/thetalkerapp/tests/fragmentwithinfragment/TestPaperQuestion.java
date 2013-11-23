package com.thetalkerapp.tests.fragmentwithinfragment;

import java.io.Serializable;
import java.util.Comparator;

public class TestPaperQuestion implements Serializable,
        Comparable<TestPaperQuestion> {

    private int id;
    private int test_paper_id;
    private int subject_id;
    private int question_id;
    private int user_answer;
    private long seconds_to_answer;
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTest_paper_id() {
        return test_paper_id;
    }

    public void setTest_paper_id(int test_paper_id) {
        this.test_paper_id = test_paper_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getUser_answer() {
        return user_answer;
    }

    public void setUser_answer(int user_answer) {
        this.user_answer = user_answer;
    }

    public long getSeconds_to_answer() {
        return seconds_to_answer;
    }

    public void setSeconds_to_answer(long seconds_to_answer) {
        this.seconds_to_answer = seconds_to_answer;
    }

    public int compareTo(TestPaperQuestion testPaperQuestion) {

        int compare = -1;

        if (testPaperQuestion != null
                && testPaperQuestion.getQuestion() != null) {
            compare = user_answer - testPaperQuestion.getUser_answer();
        }

        return compare;
    }

    public static Comparator<TestPaperQuestion> Comparator = new Comparator<TestPaperQuestion>() {

        public int compare(TestPaperQuestion testPaperQuestion1,
                TestPaperQuestion testPaperQuestion2) {

            // ascending order
            return testPaperQuestion2.getUser_answer() - testPaperQuestion1.getUser_answer();
        }

    };

}
