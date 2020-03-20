package ufabc.projeto.moduloconfigurador;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Context;
import android.accessibilityservice.AccessibilityService;
import android.app.Notification;
import android.os.AsyncTask;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.SystemClock;


public class AtivarFlashAlertas extends AppCompatActivity {



    private Button simBotao;
    private Button naoBotao;

    private ImageView iconeLibras;
    private ImageView close;
    Dialog Mydialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativar_flash_alertas);

        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);

        iconeLibras = (ImageView) findViewById(R.id.imageView3);






        simBotao.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {



            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AtivarFlashAlertas.this,PiscarFlashSilenciar.class));
            }
        });

        iconeLibras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AtivarFlashAlertas.this,VideoPiscarFlashSilenciar.class));
            }
        });



    }


/*
    public void MyCustomAlertDialog(){
        Mydialog = new Dialog(AtivarFlashAlertas.this);

        Mydialog.setContentView(R.layout.customdialog);

        Mydialog.setTitle("Meu primeiro teste");

        close = (ImageView) Mydialog.findViewById(R.id.close);
        close.setEnabled(true);



        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mydialog.cancel();
            }
        });

        Mydialog.show();
    }

   */

}
