package com.example.admin.weektwoweekend;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by  Admin on 11/18/2017.
 */

public class CustomeAlertDialog extends AlertDialog implements android.view.View.OnClickListener {



    private Activity newAct;

    protected CustomeAlertDialog(Activity a) {
        super(a);
this.newAct= a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.custom_alert_layout);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.planets_array, android.R.layout.simple_spinner_item);
        Spinner spinner = findViewById(R.id.planets_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        Button btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClose:
               this.dismiss();
        }
    }
}
