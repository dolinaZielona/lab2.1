package com.example.lab21;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView naladowanie, stan, zrodloZasilania, czyDostepna, poziom, technologia, temp, napiecie;
    ProgressBar progressBar;
    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    Intent batteryStatus;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            naladowanie.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)));
            stan.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0)));

            zrodloZasilania.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)));
            czyDostepna.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_PRESENT, 0)));

            poziom.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0)));

            technologia.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_TECHNOLOGY, 0)));

            temp.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)));

            napiecie.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0)));

            czyDostepna.setText(String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_PRESENT, 0)));
            progressBar.setMax(100);
            progressBar.setProgress(intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        naladowanie = findViewById(R.id.wartoscNaladowania);

        progressBar = findViewById(R.id.progressBar);
        stan = findViewById(R.id.wartoscStanu);
        zrodloZasilania = findViewById(R.id.wartoscZrodlaNaladowania);
        czyDostepna = findViewById(R.id.wartoscDostepnosci);
        poziom = findViewById(R.id.wartoscPoziomu);
        technologia = findViewById(R.id.wartoscTechnologii);
        temp = findViewById(R.id.wartoscTemperatury);
        napiecie = findViewById(R.id.wartoscNapiecia);

        batteryStatus = registerReceiver(broadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }

}
