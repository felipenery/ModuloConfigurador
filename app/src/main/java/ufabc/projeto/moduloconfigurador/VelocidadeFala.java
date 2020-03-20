package ufabc.projeto.moduloconfigurador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class VelocidadeFala extends ConfigAll implements TextToSpeech.OnInitListener {

    private TextToSpeech mTTS;
    private TextView textView;
    private SeekBar seekBar;
    private ImageView iconeBotao;
    private ImageView iconeSom;







    //private static final String KEY_VELOCIDADE_FALA = "velocidade_fala";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidade_fala);

        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);
        iconeSom = (ImageView) findViewById(R.id.icone_som);
        textView = (TextView) findViewById(R.id.textView);

        seekBar = (SeekBar) findViewById(R.id.seekBar);





        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {

                    int resukt = mTTS.setLanguage(Locale.forLanguageTag("BR"));
                    if (resukt == TextToSpeech.LANG_MISSING_DATA

                            || resukt == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Linguagem não suportada");
                    } else {
                        iconeSom.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Falha");
                }
            }
        });


        iconeSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();

            }
        });



       // ativarOLeitorTela = ((ConfigHelper) this.getApplication()).getAtivarOLeitorTela();
        ativarOLeitorTela = sharedPreferences.getInt(KEY_ATIVAR_LEITOR_TELA, ativarOLeitorTela);
        //Executar a voz assim que entra na pagina
        if (ativarOLeitorTela == 1) {
            textToSpeech = new TextToSpeech(this,  this);
        }

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                long milliseconds = 350;
                vibrator.vibrate(milliseconds);

                //startActivity(new Intent(VelocidadeFala.this, EscolherVoz.class));
                startActivity(new Intent(VelocidadeFala.this, AlterarTomVoz.class));
            }
        });


    }

    @Override
    public void onInit(int status) {
        String falar = "Configurar a velocidade de fala"+ "\n Barra de rolagem para definir a velocidade" + "\n Botão para testar a velocidade" + "\n Botão para passar para proxima tela";
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.getDefault());
            textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    public Voice speak() {
        String text = "Configurar a velocidade de fala  ";
        float speed = (float) seekBar.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;
       // ((ConfigHelper) this.getApplication()).setVelocidadeFala(speed); // passar os dados referentes a velidade da fala

        sharedPreferences.edit().putFloat(KEY_VELOCIDADE_FALA , speed).commit();


        mTTS.setSpeechRate(speed);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        return null;
    }




    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();


    }
    @Override
    public void onPause() {
        super.onPause();

    }

        @Override
    public void onStop() {
        super.onStop();


    }
}
