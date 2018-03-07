package com.example.color;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;
    private int o;
    private int highScore;



    private CoordinatorLayout mCLayout;
    private Button mButton;
    private TextView mTextView;
    private TextView mTextView2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        o=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();
        mActivity = MainActivity.this;

        // Get the widget reference from XML layout
        mCLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mButton = (Button) findViewById(R.id.btn);
        mTextView = (TextView) findViewById(R.id.tv);
        mTextView2 = (TextView) findViewById(R.id.textView2);

        mCLayout.setBackgroundColor(Color.RED);
        mTextView.setTextColor(Color.BLUE);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextView2.setText("Aikaa jäljellä: " + millisUntilFinished / 1000);


            }

            public void onFinish() {
                Intent intent =new Intent(getApplicationContext(), result.class);
                intent.putExtra("SCORE", o);
                startActivity(intent);
            }
        }.start();






        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(o%20==0 && o!=0){
                    mCLayout.setBackgroundColor(Color.WHITE);
                    mTextView.setTextColor(Color.BLACK);
                    mTextView.setText("LOPETA JO!");
                    mTextView.setTextSize(50);
                    mTextView2.setTextColor(Color.BLACK);

                }
 else if(o%5==0 && o!=0){
                    mCLayout.setBackgroundColor(Color.GREEN);
                    mTextView.setTextColor(Color.WHITE);
                    mTextView.setText("BÖÖÖÖ");
                    mTextView.setTextSize(100);
                    mTextView2.setTextColor(Color.WHITE);

                }
               else if(o%2==0) {
                    mCLayout.setBackgroundColor(Color.RED);
                    mTextView.setTextColor(Color.BLUE);
     mTextView.setText("Hello!");
                    mTextView.setTextSize(50);
                    mTextView2.setTextColor(Color.WHITE);
                }
                else {
                    mCLayout.setBackgroundColor(Color.BLUE);
                    mTextView.setTextColor(Color.RED);
                    mTextView.setText("Hello!");
                    mTextView.setTextSize(50);
                    mTextView2.setTextColor(Color.WHITE);
                }



                o++;


                mButton.setText("* "+o+" *");

            }

        });
    }
    public void lopeta(View view){
        Intent intent =new Intent(getApplicationContext(), result.class);
        intent.putExtra("SCORE", o);
        startActivity(intent);

    }

 
}
