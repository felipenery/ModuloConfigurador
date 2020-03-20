package ufabc.projeto.moduloconfigurador;

import android.Manifest;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManager;
import android.app.Instrumentation;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiAutomation;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.os.Build;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.security.cert.Extension;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AtivarLeitorTela extends ConfigAll  {

    private Button simBotao;
    private Button naoBotao;
    private Button mostrarBotao;
    private ImageView iconeBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativar_leitor_tela);

        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        mostrarBotao = (Button) findViewById(R.id.mostrarId);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);




        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {

                    int resukt = textToSpeech.setLanguage(Locale.forLanguageTag("BR"));
                    if (resukt == TextToSpeech.LANG_MISSING_DATA

                            || resukt == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Linguagem não suportada");
                    } else {
                       // iconeSom.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Falha");
                }
            }
        });



        simBotao.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {
              // startActivityForResult(new Intent(Settings.ACTION_CAPTIONING_SETTINGS),0); LEGENDA
                ativarOLeitorTela = 1;
                click(ativarOLeitorTela);
                startActivity(new Intent(AtivarLeitorTela.this,VelocidadeFala.class));

               // startActivityForResult(new Intent(Settings.ACTION_DISPLAY_SETTINGS),0);  FONT TIPO NEGRITO
               
               // startActivityForResult(new Intent(Settings.ACTION_NIGHT_DISPLAY_SETTINGS),0); Night Light



            }




        });



        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ativarOLeitorTela = 0;
                click(ativarOLeitorTela);
                //startActivity(new Intent(AtivarLeitorTela.this,AtivarZoom.class));
                startActivity(new Intent(AtivarLeitorTela.this,CorFundoTexto.class));
            }
        });



        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.texto_info_leitor_tela);
            }
        });


        mostrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Deseja ativar o leitor de tela ";

                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);

                //startActivity(new Intent(AtivarLeitorTela.this,DisponivelLegendaSurdo.class));
               // startActivityForResult(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS),0);


            }
        });




}

    public void click(int ativarOLeitorTela){
        //((ConfigHelper) this.getApplication()).setAtivarOLeitorTela(ativarOLeitorTela);
        sharedPreferences.edit().putInt(KEY_ATIVAR_LEITOR_TELA , ativarOLeitorTela).commit();




    }


    @Override
    public void onInit(int i) {

    }
}