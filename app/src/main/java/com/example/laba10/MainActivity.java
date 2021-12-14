package com.example.laba10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mDialButton = (Button) findViewById(R.id.button2);
        final EditText mPhoneNoEt = (EditText)
                findViewById(R.id.editTextPhone);
        final EditText smsEdit = (EditText) findViewById(R.id.editTextTextMultiLine2);
        mDialButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String phoneNo = mPhoneNoEt.getText().toString();
                if(!TextUtils.isEmpty(phoneNo))
                {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_CALL,
                            Uri.parse(dial)));
                }
                else {
                    Toast.makeText(MainActivity.this, "Введите номер телефона",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onSms(View view) {
        EditText edit_Number=(EditText)findViewById(R.id.editTextPhone);
        String phoneNo = edit_Number.getText().toString();
        EditText sms_edit=(EditText)findViewById(R.id.editTextTextMultiLine2);
        String toSms="smsto:"+edit_Number.getText().toString();
        String messageText= sms_edit.getText().toString();
        Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse(toSms));
        sms.putExtra("sms_body", messageText);
        startActivity(sms);
        SmsManager.getDefault().sendTextMessage(phoneNo, null,
                messageText.toString(), null, null);
    }
}