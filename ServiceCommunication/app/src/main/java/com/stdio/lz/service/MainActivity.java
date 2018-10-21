package com.stdio.lz.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private Button communicationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn=(Button)findViewById(R.id.start);
        communicationBtn=(Button)findViewById(R.id.comunication);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
        communicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsgToService();
            }
        });
    }

    private void startService(){
        Intent intent=new Intent(this,TestService.class);
        startService(intent);
    }

    private void sendMsgToService(){
        Intent intent=new Intent("com.stdio.lz.service");
        intent.putExtra("test", "test");
        sendBroadcast(intent);
    }
}
