package com.example.twoactivity3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.twoactivity.R;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE="MESSAGE";
    private EditText mMessageEditText;
    private TextView mReplyTextView;
    public static final int TEXT_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_main);
        mReplyTextView=findViewById(R.id.text_message_reply);
    }

    public void  launchSecondActivity(View view) {
        //log.d(LOG_TAG,"Button Clicked!!")
        String message=mMessageEditText.getText().toString();

        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST){
            if(resultCode==RESULT_OK){
                String reply=data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyTextView.setText(reply);
            }
        }
    }


    public void LaunchSecondActivity(View view) {
    }
}
