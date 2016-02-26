package com.example.saurabhm.finalprojectv1;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Provides the notification.
 */
public class AlarmNotification extends IntentService{
    private NotificationManager alarmNotificationManager;
    public AlarmNotification() {
        super("AlarmNotification");
    }
    int notifID = 33;
  
    public void onHandleIntent(Intent intent) {

        Log.d("AlarmService", "Preparing to send notification...: " + "Wake Up!!");
        alarmNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, AlarmClock.class), 0);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Alarm")
                .setSmallIcon(R.drawable.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Wake up!!"))
                .setContentText("Wake Up !!");
        Intent moreInfoIntent = new Intent(this, WeatherGPS.class);

        // Used to stack tasks across activites so we go to the proper place when back is clicked
        TaskStackBuilder tStackBuilder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            tStackBuilder = TaskStackBuilder.create(this);
        }

        // Add all parents of this activity to the stack
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            tStackBuilder.addParentStack(WeatherGPS.class);
        }

        // Add our new Intent to the stack
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            tStackBuilder.addNextIntent(moreInfoIntent);
        }

        // Define an Intent and an action to perform with it by another application
        // FLAG_UPDATE_CURRENT : If the intent exists keep it but update it if needed
        PendingIntent pendingIntent = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            pendingIntent = tStackBuilder.getPendingIntent(0,
                    PendingIntent.FLAG_UPDATE_CURRENT);
        }

        // Defines the Intent to fire when the notification is clicked
        alamNotificationBuilder.setContentIntent(pendingIntent);
        alamNotificationBuilder.setAutoCancel(true);

       // alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmService", "Notification sent.");
    }
}
