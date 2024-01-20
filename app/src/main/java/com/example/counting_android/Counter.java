package com.example.counting_android;

import java.util.ArrayList;

public class Counter {
    private ArrayList<String> text;
    private ArrayList<Integer> sum;
    private ArrayList<String> word;
    public Counter(StringAnalyser text) {
        this.text = text.getText();
        sum = new ArrayList<>();
        word = new ArrayList<>();
        for (int i = 0; i < this.text.size();i++) {
            if (!word.contains(this.text.get(i))) {
                word.add(this.text.get(i));
                sum.add(0);
            }
        }
        for (int i = 0; i < word.size();i++) {
            for (int j = 0; j < this.text.size();j++) {
                if (word.get(i).equals(this.text.get(j))) {
                    sum.set(i,sum.get(i) + 1);
                }

            }
        }
    }
    public String[] top5() {
        String[] ret = new String[5];
        ArrayList<Integer> temp = sum;
        for (int i = 0; i < 5;i++) {
            int largest = 0;
            for (int j = 0; j < sum.size();j++) {
                if (temp.get(j) > temp.get(largest)) {
                    largest = j;
                }
            }
            ret[i] = word.get(largest);
            ret[i] += " " + temp.get(largest);
            temp.set(largest,0);
        }
        return ret;
    }
    public String top1() {
        return top5()[0];
    }
}
