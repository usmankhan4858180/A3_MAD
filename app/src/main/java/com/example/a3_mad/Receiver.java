package com.example.a3_mad;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by DEll1 on 12/9/2017.
 */
public class Receiver extends BroadcastReceiver {

    Boolean b;


    @Override
    public void onReceive(Context context, Intent intent) {

        EventBus.getDefault().register(this);

    }

    @Subscribe
    public void onEvent(EventClass event) {
        b = event.getaBoolean();

    }
}
