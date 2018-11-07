package com.stdio.lz.file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    final String FILE_NAME = "crazyit.bin";

    private Button readBtn;
    private Button writeBtn;

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readBtn=(Button)findViewById(R.id.read);
        writeBtn=(Button)findViewById(R.id.write);

        resultTextView=(TextView)findViewById(R.id.result);

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setText(read());
            }
        });

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write(resultTextView.getText().toString());
            }
        });
    }

    private String read()
    {
        try
        {
            // 打开文件输入流
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder("");
            while ((hasRead = fis.read(buff)) > 0)
            {
                sb.append(new String(buff, 0, hasRead));
            }
            return sb.toString();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private void write(String content)
    {
        try
        {
            // 以追加模式打开文件输出流
            FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
            // 将FileOutputStream包装成PrintStream
            PrintStream ps = new PrintStream(fos);
            // 输出文件内容
            ps.println(content);
            ps.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
