package com.example.saurabhm.finalprojectv1;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/* This class enables the setting and saving of the alarm */

public class AlarmClock extends Activity {
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private String strDate;
    private int counter=0;
    private ArrayList<String> days = new ArrayList<String>();
    AlarmManager alarmManager;
    private EditText descriptionText;
    private static MainActivity inst;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);
        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        checkBox1= (CheckBox) findViewById(R.id.sundayCheckBox);
        checkBox2= (CheckBox) findViewById(R.id.mondayCheckBox);
        checkBox3= (CheckBox) findViewById(R.id.tuesdayCheckBox);
        checkBox4= (CheckBox) findViewById(R.id.wednesdayCheckBox);
        checkBox5= (CheckBox) findViewById(R.id.thursdayCheckBox);
        checkBox6= (CheckBox) findViewById(R.id.fridayCheckBox);
        checkBox7= (CheckBox) findViewById(R.id.saturdayCheckBox);





    }
    public void save (View v){
        if (checkBox1.isChecked())
        {
            days.add("Su");
            activityToPerform(1);
        }

        if (checkBox2.isChecked())
        {
            days.add("Mo");
            activityToPerform(2);

        }

        if (checkBox3.isChecked())
        {
            days.add("Tu");
            activityToPerform(3);
        }

        if (checkBox4.isChecked())
        {
            days.add("We");
            activityToPerform(4);
        }

        if (checkBox5.isChecked())
        {
            days.add("Th");
            activityToPerform(5);
        }

        if (checkBox6.isChecked())
        {
            days.add("Fr");
            activityToPerform(6);
        }

        if (checkBox7.isChecked())
        {
            days.add("Sa");
            activityToPerform(7);
        }

        Intent resultIntent = new Intent(Intent.ACTION_PICK);
        resultIntent.putExtra("time", strDate);
        resultIntent.putExtra("days",days);
        resultIntent.putExtra("description", descriptionText.getText().toString());

        setResult(RESULT_OK, resultIntent);

        finish();


    }
    private void activityToPerform(int week)
    {

        Log.d("MainActivity", "Alarm On");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, week);
        calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
        strDate = alarmTimePicker.getCurrentHour() + ":" + alarmTimePicker.getCurrentMinute();
        Toast.makeText(getBaseContext(), strDate, Toast.LENGTH_SHORT).show();
        descriptionText= (EditText)findViewById(R.id.descriptionEditText);
        Intent myIntent = new Intent(this, AlarmBroadcast.class);
        pendingIntent = PendingIntent.getBroadcast(this, counter, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("MainActivity", "Pending Intent created");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            Log.d("MainActivity", "Alarm mANAGER created");
        counter++;
        }
    }
    public void time (View v){
        strDate = alarmTimePicker.getCurrentHour() + ":" + alarmTimePicker.getCurrentMinute();


        Toast.makeText(getBaseContext(), strDate, Toast.LENGTH_SHORT).show();

    }


    public void cancel(View v){
        if (alarmManager!= null) {
            alarmManager.cancel(pendingIntent);
        }

    }
}