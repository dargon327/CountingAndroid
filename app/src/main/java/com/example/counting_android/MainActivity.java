package com.example.counting_android;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView displayText;
    EditText inputFileText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("base","bros code works");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = (TextView) findViewById(R.id.textView);
        inputFileText = (EditText) findViewById(R.id.editTextFileName);
    }

    public void goToMostCommon(View v) throws FileNotFoundException {
        String file = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(inputFileText.getText().toString())));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                file += mLine + " ";
            }
        } catch (IOException except) {
            except.printStackTrace();
        }
        String commonWordsTXT = "";
        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new InputStreamReader(getAssets().open("commonWords.txt")));

            String mLine;
            while ((mLine = reader2.readLine()) != null) {
                commonWordsTXT += mLine + " ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringAnalyser oratrice = new StringAnalyser(file, commonWordsTXT);
        Counter counter = new Counter(oratrice);
        String top1 = counter.top5()[0];
        int a = top1.indexOf(" ");
        int freq = parseInt(top1.substring(a+1));
        String word = top1.substring(0,a);
        Log.d("yes4","bros code works");
        displayText.setTextSize(30);
        displayText.setText("The most common word in the text file \"" + inputFileText.getText().toString() + "\" is " + "\"" + word + "\"" + " with " + freq + " occurrences.");

        Log.d("yes5","bros code works");
    }

    public void goToTopFive(View v) throws FileNotFoundException {
        String file = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(inputFileText.getText().toString())));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                file += mLine + " ";
            }
        } catch (IOException except) {
            except.printStackTrace();
        }
        String commonWordsTXT = "";
        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new InputStreamReader(getAssets().open("commonWords.txt")));

            String mLine;
            while ((mLine = reader2.readLine()) != null) {
                commonWordsTXT += mLine + " ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringAnalyser mecanique = new StringAnalyser(file, commonWordsTXT);
        Counter counter = new Counter(mecanique);
        String[] word5 = counter.top5();
        int[] freq5 = new int[5];
        for (int i = 0; i < 5; i++) {
            int a = word5[i].indexOf(" ");
            freq5[i] = parseInt(word5[i].substring(a+1));
            word5[i] = word5[i].substring(0,a);
        }

        String topFiveWordsString = "";
        for (int i = 0; i < 5; i++){
            topFiveWordsString += " \"" + word5[i] + "\" with " + freq5[i] + " occurrences.\n";
        }
        displayText.setTextSize(18);
        displayText.setText("The top five most common words in the text file \"" + inputFileText.getText().toString() + "\" are \n\n" + topFiveWordsString);
    }

}