package com.example.saurabhm.finalprojectv1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
//This class provides the weather daya based on location
public class WeatherGPS extends Activity {
    ArrayList<Forecast> listItem;
    ForecastAdapter adp;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_gps);

        listItem=new ArrayList<Forecast> ();

        new JSONAsyncTask().execute("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
        //Uses yahoo api calls to retreive weather data
        ListView lv = (ListView) findViewById(R.id.listView);
        adp = new ForecastAdapter(getApplicationContext(), R.layout.activity_list_item, listItem);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long Id) {
                Toast.makeText(getApplicationContext(), listItem.get(position).getText(), Toast.LENGTH_LONG).show();
            }
        });




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog pd;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(WeatherGPS.this);
            pd.setMessage("Please wait");
            pd.setTitle("Connecting...");
            pd.show();
            pd.setCancelable(false);

        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                HttpGet httppost = new HttpGet(params[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse respone = httpclient.execute(httppost);

                int status = respone.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = respone.getEntity();
                    String data = EntityUtils.toString(entity);

                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast");
                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject obj3 = jarray.getJSONObject(i);

                        Forecast forecast = new Forecast();

                        forecast.setCode(obj3.getString("code"));
                        forecast.setDate(obj3.getString("date"));
                        forecast.setDay(obj3.getString("day"));
                        forecast.setHigh(obj3.getString("high"));
                        forecast.setLow(obj3.getString("low"));
                        forecast.setText(obj3.getString("text"));

                        listItem.add(forecast);

                    }

                    return true;

                }

            } catch (IOException e) {
                e.printStackTrace();

            } catch (JSONException e) {
                e.printStackTrace();

            }
            catch(Exception e){
                e.printStackTrace();
            }
            return false;
        }


        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            pd.cancel();
            adp.notifyDataSetChanged();
            if (result == false)
                Toast.makeText(getApplicationContext(), "Unable to fetch data from the server", Toast.LENGTH_LONG).show();

        }

    }


}

