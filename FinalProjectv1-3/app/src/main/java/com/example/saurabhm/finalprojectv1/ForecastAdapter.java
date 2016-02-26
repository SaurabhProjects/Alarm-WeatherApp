package com.example.saurabhm.finalprojectv1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adpater class that displays regarding the current weather and forecasts for 5 days
 */
public class ForecastAdapter extends ArrayAdapter<Forecast> {
    int resourceId;
    String code;


    public class ViewHolder{

        public TextView textCode;
        public TextView textDate;
        public TextView textDay;
        public TextView textHigh;
        public TextView textLow;
        public TextView textTemp;
        public ImageView img;

    }



    ArrayList <Forecast> listItem;
    LayoutInflater inflater;
    ViewHolder holder;
    int Resoruce;



    public ForecastAdapter(Context context, int resource, ArrayList<Forecast> objects){

        super(context, resource, objects);

        inflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        Resoruce =resource;
        listItem=objects;

    }



    public View getView(int postion,View convertView, ViewGroup parent){

        View v=convertView;

        if (v==null){
            holder= new ViewHolder();
            v=inflater.inflate(Resoruce,null);
            holder.textCode=(TextView)v.findViewById(R.id.lblCode);
            holder.textDay=(TextView)v.findViewById(R.id.lblDay);
            holder.textDate=(TextView)v.findViewById(R.id.lblDate);
            holder.textHigh=(TextView)v.findViewById(R.id.lblHighTemp);
            holder.textLow=(TextView)v.findViewById(R.id.lblLowTemp);
            holder.textTemp=(TextView)v.findViewById(R.id.lblTemp);
            holder.img=(ImageView)v.findViewById(R.id.tempImg);
            v.setTag(holder);


        }else{
            holder=(ViewHolder)v.getTag();
        }
            holder.textCode.setText(listItem.get(postion).getCode());
            holder.textDate.setText(listItem.get(postion).getDate());
            holder.textDay.setText(listItem.get(postion).getDay());
            holder.textTemp.setText(listItem.get(postion).getText());
            holder.textHigh.setText(listItem.get(postion).getHigh());
            holder.textLow.setText(listItem.get(postion).getLow());
        code = listItem.get(postion).getCode();

        /*resourceId =  Resources.getSystem().getIdentifier("drawable/icon_" + code, null, MainActivity.PACKAGE_NAME);
        Drawable weatherIconDrawable = Resources.getSystem().getDrawable(resourceId);
        holder.img.setImageDrawable(weatherIconDrawable);*/

        if(code.equals("0") ){
            holder.img.setImageResource(R.drawable.icon_0);
        }else if (code.equals("1")){
            holder.img.setImageResource(R.drawable.icon_1);
        }
        else if(code.equals("2") ){
            holder.img.setImageResource(R.drawable.icon_2);
        }else if (code.equals("3")){
            holder.img.setImageResource(R.drawable.icon_3);
        } else if(code.equals("4") ){
            holder.img.setImageResource(R.drawable.icon_4);
        }else if (code.equals("5")){
            holder.img.setImageResource(R.drawable.icon_5);
        } else if(code.equals("6") ){
            holder.img.setImageResource(R.drawable.icon_6);
        }else if (code.equals("7")){
            holder.img.setImageResource(R.drawable.icon_7);
        } else if(code.equals("8") ){
            holder.img.setImageResource(R.drawable.icon_8);
        }else if(code.equals("9")){
            holder.img.setImageResource(R.drawable.icon_9);
        } else if(code.equals("10") ){
            holder.img.setImageResource(R.drawable.icon_10);
        }else if(code.equals("11")){
            holder.img.setImageResource(R.drawable.icon_11);
        } else if(code.equals("12") ){
            holder.img.setImageResource(R.drawable.icon_12);
        }else if(code.equals("13")){
            holder.img.setImageResource(R.drawable.icon_13);
        } else if(code.equals("14") ){
            holder.img.setImageResource(R.drawable.icon_14);
        }else if(code.equals("15")){
            holder.img.setImageResource(R.drawable.icon_15);
        } else if(code.equals("16") ){
            holder.img.setImageResource(R.drawable.icon_16);
        }else if (code.equals("17")){
            holder.img.setImageResource(R.drawable.icon_17);
        }else if(code.equals("18") ){
            holder.img.setImageResource(R.drawable.icon_18);
        }else if (code.equals("19")){
            holder.img.setImageResource(R.drawable.icon_19);
        } else if(code.equals("20") ){
            holder.img.setImageResource(R.drawable.icon_20);
        }else if(code.equals("21")){
            holder.img.setImageResource(R.drawable.icon_21);
        }else if(code.equals("22") ){
            holder.img.setImageResource(R.drawable.icon_22);
        }else if(code.equals("23")){
            holder.img.setImageResource(R.drawable.icon_23);
        }else if(code.equals("24") ){
            holder.img.setImageResource(R.drawable.icon_24);
        }else if(code.equals("25")){
            holder.img.setImageResource(R.drawable.icon_25);
        }else if(code.equals("26") ){
            holder.img.setImageResource(R.drawable.icon_26);
        }else if(code.equals("27")){
            holder.img.setImageResource(R.drawable.icon_27);
        } else if(code.equals("28") ){
            holder.img.setImageResource(R.drawable.icon_28);
        }else if(code.equals("29")){
            holder.img.setImageResource(R.drawable.icon_29);
        }else if(code.equals("30") ){
            holder.img.setImageResource(R.drawable.icon_30);
        }else if(code.equals("31")){
            holder.img.setImageResource(R.drawable.icon_31);
        } else if(code.equals("32") ){
            holder.img.setImageResource(R.drawable.icon_32);
        }else if(code.equals("33")){
            holder.img.setImageResource(R.drawable.icon_33);
        }else  if(code.equals("34") ){
            holder.img.setImageResource(R.drawable.icon_34);
        }else if(code.equals("35")){
            holder.img.setImageResource(R.drawable.icon_35);
        } else if(code.equals("36") ){
            holder.img.setImageResource(R.drawable.icon_36);
        }else if (code.equals("37")){
            holder.img.setImageResource(R.drawable.icon_37);
        }else  if(code.equals("38") ){
            holder.img.setImageResource(R.drawable.icon_38);
        }else if(code.equals("39")){
            holder.img.setImageResource(R.drawable.icon_39);
        }else if(code.equals("40") ){
            holder.img.setImageResource(R.drawable.icon_40);
        }else if (code.equals("41")) {
            holder.img.setImageResource(R.drawable.icon_41);
        } else if(code.equals("42") ){
            holder.img.setImageResource(R.drawable.icon_42);
        }else if(code.equals("43")){
            holder.img.setImageResource(R.drawable.icon_43);
        } else if(code.equals("44") ){
            holder.img.setImageResource(R.drawable.icon_44);
        }else if(code.equals("45")){
            holder.img.setImageResource(R.drawable.icon_45);
        } else if(code.equals("46") ){
            holder.img.setImageResource(R.drawable.icon_46);
        }else if(code.equals("47")){
            holder.img.setImageResource(R.drawable.icon_47);
        }



        return v;

    }
}
