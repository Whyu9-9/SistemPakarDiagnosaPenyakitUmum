package com.example.tubes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    CheckBox cekskepala,
            cekdemam,
            cekhidungt,
            cektenggorokang,
            cekbatukb,
            cekbersin,
            cekmatab,
            ceksdada,
            cekbatukk,
            ceknafassesak,
            ceksusahtidur,
            ceksulitmenelan;
    Button diagnose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cekskepala = (CheckBox) findViewById(R.id.checkBox);
        cekdemam = (CheckBox) findViewById(R.id.checkBox2);
        cekhidungt = (CheckBox) findViewById(R.id.checkBox3);
        cektenggorokang = (CheckBox) findViewById(R.id.checkBox4);
        ceksdada = (CheckBox) findViewById(R.id.checkBox5);
        cekbatukb = (CheckBox) findViewById(R.id.checkBox6);
        cekbersin = (CheckBox) findViewById(R.id.checkBox7);
        cekmatab = (CheckBox) findViewById(R.id.checkBox8);
        cekbatukk = (CheckBox) findViewById(R.id.checkBox9);
        ceknafassesak = (CheckBox) findViewById(R.id.checkBox10);
        ceksusahtidur = (CheckBox) findViewById(R.id.checkBox11);
        ceksulitmenelan = (CheckBox) findViewById(R.id.checkBox12);

        diagnose = (Button)findViewById(R.id.buttondiag);
        diagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert!");
        alertDialogBuilder
                .setMessage("Apakah Anda Yakin Sudah benar?")
                .setIcon(R.mipmap.puskesmas)
                .setCancelable(false)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (cekskepala.isChecked() && cekdemam.isChecked() && cekhidungt.isChecked() && cekbersin.isChecked()){
                            Intent flu = new Intent(MainActivity.this, Flu.class);
                            startActivity(flu);
                        }else if (cekdemam.isChecked() && cekhidungt.isChecked() && cekbersin.isChecked() && cekmatab.isChecked()){
                            Intent flu = new Intent(MainActivity.this, Flu.class);
                            startActivity(flu);
                        }else if (cekhidungt.isChecked() && cekbersin.isChecked()){
                            Intent flu = new Intent(MainActivity.this, Flu.class);
                            startActivity(flu);
                        }else if (cekdemam.isChecked() && cekbatukb.isChecked() && ceksdada.isChecked() && ceknafassesak.isChecked()){
                            Intent tbc = new Intent(MainActivity.this, Tbc.class);
                            startActivity(tbc);
                        }else {
                            Intent lain = new Intent(MainActivity.this, Lainnya.class);
                            startActivity(lain);
                        }
                    }
                })
                .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox)view).isChecked();
        String str = "";
        switch (view.getId()){
            case R.id.checkBox:
                str = checked?"Gejala Sakit Kepala dipilih":"Gejala Sakit Kepala tidak dipilih";
                break;
            case R.id.checkBox2:
                str = checked?"Gejala Demam dipilih":"Gejala Demam tidak dipilih";
                break;
            case R.id.checkBox3:
                str = checked?"Gejala Hidung Tersumbat dipilih":"Gejala Hidung Tersumbat tidak dipilih";
                break;
            case R.id.checkBox4:
                str = checked?"Gejala Tenggorokan Gatal dipilih":"Gejala Tenggorokan Gatal tidak dipilih";
                break;
            case R.id.checkBox5:
                str = checked?"Gejala Sakit di Bagian Dada dipilih":"Gejala Sakit di Bagian Dada tidak dipilih";
                break;
            case R.id.checkBox6:
                str = checked?"Gejala Batuk Berdahak dipilih":"Gejala Batuk Berdahak tidak dipilih";
                break;
            case R.id.checkBox7:
                str = checked?"Gejala Bersin-bersin dipilih":"Gejala Bersin-bersin tidak dipilih";
                break;
            case R.id.checkBox8:
                str = checked?"Gejala Mata Berair dipilih":"Gejala Mata Berair tidak dipilih";
                break;
            case R.id.checkBox9:
                str = checked?"Gejala Batuk Kering dipilih":"Gejala Batuk Kering tidak dipilih";
                break;
            case R.id.checkBox10:
                str = checked?"Gejala Nafas Sesak dipilih":"Gejala Nafas Sesak tidak dipilih";
                break;
            case R.id.checkBox11:
                str = checked?"Gejala Susah Tidur dipilih":"Gejala Susah Tidur tidak dipilih";
                break;
            case R.id.checkBox12:
                str = checked?"Gejala Kesulitan Menelan dipilih":"Gejala Kesulitan Menelan tidak dipilih";
                break;
        }
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            Intent about = new Intent(MainActivity.this, aboutApp.class);
            startActivity(about);
        } else if (item.getItemId() == R.id.help) {
            Intent help = new Intent(MainActivity.this, help.class);
            startActivity(help);
        }else if (item.getItemId() == R.id.ambulance) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:119"));
            startActivity(callIntent);
        }
        return true;
    }

}
