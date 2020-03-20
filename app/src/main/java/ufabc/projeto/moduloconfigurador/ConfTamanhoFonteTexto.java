package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;


public class ConfTamanhoFonteTexto extends ConfigAll implements TextToSpeech.OnInitListener {


    //elementos da view
    private Button simBotao;
    private Button naoBotao;
    private LinearLayout linearLayout;
    private TextView Tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_tamanho_fonte_texto);
        Tv = (TextView) findViewById(R.id.textView2);
        linearLayout = (LinearLayout) findViewById(R.id.layoutId);
        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);




        //corTela = ((ConfigHelper) this.getApplication()).getCorFundo();
        //cor texto e fundo
        if (sharedPreferences.getInt(KEY_COR_TELA, corTela) != 0) {
            corTela = sharedPreferences.getInt(KEY_COR_TELA, corTela);
            linearLayout.setBackgroundColor(corTela);
        }
        if (sharedPreferences.getInt(KEY_COR_TEXTO, corText) != 0) {
            //corText = ((ConfigHelper) this.getApplication()).getCorTexto();
            corText = sharedPreferences.getInt(KEY_COR_TEXTO, corText);
            Tv.setTextColor(corText);

        }
          if(sharedPreferences.getString(KEY_NEGRITO, fonte) != null){
            fonte = sharedPreferences.getString(KEY_NEGRITO, fonte);
            Calligrapher calligrapher = new Calligrapher(this);
            calligrapher.setFont(this, fonte, true);
        }





        //som
        ativarOLeitorTela = sharedPreferences.getInt(KEY_ATIVAR_LEITOR_TELA, ativarOLeitorTela);
        velocidadeFala = sharedPreferences.getFloat(KEY_VELOCIDADE_FALA, velocidadeFala);
        tomFala = sharedPreferences.getFloat(KEY_TOM_FALA, tomFala);
        if (ativarOLeitorTela == 1) {
            textToSpeech = new TextToSpeech(this,  this);
        }

        simBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                long milliseconds = 350;
                vibrator.vibrate(milliseconds);
                startActivity(new Intent(ConfTamanhoFonteTexto.this,ExemploFonte.class));
            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                long milliseconds = 350;
                vibrator.vibrate(milliseconds);
               // startActivity(new Intent(ConfTamanhoFonteTexto.this,AutoDescricaoMidia.class)); caminho certo
                startActivity(new Intent(ConfTamanhoFonteTexto.this,ExemploFonte.class));
            }
        });

    }


    @Override
    public void onInit(int status) { //FALANDO assim que abre a atividade

            String falar = "Configurar tamanho e fonte dos textos?" + "\n Botão sim" + "\n Botão não";
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.getDefault());
                textToSpeech.setSpeechRate(velocidadeFala);
                textToSpeech.setPitch(tomFala);
                textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);

            }

    }

}