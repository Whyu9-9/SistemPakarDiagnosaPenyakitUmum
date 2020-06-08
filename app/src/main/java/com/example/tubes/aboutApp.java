package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class aboutApp extends AppCompatActivity {
    Button alamat;
    private static final String Tag="aboutApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        alamat = (Button) findViewById(R.id.alamatadmin);
        alamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = String.format("geo: 0, 0?q=%s","Jalan Narakesuma no 39");
                Uri add = Uri.parse(address);
                Intent alamatadmin = new Intent(Intent.ACTION_VIEW,add);
                alamatadmin.setPackage("com.google.android.apps.maps");
                if (alamatadmin.resolveActivity(getPackageManager())!=null){
                    startActivity(alamatadmin);
                }else {
                    Log.d(Tag,address);
                }
            }
        });
    }
}
