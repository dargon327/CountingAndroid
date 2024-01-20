package com.example.counting_android;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class TextReader {
    private String name;
    private ArrayList<String> words;


    private ArrayList<String> text()  {
        ArrayList<String> word = new ArrayList<>();
        Scanner scan = new Scanner(name);
        while (scan.hasNext()) {
            String s = scan.next();
            word.add(s.toLowerCase());
        }
        scan.close();
        return word;
    }
    public TextReader(String name) {
        this.name = name;
        words = text();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getWords() {
        return words;
    }
}