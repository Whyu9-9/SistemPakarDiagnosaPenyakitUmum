package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class help extends AppCompatActivity {
    Button send;
    private static final String Tag="help";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        send = (Button) findViewById(R.id.smsadmin);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nmr = String.format("smsto: %s","088236109829");
                String sms = "Halo Admin, Saya Mengalami Masalah Berikut pada Aplikasi Saya:";
                Intent smstoadmin = new Intent(Intent.ACTION_SENDTO);
                smstoadmin.setData(Uri.parse(nmr));
                smstoadmin.putExtra("sms_body",sms);
                if(smstoadmin.resolveActivity(getPackageManager())!=null){
                    startActivity(smstoadmin);
                }else{
                    Log.d(Tag, nmr);
                }
            }
        });
    }
}
