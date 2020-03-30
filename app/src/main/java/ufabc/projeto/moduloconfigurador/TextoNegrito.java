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

public class TextoNegrito extends AbstractConfigAllActivity implements TextToSpeech.OnInitListener {

    //elementos da view
    private Button simBotao;
    private Button naoBotao;
    private Button testeBotao;
    private LinearLayout linearLayout;
    private TextView Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_negrito);

        Tv = (TextView) findViewById(R.id.textView2);
        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        testeBotao = (Button) findViewById(R.id.testeId);
        linearLayout = (LinearLayout) findViewById(R.id.layoutId);



        //cor texto e fundo

        linearLayout.setBackgroundColor(corTela()); // Mudando a cor da tela
        Tv.setTextColor(corTexto()); // Mudando a cor do texto
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

                Calligrapher calligrapher = new Calligrapher(TextoNegrito.this);
                calligrapher.setFont(TextoNegrito.this, "futura-extra-bold-italic.ttf", true);

                fonte = "futura-extra-bold-italic.ttf";
                click(fonte);

                startActivity(new Intent(TextoNegrito.this,ConfTamanhoFonteTexto.class));
            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                long milliseconds = 350;
                vibrator.vibrate(milliseconds);
                fonte = null;
                click(fonte);
                startActivity(new Intent(TextoNegrito.this,ConfTamanhoFonteTexto.class));
               // startActivityForResult(new Intent(Settings.ACTION_DISPLAY_SETTINGS),0); teste de ir para as configurações direto do celular
            }
        });


        testeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calligrapher calligrapher = new Calligrapher(TextoNegrito.this);
                calligrapher.setFont(TextoNegrito.this, "futura-extra-bold-italic.ttf", true);

            }
        });

    }

    public void click(String fonte){
        //Para armazenar um valor
        sharedPreferences.edit().putString(KEY_NEGRITO, fonte).commit();
    }
    @Override
    public void onInit(int status) { //FALANDO assim que abre a atividade

        String falar = "Deseja colocar o texto em negrito"+ "\n Botão de teste" + "\n Botão sim" + "\n Botão não";
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.getDefault());
            //usar a velocidade de fala
            textToSpeech.setSpeechRate(velocidadeFala());
            //usar o tom de fala
            textToSpeech.setPitch(tomFala());
            textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);
        }

    }

}
