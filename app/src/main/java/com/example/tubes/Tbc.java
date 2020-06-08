package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Tbc extends AppCompatActivity {
    Button call;
    private static final String Tag="Tbc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbc);

        call = (Button) findViewById(R.id.calldoctor);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:0882193890"));
            startActivity(callIntent);
            }
        });
    }
}
