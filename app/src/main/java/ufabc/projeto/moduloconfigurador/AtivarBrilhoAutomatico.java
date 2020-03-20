package ufabc.projeto.moduloconfigurador;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;

public class AtivarBrilhoAutomatico extends ConfigAll implements TextToSpeech.OnInitListener {



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
        if (sharedPreferences.getInt(KEY_COR_TELA, corTela) != 0) {
            corTela = sharedPreferences.getInt(KEY_COR_TELA, corTela);
            //  corTela = ((ConfigHelper) this.getApplication()).getCorFundo();
            linearLayout.setBackgroundColor(corTela);
        }
        //NEGRITO
        if(sharedPreferences.getString(KEY_NEGRITO, fonte) != null){
            fonte = sharedPreferences.getString(KEY_NEGRITO, fonte);
            Calligrapher calligrapher = new Calligrapher(this);
            calligrapher.setFont(this, fonte, true);
        }
        //Cor Fonte
        // if (((ConfigHelper) this.getApplication()).getCorTexto() != 0){
        if (sharedPreferences.getInt(KEY_COR_TEXTO, corText) != 0){
            corText = sharedPreferences.getInt(KEY_COR_TEXTO, corText);
            frase.setTextColor(corText);
            Tv.setTextColor(corText);
        }


       //if(((ConfigHelper) this.getApplication()).getFonte() != null){
        if(sharedPreferences.getString(KEY_FONTE , fonte) != null){
            fonte = sharedPreferences.getString(KEY_FONTE , fonte);
          //  fonte = ((ConfigHelper) this.getApplication()).getFonte();
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
            textToSpeech.setSpeechRate(velocidadeFala);
            textToSpeech.setPitch(tomFala);
            textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);
        }


    }

}
