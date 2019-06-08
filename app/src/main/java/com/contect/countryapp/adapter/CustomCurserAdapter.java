package com.contect.countryapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.contect.countryapp.R;

public class CustomCurserAdapter extends CursorAdapter {

    public CustomCurserAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_item, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView idTextView = (TextView)view.findViewById(R.id.textViewId);
        idTextView.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0))));

        TextView subTxtView = (TextView)view.findViewById(R.id.countyNameTxtView);
        subTxtView.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));

        TextView desTextView = (TextView)view.findViewById(R.id.desTxtView);
        desTextView.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));

    }

}
