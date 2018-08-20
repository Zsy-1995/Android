package com.example.rts.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by RTS on 2018/8/20.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "receive in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
        abortBroadcast();//截断广播传播
    }
}
