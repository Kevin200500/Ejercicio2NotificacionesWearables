package com.example.ejercicio2notificationwear;





import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
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
//                Intent i = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("geo:0,0?q=universidad+tecnologica+de+chihuahua"));
                Intent i = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:6142517317"));
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,i,0);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
                builder.setContentTitle("Ejercio 2 Notificación");
                builder.setContentText(Html.fromHtml("<b>Ejercicio</b>"+
                        " de <u>práctica</u> "+"de <u><i>aviso de notificación</i></u>"));
                builder.setContentIntent(pendingIntent);
//                builder.addAction(R.drawable.ic_launcher_background,"Mapa UTCH",pendingIntent);
                builder.addAction(R.drawable.ic_launcher_background, "llamar",pendingIntent);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });
    }
}