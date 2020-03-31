package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;


public class ConfTamanhoFonteTexto extends AbstractConfigAllActivity implements TextToSpeech.OnInitListener {


    //elementos da view
    private Button simBotao;
    private Button naoBotao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_tamanho_fonte_texto);
        Tv = (TextView) findViewById(R.id.textView2);
        linearLayout = (LinearLayout) findViewById(R.id.layoutId);
        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);

        //cor texto e fundo
        linearLayout.setBackgroundColor(corTela()); // Mudando a cor da tela
        //NEGRITO
        calligrapher.setFont(this, negrito(), true);
        //Cor Fonte
        Tv.setTextColor(corTexto());
        //som


        if (ativarLeitorTela() == 1) {
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
                textToSpeech.setSpeechRate(velocidadeFala());
                textToSpeech.setPitch(tomFala());
                textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);

            }

    }

}
