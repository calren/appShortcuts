package com.example.caren.sushi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_RECEIVER = "open";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
