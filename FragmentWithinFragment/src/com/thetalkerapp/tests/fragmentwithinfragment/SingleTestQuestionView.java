package com.thetalkerapp.tests.fragmentwithinfragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Chronometer;

import com.actionbarsherlock.app.SherlockFragment;


public class SingleTestQuestionView extends SherlockFragment implements
        View.OnClickListener {

    private static String Q_ID = "Q_ID";

    public static final SingleTestQuestionView newInstance(TestPaperQuestion testPaperQuestion) {
        SingleTestQuestionView fragment = new SingleTestQuestionView();

        Bundle bdl = new Bundle(1);
        bdl.putSerializable(Q_ID, testPaperQuestion);

        if (testPaperQuestion == null){
            Log.d("SingleTestQuestionView", "ERROR:PUTTING NULL AS QUESTION PAPER");
        }

        fragment.setArguments(bdl);

        return fragment;
    }

    private static final String pre_1 = "<!DOCTYPE html>"
            + "<html lang='en' xmlns:m='http://www.w3.org/1998/Math/MathML'>"
            + "<head>"
            + " <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=UnifrakturMaguntia'>"
            + " <link rel='stylesheet' href='file:///android_asset/jqmath-0.4.0.css'>"
            + " <script src='file:///android_asset/jquery-1.4.3.min.js'></script>"
            + " <script src='file:///android_asset/jqmath-etc-0.4.0.min.js'></script>"
            + "</head>"
            + "<body bgcolor='#d3ffce'>"
            + "<div style='border: 1px solid black;'><p><font face='SERIF'size='4'>";
    private static final String pre_2 = "</font></p></div><br><div style='border: 1px solid black;'><TABLE width='100%'><TR><TD ALIGN=CENTER width='10'><font style='border: 1px solid black;'face='SERIF'size='4'>A</font></TD><TD ALIGN=LEFT><font face='SERIF'size='4'>";
    private static final String pre_3 = "</font></TD></TR><TR><TD ALIGN=CENTER><font style='border: 1px solid black;' face='SERIF'size='4'>B</font></TD><TD ALIGN=LEFT><font face='SERIF'size='4'>";
    private static final String pre_4 = "</font></TD></TR><TR><TD ALIGN=CENTER><font style='border: 1px solid black;'face='SERIF'size='4'>C</font></TD><TD ALIGN=LEFT><font face='SERIF'size='4'>";
    private static final String pre_5 = "</font></TD></TR><TR><TD ALIGN=CENTER><font style='border: 1px solid black;'face='SERIF'size='4'>D</font></TD><TD ALIGN=LEFT><font face='SERIF'size='4'>";
    private static final String pre_6 = "</font></TD></TR></TABLE></div></body></html>";

    // Declare Variables
    private WebView webQuestion;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private Chronometer chronometer = null;
    private Question qustion = null;
    private TestPaperQuestion testPaperQuestion = null;

    public Question getQustion() {
        return qustion;
    }

    public void setQustion(Question qus) {
        this.qustion = qus;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.left_layout, container,
                false);

        //chronometer = (Chronometer) rootView.findViewById(R.id.left);

        if (savedInstanceState != null) {
            Log.d("SingleTestQuestionView", "Getting EXISTING testPaperQuestion");
            testPaperQuestion = (TestPaperQuestion) savedInstanceState.getSerializable("testPaperQuestion");

            if (testPaperQuestion == null)
                Log.d("SingleTestQuestionView", "From EXISTING instance but NULL");

        } else {
            Log.d("SingleTestQuestionView", "Getting NEW testPaperQuestion");

            testPaperQuestion = (TestPaperQuestion) getArguments().getSerializable(Q_ID);

            if (testPaperQuestion == null)
                Log.d("SingleTestQuestionView", "DID I Get the NULL for the new Instance?");

        }
        Log.d("SingleTestQuestionView", "Finished Creating new Item with Id <" + testPaperQuestion.getId() + ">");

        //chronometer.setBase(SystemClock.elapsedRealtime() + testPaperQuestion.getSeconds_to_answer());
        qustion = testPaperQuestion.getQuestion();

        
        return rootView;
    }

    public void stopTimer() {
        //testPaperQuestion.setSeconds_to_answer(chronometer.getBase() - SystemClock.elapsedRealtime());
        //chronometer.stop();
    }

    public void startTimer() {
        //chronometer.setBase(SystemClock.elapsedRealtime() + testPaperQuestion.getSeconds_to_answer());

        //chronometer.start();
    }

    private void changeState(int userSelectionId) {
        int userAnswer = -1;
        Button userOoption = null;

        testPaperQuestion.setUser_answer(userAnswer);
        //testPaperQuestion.setSeconds_to_answer(chronometer.getBase() - SystemClock.elapsedRealtime());
        //chronometer.stop();

        option1.setBackgroundColor(Color.LTGRAY);
        option2.setBackgroundColor(Color.LTGRAY);
        option3.setBackgroundColor(Color.LTGRAY);
        option4.setBackgroundColor(Color.LTGRAY);
        userOoption.setBackgroundColor(Color.YELLOW);

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.d("SingleTestQuestionView", "Calling onSaveInstanceState");

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("testPaperQuestion", testPaperQuestion);

        if (testPaperQuestion == null){
            Log.d("SingleTestQuestionView", "ERROR: SAVING testPaperQuestion AS NULL");
        } 
    }

    public void onDestroy () {
        super.onDestroy();
        //new updateTestQuestion().execute(new String[] { "" });    
    }

    public void onPause () {
        super.onPause();
        new updateTestQuestion().execute(new String[] { "" });  

    }

    public class updateTestQuestion extends AsyncTask<String, Void, List<TestPaperQuestion>> {
        protected List<TestPaperQuestion> doInBackground(String... strs) {

            return new ArrayList();
        }

        protected void onPostExecute(List<TestPaperQuestion> chapterNames) {}
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
