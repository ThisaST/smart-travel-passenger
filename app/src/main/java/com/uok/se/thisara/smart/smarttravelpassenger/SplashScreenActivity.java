package com.uok.se.thisara.smart.smarttravelpassenger;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uok.se.thisara.smart.smarttravelpassenger.ui.login.LoginFragment;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent userSelectionIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(userSelectionIntent);
                finish();
            }
        }, 3000);
    }
}

/*import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
/*
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int[] points = new int[n];
    int[] val = new int[3];

        for(int i = 0; i < n; i++) {

        points[i] = input.nextInt();
        }

        for (int k = 0; k < 3; k++) {

        val[k] = input.nextInt();
        }

        int start = points[0] - val[2];
        int end = start + val[0];

        int endDifference = end - points[n - 1];

        int endDifferenceWithMin = endDifference - val[1];


        if(endDifferenceWithMin < val[1]) {

        addToEnd(endDifferenceWithMin);
        }

        checkTheDifferenceInPoints();

        }

public static void addToEnd(int difference) {

        int start =

        }

public static void checkEndAndEndPoint(int endDifference, int[] val) {

        if(endDifference > val[2]) {


        }else if(endDifference < val[1]) {

        addValueToChange();
        }
        }

public static void checkTheDifferenceInPoints(int[] points) {

        for(int ) {

        }
        }
        }*/