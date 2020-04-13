package ufabc.projeto.moduloconfigurador;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;


import android.view.View.OnClickListener;

import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;


public class ExemploFonte extends AbstractConfigAllActivity implements TextToSpeech.OnInitListener{



    //elementos da view
    private ScrollView scrollView;
    private TextView Tv;
    private TextView textView;
    private SeekBar seekBar;
    private ImageView iconeBotao;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4, redefinir;
    private Typeface tf1, tf2, tf3, tf4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_fonte);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);

        scrollView = (ScrollView) findViewById(R.id.layoutId);

        textView = (TextView) findViewById(R.id.textView11);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        t1 = (TextView) findViewById(R.id.textView4);
        t2 = (TextView) findViewById(R.id.textView);
        t3 = (TextView) findViewById(R.id.textView1);
        t4 = (TextView) findViewById(R.id.textView2);
        redefinir = (TextView) findViewById(R.id.textView7);
        Tv = (TextView) findViewById(R.id.textView11);

        tf1 = Typeface.createFromAsset(getAssets(), "caveat-regular-maisfontes.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "courier-new.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "lobster.ttf");
        tf4 = Typeface.createFromAsset(getAssets(), "arial.ttf");

        t1.setTypeface(tf1);
        t2.setTypeface(tf2);
        t3.setTypeface(tf3);
        t4.setTypeface(tf4);





        //cor texto e fundo
        //TELA
        if (sharedPreferences.getInt(KEY_COR_TELA, corTela) != 0) {
            corTela = sharedPreferences.getInt(KEY_COR_TELA, corTela);
            //  corTela = ((ConfigHelper) this.getApplication()).getCorFundo();
            scrollView.setBackgroundColor(corTela);
        }
        //FONTE
        if(sharedPreferences.getString(KEY_NEGRITO, fonte) != null){
            fonte = sharedPreferences.getString(KEY_NEGRITO, fonte);
            Calligrapher calligrapher = new Calligrapher(this);
            calligrapher.setFont(this, fonte, true);
        }
        //Cor Fonte
       // if (((ConfigHelper) this.getApplication()).getCorTexto() != 0){
        if (sharedPreferences.getInt(KEY_COR_TEXTO, corText) != 0){
            corText = sharedPreferences.getInt(KEY_COR_TEXTO, corText);
            t1.setTextColor(corText);
            t2.setTextColor(corText);
            t3.setTextColor(corText);
            t4.setTextColor(corText);
            redefinir.setTextColor(corText);
            Tv.setTextColor(corText);
        }



        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calligrapher calligrapher = new Calligrapher(ExemploFonte.this);
                calligrapher.setFont(ExemploFonte.this, "caveat-regular-maisfontes.ttf", true);
                fonte = "caveat-regular-maisfontes.ttf";
                click(fonte);


            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calligrapher calligrapher = new Calligrapher(ExemploFonte.this);
                calligrapher.setFont(ExemploFonte.this, "courier-new.ttf", true);
                fonte = "courier-new.ttf";
                click(fonte);


            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
                //simBotao.setTypeface(boldTypeface);
                Calligrapher calligrapher = new Calligrapher(ExemploFonte.this);
                calligrapher.setFont(ExemploFonte.this, "lobster.ttf", true);
                fonte = "lobster.ttf";
                click(fonte);


            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
                //simBotao.setTypeface(boldTypeface);
                Calligrapher calligrapher = new Calligrapher(ExemploFonte.this);
                calligrapher.setFont(ExemploFonte.this, "arial.ttf", true);
                fonte = "arial.ttf";
                click(fonte);


            }
        });


        //som
        ativarOLeitorTela = sharedPreferences.getInt(KEY_ATIVAR_LEITOR_TELA, ativarOLeitorTela);
        velocidadeFala = sharedPreferences.getFloat(KEY_VELOCIDADE_FALA, velocidadeFala);
        tomFala = sharedPreferences.getFloat(KEY_TOM_FALA, tomFala);
        if (ativarOLeitorTela == 1) {
            textToSpeech = new TextToSpeech(this,  this);
        }


        SharedPreferences prefs = getSharedPreferences("test", MODE_PRIVATE);
        prefs = getPreferences(MODE_PRIVATE);

        float fs = prefs.getFloat("FontSize", 12);

        seekBar.setProgress((int)fs);

       // textView.setTextSize(seekBar.getProgress());




       // Settings.System.putFloat(getBaseContext().getContentResolver(),
              //  Settings.System.FONT_SCALE,(float)seekBar.getProgress()/100);

        int brilho = Settings.System.getInt(getContentResolver(),
                Settings.System.FONT_SCALE,0);
        seekBar.setProgress(brilho);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Context context = getApplicationContext();
                boolean canWrite = Settings.System.canWrite(context);
                if(canWrite) {


                           // Settings.System.putFloat(getBaseContext().getContentResolver(),
                            //Settings.System.FONT_SCALE, (float) seekBar.getProgress() / 50);
                    Settings.System.putFloat(getBaseContext().getContentResolver(),
                            Settings.System.FONT_SCALE, (float) seekBar.getProgress() / 50);

                    //textView.setTextSize(seekBar.getProgress() / 50);

                }else {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    context.startActivity(intent);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        iconeBotao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                long milliseconds = 350;
                vibrator.vibrate(milliseconds);
                //startActivity(new Intent(ExemploFonte.this, AutoDescricaoMidia.class)); caminho certo
                startActivity(new Intent(ExemploFonte.this, AtivarBrilhoAutomatico.class));
            }
        });





    }

    public void click(String fonte){

        /*Para armazenar um valor*/
        sharedPreferences.edit().putString(KEY_FONTE , fonte).commit();
    }

    @Override
    public void onInit(int status) { //FALANDO assim que abre a atividade

        int vezes =  0;
        if(vezes ==0) {
            String falar = "Frase para usar como exemplo " + "\n Botão fonte Caveat " + "\n Botão fonte Courier New" + "\n Botão fonte Lobster" + "\n Botão fonte Arial" + "\n Botão para redefinir as configurações" + "\n Barra de rolagem para definir o tamanho do texto" + "\n Botão para passar para proxima tela";
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.getDefault());
                textToSpeech.setSpeechRate(velocidadeFala);
                textToSpeech.setPitch(tomFala);
                textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);

            }
            vezes =1;
        }

    }



    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();




    }
}
