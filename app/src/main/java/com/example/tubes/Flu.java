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

public class Flu extends AppCompatActivity {
    Button send;
    private static final String Tag="Flu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flu);

        send = (Button) findViewById(R.id.smsdoctor);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nmr = String.format("smsto: %s","081212982933");
                String sms = "Halo Dokter John Doe, Saya Ingin Membuat Appointment untuk Menemui Anda pada:\nTanggal: \nJam: \nDiagnosa Awal: Flu\nKeperluan:";
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
