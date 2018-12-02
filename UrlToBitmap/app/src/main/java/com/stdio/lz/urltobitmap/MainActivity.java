package com.stdio.lz.urltobitmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends Activity {

    String imageUri="https://pixabay.com/get/ea32b4062df3023ed1534705fb09439fe476e4dd18ac104491f3c67aa3eab2b0/walnut-3759573_1920.jpg?attachment";
    ImageView imageView;

    Button button;
    ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.result);
        button =findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    imageLoader.displayImage(imageUri, imageView);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
