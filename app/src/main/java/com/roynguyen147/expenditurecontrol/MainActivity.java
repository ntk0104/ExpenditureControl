package com.roynguyen147.expenditurecontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import me.grantland.widget.AutofitTextView;

public class MainActivity extends AppCompatActivity {

    ImageButton btnNextMonth, btnPreviousMonth, btnAddExpenditure, btnMoreSetting;
    AutofitTextView edtMonthYear, edtEarned, edtPaid, edtMonthRemaining, edtTotal;
    ListView expenditureListView;
    ArrayList<Expenditure> expenditureArrayList;
    Database database;
    ExpenditureAdapter expenditureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        
        AnhXa();
        database.createDBForTheFirstTime();
//        boolean check_insert = database.addNewGroup("Nhu Cau Thiet Yeu");
//        boolean check_insert2 = database.addNewGroup("Quan he");
//        boolean check_insert3 = database.addNewGroup("Tu thien");
//        boolean check_insert4 = database.addNewCategory("An sang", 5);
//        boolean check_insert5 = database.addNewCategory("An trua", 5);
//        boolean check_insert6 = database.addNewCategory("An toi", 5);
//        boolean check_insert7 = database.addNewCategory("Nhau nhet", 6);
//        boolean check_delete = database.DeleteGroup("Test1");
//        boolean check_delete1 = database.DeleteGroup("Test2");
//        boolean check_delete2 = database.DeleteGroup("Kiet");
        boolean check_update_category = database.UpdateCategory("An choi sa doa", "An sang");

//        boolean check_delete1 = database.DeleteCategory("An sang");
        Toast.makeText(this, check_update_category + " ", Toast.LENGTH_SHORT).show();
//        database.addNewGroup("Test");
//        database.addNewGroup("Dau tu mao hiem");
//        database.addNewGroup("Thu nhap thu dong");
//        database.addNewGroup("Giao duc");
//        database.addNewGroup("Ho Tro Nguoi Than");
//        database.addNewGroup("Tu thien");


    }

    private void AnhXa() {
        btnNextMonth        = findViewById(R.id.btnNextMonthMain);
        btnPreviousMonth    = findViewById(R.id.btnPreviousMonthMain);
        btnAddExpenditure   = findViewById(R.id.btnAddExpenditureM);
        btnMoreSetting      = findViewById(R.id.btnMoreSettingMain);
        edtMonthYear        = findViewById(R.id.edtMonthYearMain);
        edtEarned           = findViewById(R.id.edtEarnedMain);
        edtPaid             = findViewById(R.id.edtPaidMain);
        edtMonthRemaining   = findViewById(R.id.edtMonthRemainingMain);
        edtTotal            = findViewById(R.id.edtTotalMain);
        expenditureListView = findViewById(R.id.ListViewLatestExpenditureMain);
        database = new Database(this, "ExpenditureControl.sqlite", null, 1);
        expenditureArrayList = new ArrayList<>();
        expenditureAdapter = new ExpenditureAdapter(this, R.layout.row_expenditure, expenditureArrayList);
        expenditureListView.setAdapter(expenditureAdapter);
    }

    public void AddNewExpenditure(View view) {
        Toast.makeText(this, "btn Add is clicked", Toast.LENGTH_SHORT).show();
    }

    public void OpenSettingDialog(View view) {
        Toast.makeText(this, "btn Setting is clicked", Toast.LENGTH_SHORT).show();
    }

    public void GoPreviousMonth(View view) {
        Toast.makeText(this, "btn GoPreviousMonth clicked", Toast.LENGTH_SHORT).show();
    }

    public void GoNextMonth(View view) {
        Toast.makeText(this, "btn GoNextMonth clicked", Toast.LENGTH_SHORT).show();
    }
}
