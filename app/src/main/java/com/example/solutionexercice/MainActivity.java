package com.example.solutionexercice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    RadioGroup grp;
    float xInitial;
    int[] MesRds = {R.id.rd1,R.id.rd2,R.id.rd3,R.id.rd4};
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.im);
        grp = findViewById(R.id.grp);
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (grp.getCheckedRadioButtonId()){
                    case R.id.rd1:image.setImageResource(R.drawable.image1); pos=0; break;
                    case R.id.rd2:image.setImageResource(R.drawable.image2); pos=1; break;
                    case R.id.rd3:image.setImageResource(R.drawable.image3); pos=2; break;
                    case R.id.rd4:image.setImageResource(R.drawable.image4); pos=3; break;
                }
            }
        });

        grp.check(R.id.rd1);

        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        xInitial = motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        float xFinal = motionEvent.getX();

                        if(xInitial<xFinal)
                            pos--;
                        else
                            pos++;

                        if(pos<0)
                            pos = MesRds.length-1;
                        else if(pos>=MesRds.length)
                            pos=0;

                        grp.check(MesRds[pos]);
                        break;
                }
                return true;
            }
        });

    }
}