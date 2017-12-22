package com.example.a3_mad;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.widget.CompoundButton;
import android.widget.Switch;

import org.greenrobot.eventbus.EventBus;
public class MainActivity extends AppCompatActivity {

    Switch w_switch;
    Switch A_switch;
    WifiManager wifiManager;
    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A_switch = (Switch) findViewById(R.id.switch1_airplane);
        w_switch = (Switch) findViewById(R.id.switch2_wifi);
        Boolean state = A_switch.isChecked();
        EventClass c = new EventClass();
        c.setaBoolean(state);
        EventBus.getDefault().post(c);
        wifiManager = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);

        w_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked && !wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);

                    PendingIntent pendingIntent = PendingIntent.getActivity(context:MainActivity.this, requestCode:0, i)
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context:MainActivity.this,I)
                    .setContentTitle("Notification")
                    .setsmallicon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent)
                    .setContentText(etMessage.getText().toString());
                    Notification notification = builder.build();
                    NotificationManage.notify(id:0, notification);

                } else if (!isChecked && wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(false);

                    PendingIntent pendingIntent = PendingIntent.getActivity(context:MainActivity.this, requestCode:0, i)
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context:MainActivity.this,I)
                    .setContentTitle("Notification")
                            .setsmallicon(R.drawable.ic_launcher_background)
                            .setContentIntent(pendingIntent)
                            .setContentText(etMessage.getText().toString());
                    Notification notification = builder.build();
                    NotificationManage.notify(id:0, notification);
                }
            }
        });


    }
}
