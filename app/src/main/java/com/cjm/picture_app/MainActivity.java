package com.cjm.picture_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //    region Init
    ArrayList<Integer> IMGS = new ArrayList<>();
    int pic_num, now_img;
    BitmapDrawable bitmap;
    //    endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  region Create then Init
        Resources res = getResources();
        for (int i = 0; i < 30; i++) {
            String img_name = "image" + (i + 1);
            IMGS.add(res.getIdentifier(img_name, "drawable", getPackageName()));
        }
        //  endregion

        // region Id declare
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        EditText editText = (EditText) findViewById(R.id.editText);
        Button button_prev = (Button) findViewById(R.id.button_prev);
        Button button_next = (Button) findViewById(R.id.button_next);
        // endregion

        // region Initial setting
        bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(0));
        now_img = 1;
        editText.setText(Integer.toString(now_img));
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
        imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
        // endregion

        // region Button Function
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                int text = (int) Math.round(Double.parseDouble(textView.getText().toString()));

                switch (i) {
                    // Search button
                    case android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH:
                        Toast.makeText(MainActivity.this, "Search button", Toast.LENGTH_SHORT).show();
                        break;

                    // Enter button
                    default:
                        if(text == 0){
                            Toast.makeText(MainActivity.this, "사진은 1~30까지만 있습니다.", Toast.LENGTH_SHORT).show();
                            now_img = 1;
                            editText.setText(Integer.toString(now_img));
                            bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(now_img-1));
                            imageView.setImageDrawable(bitmap);
                            imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
                            imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
                            imageView.setImageDrawable(bitmap);
                        }else  if(text < 1){
                            Toast.makeText(MainActivity.this, "사진은 1~30까지만 있습니다.", Toast.LENGTH_SHORT).show();
                            now_img = 1;
                            editText.setText(Integer.toString(now_img));
                            bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(now_img-1));
                            imageView.setImageDrawable(bitmap);
                            imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
                            imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
                            imageView.setImageDrawable(bitmap);
                        }else if(text >30){
                            Toast.makeText(MainActivity.this, "사진은 1~30까지만 있습니다.", Toast.LENGTH_SHORT).show();
                            now_img = 30;
                            editText.setText(Integer.toString(now_img));
                            bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(now_img-1));
                            imageView.setImageDrawable(bitmap);
                            imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
                            imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
                            imageView.setImageDrawable(bitmap);
                        }else {
                            now_img = text;
                            editText.setText(Integer.toString(now_img));
                            bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(now_img-1));
                            imageView.setImageDrawable(bitmap);
                            imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
                            imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
                            imageView.setImageDrawable(bitmap);
                        }

                        return false;
                }

                // reset
                textView.clearFocus();
                textView.setFocusable(false);
                textView.setText("");
                textView.setFocusableInTouchMode(true);
                textView.setFocusable(true);

                return true;
            }
        });

        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now_img <= 1) {
                    Toast.makeText(MainActivity.this, "사진은 1~30까지만 있습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    now_img--;
                    bitmap = (BitmapDrawable) res.getDrawable(IMGS.get(now_img - 1));
                    imageView.setImageDrawable(bitmap);
                    imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
                    imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
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
                    imageView.setImageDrawable(bitmap);
                    imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
                    imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
                    imageView.setImageDrawable(bitmap);
                    editText.setText(Integer.toString(now_img));
                }
            }
        });
        // endregion

    }


}