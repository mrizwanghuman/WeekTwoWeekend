package com.example.admin.weektwoweekend;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.renderscript.Sampler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Dialog dialog;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        };
    }

    public void viewPDF(View view) {

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("pdf.pdf").load();
    }

    public void showDialogFragFn(View view) {

        dialog = new Dialog(this);
        dialog.setTitle("World is beautiful");
        dialog.setContentView(R.layout.fragment_show_pic);
        TextView dialogFragTv = dialog.findViewById(R.id.dialogFragTv);

        dialogFragTv.setText("God is great");
dialog.show();

dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
    @Override
    public void onDismiss(DialogInterface dialogInterface) {

        handler.removeCallbacks(runnable);
    }
});
handler.postDelayed(runnable,1000);

    }

    public void onClickAlert(View view) {

        String title = "This is default alert box";
        String message = "Hurray!!! Working :)";


        AlertDialog.Builder defaultAlert = new AlertDialog.Builder(this);
        defaultAlert.setTitle(title);
        defaultAlert.setMessage(message);
        //
        defaultAlert.show();
    }

    public void customLayout(View view) {
CustomeAlertDialog customeAlertDialog = new CustomeAlertDialog(this);
customeAlertDialog.show();


    }

    public void sendNotification(View view) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, "com.example.admin.weektwoweekend")
                        .setSmallIcon(R.drawable.splashcard)
                        .setContentTitle("My notification").setDefaults(Notification.DEFAULT_ALL)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentText("Hello World!");
        Intent intent = new Intent(this, NotificationIntentAct.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pendingIntent);
        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    public void gotStopWatch(View view) {
        Intent intent = new Intent(this, StopWatchPractice.class);
        startActivity(intent);

    }

    public void sendSMS(View view) {
        Intent intent = new Intent(this, SendSMSAct.class );
        startActivity(intent);
    }

    public void goToStopWatch(View view) {
        Intent intent = new Intent(this, StopWatchPractice.class);
        startActivity(intent);
    }
}
