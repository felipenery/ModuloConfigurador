package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class AtivarBrilhoAutomatico extends AbstractConfigAllActivity implements TextToSpeech.OnInitListener {



    //elementos da view
    private LinearLayout linearLayout;
    private TextView Tv;
    private TextView frase;
    private Button simBotao;
    private Button naoBotao;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativar_brilho_automatico);


        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        Tv = (TextView) findViewById(R.id.textView2);
        frase = (TextView) findViewById(R.id.textView4);
        linearLayout = (LinearLayout) findViewById(R.id.layoutId);

        //cor texto e fundo
        //TELA
        linearLayout.setBackgroundColor(corTela());
        //NEGRITO
        calligrapher.setFont(this, negrito(), true);
        //Cor Fonte
        frase.setTextColor(corTexto());
        Tv.setTextColor(corTexto());
        //Fonte
        calligrapher.setFont(this, fonte(), true);
        //som
        if (ativarLeitorTela() == 1) {
            textToSpeech = new TextToSpeech(this,  this);
        }

        simBotao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Settings.System.putInt(getBaseContext().getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS_MODE,
                        Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
                Toast toast = Toast.makeText(AtivarBrilhoAutomatico.this,"Brilho Automatico Ativado",Toast.LENGTH_LONG);
                toast.show();
                startActivity(new Intent(AtivarBrilhoAutomatico.this,TemaAltoContraste.class));



            }

        });
        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // startActivity(new Intent(AtivarBrilhoAutomatico.this,PontoBranco.class));
            }
        });
    }

    @Override
    public void onInit(int status) { //FALANDO assim que abre a atividade

        String falar = "Ativar o brilho automático ?"+ "\n Ajusta o brilho e o contraste da tela com base nos ajustes da luz ambiente" + "\n Botão sim" + "\n Botão não";
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
