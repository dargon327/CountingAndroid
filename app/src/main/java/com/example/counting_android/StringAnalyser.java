package com.example.counting_android;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StringAnalyser {
    private ArrayList<String> text;
    private ArrayList<String> common;

    public StringAnalyser(String text, String common) throws FileNotFoundException {
        TextReader t = new TextReader(text);
        TextReader c = new TextReader(common);
        this.text = t.getWords();
        this.common = c.getWords();
        this.text = commonWords(punctuation(this.text));
    }

    private ArrayList<String> punctuation(ArrayList<String> arr) {
        ArrayList<String> ret = new ArrayList<>();
        String[] punc = {",",".","!","?","\"",";",":","(",")","/"};
        for (String s : arr) {
            String temp = s;
            for (int i = 0; i < punc.length;i++) {
                temp = temp.replace(punc[i],"");
            }
            ret.add(temp);
        }
        return ret;
    }

    private ArrayList<String> commonWords(ArrayList<String> arr) {
        ArrayList<String> ret = new ArrayList<>();
        for (String s : arr) {
            if (common.contains(s)) {
                continue;
            }
            ret.add(s);
        }
        return ret;
    }



    public ArrayList<String> getText() {
        return text;
    }

    public ArrayList<String> getCommon() {
        return common;
    }
}