package com.stdio.lz.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class TestService  extends Service {

    private MyReciver receiver;

    @Override
    public void onCreate() {
        super.onCreate();
        receiver = new MyReciver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.stdio.lz.service");
        registerReceiver(receiver, filter);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy()
    {
        unregisterReceiver(receiver);
        receiver=null;
        super.onDestroy();
    }

    private void method_inservice()
    {
        Toast.makeText(getApplicationContext(), "我的服务的方法……", Toast.LENGTH_SHORT).show();
    }


    private class MyReciver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context arg0, Intent arg1)
        {
            System.out.println("内部接收者");
            method_inservice();
        }

    }
}
