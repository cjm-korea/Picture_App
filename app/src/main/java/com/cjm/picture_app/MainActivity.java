package com.cjm.picture_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //    region Init
    ArrayList<Integer> IMGS = new ArrayList<>();
    int pic_num, now_img;
    BitmapDrawable bitmap;
    EditText editText;

    //    endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        for (int i = 0; i < 30; i++) {
            String img_name = "image" + (i + 1);
            IMGS.add(res.getIdentifier(img_name, "drawable", getPackageName()));
        }

//        region  Id declare
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText);
        Button button_prev = (Button) findViewById(R.id.button_prev);
        Button button_next = (Button) findViewById(R.id.button_next);
//        endregion

//        region Initial setting

//        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image1);
        bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(0));
        now_img = 1;
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;

//        endregion

        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now_img <= 1) {
                    Toast.makeText(MainActivity.this, "사진은 1~30까지만 있습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    now_img--;
                    bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(now_img - 1));
                    int bitmapWidth = bitmap.getIntrinsicWidth();
                    int bitmapHeight = bitmap.getIntrinsicHeight();
                    imageView.setImageDrawable(bitmap);
                    imageView.getLayoutParams().width = bitmapWidth;
                    imageView.getLayoutParams().height = bitmapHeight;
                    imageView.setImageDrawable(bitmap);
                    editText.setText(Integer.toString(now_img));
                }
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now_img >= 30) {
                    Toast.makeText(MainActivity.this, "사진은 1~30까지만 있습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    now_img++;
                    bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(now_img - 1));
                    int bitmapWidth = bitmap.getIntrinsicWidth();
                    int bitmapHeight = bitmap.getIntrinsicHeight();
                    imageView.setImageDrawable(bitmap);
                    imageView.getLayoutParams().width = bitmapWidth;
                    imageView.getLayoutParams().height = bitmapHeight;
                    imageView.setImageDrawable(bitmap);
                    editText.setText(Integer.toString(now_img));
                }
            }
        });


    }
}