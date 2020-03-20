package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;
import me.anwarshahriar.calligrapher.Calligrapher;

public class TextoNegrito extends ConfigAll implements TextToSpeech.OnInitListener {

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


        //cor texto e fundo

        TESTE();
        if(sharedPreferences.getInt(KEY_COR_TELA, corTela) != 0) {
            corTela = sharedPreferences.getInt(KEY_COR_TELA, corTela);
            linearLayout.setBackgroundColor(corTela);
        }
        if (sharedPreferences.getInt(KEY_COR_TEXTO, corText) != 0){
        corText = sharedPreferences.getInt(KEY_COR_TEXTO, corText);
        Tv.setTextColor(corText);
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

                Calligrapher calligrapher = new Calligrapher(TextoNegrito.this);
                calligrapher.setFont(TextoNegrito.this, "futura-extra-bold-italic.ttf", true);
                Log.i("@testeNegrito", "NegritoTexto - "+calligrapher);
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
            textToSpeech.setSpeechRate(velocidadeFala);
            textToSpeech.setPitch(tomFala);
            textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);
        }

    }

}
