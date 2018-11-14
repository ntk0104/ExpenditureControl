package com.roynguyen147.expenditurecontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

import me.grantland.widget.AutofitTextView;

public class ExpenditureAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Expenditure> expenditureArrayList;

    public ExpenditureAdapter(Context context, int layout, ArrayList<Expenditure> expenditureArrayList) {
        this.context = context;
        this.layout = layout;
        this.expenditureArrayList = expenditureArrayList;
    }

    @Override
    public int getCount() {
        return expenditureArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        AutofitTextView edtExpenditureTitleDisplay, edtExpenditureDateDisplay, edtExpenditureTimeDisplay, edtExpenditureMoneyDisplay;
        LinearLayout layout_row_expenditure_item;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            //anh xa
            holder.edtExpenditureTitleDisplay = convertView.findViewById(R.id.edtExpenditureName);
            holder.edtExpenditureDateDisplay = convertView.findViewById(R.id.edtDateInput);
            holder.edtExpenditureTimeDisplay = convertView.findViewById(R.id.edtTimeInput);
            holder.edtExpenditureMoneyDisplay = convertView.findViewById(R.id.edtMoney);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Expenditure expenditure = expenditureArrayList.get(position);

        holder.edtExpenditureTitleDisplay.setText(expenditure.getTitle());
        holder.edtExpenditureDateDisplay.setText("1/1/18");
        holder.edtExpenditureTimeDisplay.setText("1:30 AM");
        holder.edtExpenditureMoneyDisplay.setText("+500");

        //set su kien on long click cho titledisplay va datedisplay

        return null;
    }
}
