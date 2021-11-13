package com.example.ejercicio2notificationwear;





import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
                String Text = "De forma predeterminada, el contenido de texto de la notificación se trunca para que quepa en una línea. Si deseas que la notificación sea más larga," +
                        " puedes habilitar una notificación expandible. Para ello, debes agregar una plantilla de estilo con setStyle().\n" +
                        "Una notificación básica generalmente incluye un título, una línea de texto y una o varias acciones que el usuario pu" +
                        "ede realizar como respuesta. A fin de proporcionar información adicional, también puedes crear notificaciones grandes" +
                        " y expandibles mediante una de las tantas plantillas de notificaciones, como se describe en esta página.\n" +
                        "Para comenzar, crea una notificación con todo el contenido básico, según se describe en Cómo crear una notificación. Luego, llama a setStyle() con un objeto de estilo " +
                        "y proporciona la información correspondiente a cada plantilla, como se muestra debajo.";


                String logo = "utch";
                int image = getResources().getIdentifier(logo,"drawable",getPackageName());
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),image);

                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.bigText(Text);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,i,0);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
                builder.setContentTitle("Ejercio 2 Notificación");
//                builder.setContentText(Html.fromHtml(bigTextStyle.toString()));
                builder.setContentIntent(pendingIntent);
                builder.setStyle(bigTextStyle);
//                builder.addAction(R.drawable.ic_launcher_background,"Mapa UTCH",pendingIntent);
                builder.addAction(R.drawable.ic_launcher_background, "llamar",pendingIntent);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logo_ut));
                builder.setAutoCancel(true);
//                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });
    }
}