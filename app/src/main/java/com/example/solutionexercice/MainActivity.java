package com.example.solutionexercice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    RadioGroup grp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.im);
        grp = findViewById(R.id.grp);
        int[] mesImages = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (grp.getCheckedRadioButtonId()){
                    case R.id.rd1:image.setImageResource(mesImages[0]); break;
                    case R.id.rd2:image.setImageResource(mesImages[1]);break;
                    case R.id.rd3:image.setImageResource(mesImages[2]);break;
                    case R.id.rd4:image.setImageResource(mesImages[3]);break;
                }
            }
        });

        grp.check(R.id.rd1);

    }
}