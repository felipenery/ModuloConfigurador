package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConfigureSmartfone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_smartfone);
    }

    public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, FuncionalidadeConfiguracao.class);
        startActivity(secondActivity);
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long milliseconds = 1000;
        vibrator.vibrate(milliseconds);
    }
}
