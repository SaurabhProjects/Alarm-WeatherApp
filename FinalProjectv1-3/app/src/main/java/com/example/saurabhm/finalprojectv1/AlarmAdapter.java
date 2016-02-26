package com.example.saurabhm.finalprojectv1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter class(populates list of alarms that have been set it in the past)
 */
public class AlarmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Alarm> data;
    private ArrayList<String> days = new ArrayList<String>();

    public AlarmAdapter(Context context, ArrayList<Alarm> data) {
        this.data = data;
        this.context = context;
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return data.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String str1 = "";
        String str2 = "";
        // TODO Auto-generated method stub
        Alarm alarmToDisplay = data.get(position);
//Populates data to be presented in the list
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
            TextView lblTime = (TextView) convertView.findViewById(R.id.timeView);
            lblTime.setText(alarmToDisplay.getTime());

            TextView lblDescription = (TextView) convertView.findViewById(R.id.descriptionView);
            lblDescription.setText(alarmToDisplay.getDescription());




            TextView lblDays = (TextView) convertView.findViewById(R.id.daysView);
            lblDays.setText(alarmToDisplay.getDays());

            return convertView;




    }
}
