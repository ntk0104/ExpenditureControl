package com.roynguyen147.expenditurecontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import me.grantland.widget.AutofitTextView;

public class MainActivity extends AppCompatActivity {

    ImageButton btnNextMonth, btnPreviousMonth, btnAddExpenditure, btnMoreSetting;
    AutofitTextView edtMonthYear, edtEarned, edtPaid, edtRemaining, edtTotal;
    ListView expenditureListView;
    ArrayList<Expenditure> expenditureArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

    }
}
