package com.example.ejercicio2notificationwear;





import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button notifybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notifybtn = findViewById(R.id.button);
if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
    NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
    NotificationManager manager = getSystemService(NotificationManager.class);
    manager.createNotificationChannel(channel);
}
        notifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
                builder.setContentTitle("Ejercio 2 Notificación");
                builder.setContentText("Estamos probando notificaciones para los wearables");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });
    }
//    public void sendNotification(View view){
//        int notificationID = 1;
//        String id = "my_chanel_01";
////        String eventId = "1";
//        Intent viewIntent = new Intent(this,NotifyActivity.class);
//        viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
//        PendingIntent viewPendingIntent = PendingIntent.getActivity(this,0,viewIntent,0);
//        NotificationCompat.Builder notificacitionBuilder= new NotificationCompat.Builder(this,id)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Ejercicio Notificación")
//                .setContentText("Esta es una notificación de ejercicio 2")
//                .setContentIntent(viewPendingIntent);
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//        notificationManager.notify(notificationID,notificacitionBuilder.build());
//    }
}