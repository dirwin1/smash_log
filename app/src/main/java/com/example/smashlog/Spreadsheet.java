package com.example.smashlog;

public class Spreadsheet {
    public String player1;
    public String player2;
    public Record[][] data;

    public Spreadsheet(String p1, String p2){
        player1 = p1;
        player2 = p2;
        int size = CHARACTER.values().length;
        data = new Record[size][size];
    }

    public void IncrementWin(CHARACTER c1, CHARACTER c2){
        data[c1.getValue()][c2.getValue()].wins++;
    }

    public void IncrementLoss(CHARACTER c1, CHARACTER c2){
        data[c1.getValue()][c2.getValue()].losses++;
    }
}
