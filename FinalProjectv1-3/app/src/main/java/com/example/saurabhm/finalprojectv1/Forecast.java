package com.example.saurabhm.finalprojectv1;

/**
 * Contstructor class for the weathers
 */
public class Forecast {
    private String _code;
    private String _date;
    private String _day;
    private String _high;
    private String _low;
    private String _text;

    public Forecast(){

    }

    public Forecast(String code, String date, String day, String high, String low, String text){
        super();
        this._code =code;
        this._date=date;
        this._day=day;
        this._high=high;
        this._low=low;
        this._text=text;
    }




    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }

    public String getCode() {
        return _code;
    }

    public void setCode(String _code) {
        this._code = _code;
    }

    public String getDay() {
        return _day;
    }

    public void setDay(String _day) {
        this._day = _day;
    }

    public String getHigh() {
        return _high;
    }

    public void setHigh(String _high) {
        this._high = _high;
    }

    public String getLow() {
        return _low;
    }

    public void setLow(String _low) {
        this._low = _low;
    }

    public String getText() {
        return _text;
    }

    public void setText(String _text) {
        this._text = _text;
    }
}
