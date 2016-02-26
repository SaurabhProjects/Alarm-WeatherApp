package com.example.saurabhm.finalprojectv1;


//constructor class
import java.util.ArrayList;

/**
 * Created by saurabhm on 22/11/15.
 */
public class Alarm {
    private String _time, _description;
    private String  _days ;

    public Alarm (String time, String description, String days  ) {
        _time = time;
        _description = description;
        _days = days;

    }



    public String getTime() {
        return _time;
    }

    public String getDescription() {
        return _description;
    }

    public String getDays() {
        return _days;
    }




}
