package com.example.admin.weektwoweekend;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSAct extends AppCompatActivity {

    private static final String TAG = "SMSManager";
    private EditText phoneNum;
    private EditText textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        phoneNum = findViewById(R.id.phoneNum);
        textMessage = findViewById(R.id.textMessage);
    }

    public void sendTextSMS(View view) {

        String numberTosend = phoneNum.getText().toString();
        String myMyMsg = textMessage.getText().toString();
        Log.d(TAG, "sendTextSMS: "+myMyMsg);
        sendMsg(numberTosend, myMyMsg);

    }
    protected void sendMsg(String number, String textMsg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS could not sent", Toast.LENGTH_SHORT).show();
        e.printStackTrace();
        }
    }
}
