package com.example.a2026_04_01;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CH_HIGH = "high_priority_channel";
    private static final String CH_LOW = "low_priority_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannels();

        findViewById(R.id.btn1).setOnClickListener(v -> sendNotification(CH_HIGH, Activity2.class, 1, NotificationCompat.PRIORITY_HIGH));
        findViewById(R.id.btn2).setOnClickListener(v -> sendNotification(CH_LOW, Activity3.class, 2, NotificationCompat.PRIORITY_LOW));
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nm = getSystemService(NotificationManager.class);
            NotificationChannel high = new NotificationChannel(CH_HIGH, "Wysoki", NotificationManager.IMPORTANCE_HIGH);
            NotificationChannel low = new NotificationChannel(CH_LOW, "Niski", NotificationManager.IMPORTANCE_LOW);

            nm.createNotificationChannel(high);
            nm.createNotificationChannel(low);
        }
    }

    private void sendNotification(String channelId, Class<?> targetActivity, int id, int priority) {
        Intent intent = new Intent(this, targetActivity);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, id, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Powiadomienie " + (id == 1 ? "Wysokie" : "Niskie"))
                .setContentText("Kliknij, aby otworzyć aktywność")
                .setPriority(priority)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        getSystemService(NotificationManager.class).notify(id, builder.build());
    }
}