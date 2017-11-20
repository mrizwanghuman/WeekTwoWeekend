package com.example.admin.weektwoweekend;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.weektwoweekend.fragments.StopWatchNestedFrag;
import com.example.admin.weektwoweekend.fragments.StopWatchParentFrag;

import java.util.Timer;
import java.util.TimerTask;


public class StopWatchPractice extends AppCompatActivity implements StopWatchParentFrag.OnFragmentInteractionListener, StopWatchNestedFrag.OnFragmentInteractionListener {

    private static final String TAG = "Great";
    private TextView showStopWatchText;
    private Timer stopWatchTimer;
    int count=0;
    private StopWatchNestedFrag stopWatchNestedFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch_practice);

        StopWatchParentFrag stopWatchParentFrag = StopWatchParentFrag.newInstance("Value1", "Value");
        getSupportFragmentManager().beginTransaction().add(R.id.parentFrag, stopWatchParentFrag, "Parent Frag").commit();
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.fragment_stop_watch_nested,parent,true);
//        showStopWatchText = view.findViewById(R.id.timerShow);
        Button setStartEvent = findViewById(R.id.startEvent);
        Button setStopEvent = findViewById(R.id.stopEvent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void startStopWatch(View view) {
        Log.d(TAG, "startStopWatch: Working stop");
        stopWatchNestedFrag = StopWatchNestedFrag.newInstance("This", "Great");
        getSupportFragmentManager().beginTransaction().add(R.id.nestedStopWatchFrag, stopWatchNestedFrag,"Nested Frag").commit();

        stopWatchTimer = new Timer();
        stopWatchTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {

                        stopWatchNestedFrag.showStopWatch("Stopwatch = "+count);
                        count++;
                    }
                });
            }
        }, 1000, 1000);




    }

    public void stopStopWatch(View view) {
        Log.d(TAG, "stopStopWatch: ");

            //this is 'Pause' button click listener
        stopWatchTimer.cancel();

    }
}
